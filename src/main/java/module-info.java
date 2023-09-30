module com.application.housingloancalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.application.housingloancalculator to javafx.fxml;
    exports com.application.housingloancalculator;
    exports com.application.housingloancalculator.calculator;
}