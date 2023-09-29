package com.application.housingloancalculator;

import com.application.housingloancalculator.calculator.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ResultWindowController {

    @FXML
    private TableView<PaymentData> paymentDataTableView;

    private InputData inputData;

    public void initialize(InputData inputData) {
        this.inputData = inputData;

        Calculator calculator;

        if (inputData.getRepaymentScheduleType() == RepaymentScheduleType.ANNUITY) {
            calculator = new AnnuityCalculator(inputData);
        } else {
            calculator = new LinearCalculator(inputData);
        }
    }
}
