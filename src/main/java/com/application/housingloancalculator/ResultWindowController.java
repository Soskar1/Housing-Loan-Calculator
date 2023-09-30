package com.application.housingloancalculator;

import com.application.housingloancalculator.calculator.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResultWindowController {

    @FXML private TableView<PaymentData> paymentDataTableView;
    @FXML private TableColumn<PaymentData, Integer> monthColumn;
    @FXML private TableColumn<PaymentData, Double> loanBalanceColumn;
    @FXML private TableColumn<PaymentData, Double> monthlyPaymentColumn;
    @FXML private TableColumn<PaymentData, Double> interestColumn;
    @FXML private TableColumn<PaymentData, Double> creditColumn;

    private InputData inputData;

    public void initialize(InputData inputData) {
        this.inputData = inputData;

        Calculator calculator;

        if (inputData.getRepaymentScheduleType() == RepaymentScheduleType.ANNUITY) {
            calculator = new AnnuityCalculator(inputData);
        } else {
            calculator = new LinearCalculator(inputData);
        }

        monthColumn.setCellValueFactory(new PropertyValueFactory<PaymentData, Integer>("month"));
        loanBalanceColumn.setCellValueFactory(new PropertyValueFactory<PaymentData, Double>("loanBalance"));
        monthlyPaymentColumn.setCellValueFactory(new PropertyValueFactory<PaymentData, Double>("monthlyPayment"));
        interestColumn.setCellValueFactory(new PropertyValueFactory<PaymentData, Double>("interest"));
        creditColumn.setCellValueFactory(new PropertyValueFactory<PaymentData, Double>("credit"));
    }
}
