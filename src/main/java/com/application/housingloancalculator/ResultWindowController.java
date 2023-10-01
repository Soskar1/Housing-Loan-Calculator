package com.application.housingloancalculator;

import com.application.housingloancalculator.calculator.*;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ResultWindowController {

    @FXML private TableView<PaymentData> paymentDataTableView;
    @FXML private TableColumn<PaymentData, Integer> monthColumn;
    @FXML private TableColumn<PaymentData, Double> loanBalanceColumn;
    @FXML private TableColumn<PaymentData, Double> monthlyPaymentColumn;
    @FXML private TableColumn<PaymentData, Double> interestColumn;
    @FXML private TableColumn<PaymentData, Double> creditColumn;
    @FXML private LineChart<Integer, Double> monthlyPaymentLineChart;

    @FXML private Spinner<Integer> deferralStartMonth;
    @FXML private Spinner<Integer> deferralDuration;
    @FXML private TextField deferralInterest;

    @FXML private Spinner<Integer> filterMonthFrom;
    @FXML private Spinner<Integer> filterMonthTo;

    private InputData inputData;
    private Calculator calculator;

    public void initialize(InputData inputData) {
        this.inputData = inputData;
        initializeTableView();
        updateSpinners();

        if (inputData.getRepaymentScheduleType() == RepaymentScheduleType.ANNUITY) {
            calculator = new AnnuityCalculator(inputData);
        } else {
            calculator = new LinearCalculator(inputData);
        }

        ArrayList<PaymentData> paymentDataList = calculator.calculateAllPaymentData();
        display(paymentDataList);
    }

    private void initializeTableView() {
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        loanBalanceColumn.setCellValueFactory(new PropertyValueFactory<>("loanBalance"));
        monthlyPaymentColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyPayment"));
        interestColumn.setCellValueFactory(new PropertyValueFactory<>("interest"));
        creditColumn.setCellValueFactory(new PropertyValueFactory<>("credit"));
    }

    private void updateSpinners() {
        int totalMonths = inputData.getTotalMonths();

        ArrayList<Deferral> deferrals = inputData.getDeferrals();
        for (Deferral deferral : deferrals) {
            totalMonths += deferral.getDuration();
        }

        SpinnerValueFactory<Integer> deferralStartMonthFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, totalMonths);
        deferralStartMonth.setValueFactory(deferralStartMonthFactory);

        SpinnerValueFactory<Integer> deferralDurationFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
        deferralDuration.setValueFactory(deferralDurationFactory);

        SpinnerValueFactory<Integer> filterMonthFromFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, totalMonths);
        filterMonthFromFactory.setValue(1);
        filterMonthFrom.setValueFactory(filterMonthFromFactory);

        SpinnerValueFactory<Integer> filterMonthToFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, totalMonths);
        filterMonthToFactory.setValue(totalMonths);
        filterMonthTo.setValueFactory(filterMonthToFactory);
    }

    private void display(ArrayList<PaymentData> paymentDataList) {
        paymentDataTableView.getItems().setAll(paymentDataList);
        setLineChart(paymentDataList);
    }

    private void setLineChart(ArrayList<PaymentData> paymentDataList) {
        monthlyPaymentLineChart.getData().clear();

        XYChart.Series series = new XYChart.Series();

        for (PaymentData paymentData : paymentDataList) {
            series.getData().add(new XYChart.Data(Integer.toString(paymentData.getMonth()), paymentData.getMonthlyPayment()));
        }

        monthlyPaymentLineChart.getData().add(series);
    }

    public void addDeferral() {
        if (deferralInterest.getText().isEmpty() || deferralDuration.getValue() == 0 || deferralStartMonth.getValue() == 0) {
            return;
        }

        int startMonth = deferralStartMonth.getValue();
        int duration = deferralDuration.getValue();

        if (checkForCollisions(startMonth, duration)) {
            System.out.println("collision!");
            return;
        }

        String deferralInterestText = deferralInterest.getText();
        double deferralInterest = Double.parseDouble(deferralInterestText);

        Deferral deferral = new Deferral(startMonth, duration, deferralInterest);
        inputData.addDeferral(deferral);

        ArrayList<PaymentData> paymentDataList = calculator.calculateAllPaymentData();

        display(paymentDataList);
        updateSpinners();
    }

    private boolean checkForCollisions(int startMonth, int duration) {
        ArrayList<Deferral> deferrals = inputData.getDeferrals();
        int endMonth = startMonth + duration - 1;

        for (Deferral deferral : deferrals) {
            int deferralEndMonth = deferral.getStartMonth() + deferral.getDuration() - 1;

            if (startMonth == deferral.getStartMonth() || endMonth == deferral.getStartMonth() || startMonth == deferralEndMonth) {
                return true;
            }

            if (startMonth < deferral.getStartMonth() && deferral.getStartMonth() < endMonth) {
                return true;
            }

            if (startMonth > deferral.getStartMonth() && deferralEndMonth > startMonth) {
                return true;
            }
        }

        return false;
    }
}