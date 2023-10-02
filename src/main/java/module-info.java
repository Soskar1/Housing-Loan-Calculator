module com.application.housingloancalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens com.application.housingloancalculator to javafx.fxml;
    exports com.application.housingloancalculator;
    exports com.application.housingloancalculator.calculator;
}