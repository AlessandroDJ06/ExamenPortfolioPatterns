module components.retirement_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens components.retirement_calculator to javafx.fxml;
    exports components.retirement_calculator;
}