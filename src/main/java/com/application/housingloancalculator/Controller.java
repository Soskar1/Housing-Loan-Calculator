package com.application.housingloancalculator;

import com.application.housingloancalculator.charts.ChartType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField dealAmountTextField;
    @FXML
    private TextField annualInterestTextField;
    @FXML
    private TextField yearsTextField;
    @FXML
    private TextField monthsTextField;
    @FXML
    private ChoiceBox<ChartType> chartTypeChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chartTypeChoiceBox.getItems().add(ChartType.ANNUITY);
        chartTypeChoiceBox.getItems().add(ChartType.LINEAR);
    }

    public void calculate(ActionEvent e) {
        Integer.parseInt(dealAmountTextField.getText());
        Integer.parseInt(annualInterestTextField.getText());
        Integer.parseInt(yearsTextField.getText());
        Integer.parseInt(monthsTextField.getText());
    }
}