package com.application.housingloancalculator;

import com.application.housingloancalculator.calculator.RepaymentScheduleType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TextField dealAmountTextField;
    @FXML private TextField annualInterestTextField;
    @FXML private Spinner<Integer> years;
    @FXML private Spinner<Integer> months;
    @FXML private ChoiceBox<RepaymentScheduleType> repaymentScheduleChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        repaymentScheduleChoiceBox.getItems().add(RepaymentScheduleType.ANNUITY);
        repaymentScheduleChoiceBox.getItems().add(RepaymentScheduleType.LINEAR);

        SpinnerValueFactory<Integer> yearFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30);
        years.setValueFactory(yearFactory);

        SpinnerValueFactory<Integer> monthFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 11);
        months.setValueFactory(monthFactory);
    }

    public void calculate(ActionEvent e) throws IOException {
        double dealAmount = Double.parseDouble(dealAmountTextField.getText());
        double annualInterest = Double.parseDouble(annualInterestTextField.getText());

        openResultWindow(new InputData(dealAmount, annualInterest, years.getValue(), months.getValue(), repaymentScheduleChoiceBox.getValue()));
    }

    private void openResultWindow(InputData inputData) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("result.fxml"));
        Parent root = fxmlLoader.load();

        ResultWindowController resultWindowController = fxmlLoader.getController();
        resultWindowController.initialize(inputData);

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Housing Loan Calculator");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}