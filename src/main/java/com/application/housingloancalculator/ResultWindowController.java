package com.application.housingloancalculator;

import com.application.housingloancalculator.calculator.*;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    public void initialize(InputData inputData) {
        Calculator calculator;

        if (inputData.getRepaymentScheduleType() == RepaymentScheduleType.ANNUITY) {
            calculator = new AnnuityCalculator(inputData);
        } else {
            calculator = new LinearCalculator(inputData);
        }

        ArrayList<PaymentData> paymentDataList = calculator.calculateAllPaymentData();
        initializeTableView(paymentDataList);
        initializeLineChart(paymentDataList);
    }

    private void initializeTableView(ArrayList<PaymentData> paymentDataList) {
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        loanBalanceColumn.setCellValueFactory(new PropertyValueFactory<>("loanBalance"));
        monthlyPaymentColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyPayment"));
        interestColumn.setCellValueFactory(new PropertyValueFactory<>("interest"));
        creditColumn.setCellValueFactory(new PropertyValueFactory<>("credit"));
        paymentDataTableView.getItems().addAll(paymentDataList);
    }

    private void initializeLineChart(ArrayList<PaymentData> paymentDataList) {
        XYChart.Series series = new XYChart.Series();

        for (PaymentData paymentData : paymentDataList) {
            series.getData().add(new XYChart.Data(Integer.toString(paymentData.getMonth()), paymentData.getMonthlyPayment()));
        }

        monthlyPaymentLineChart.getData().add(series);
    }
}