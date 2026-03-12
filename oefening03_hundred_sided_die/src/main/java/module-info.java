module be.kdg.portfolio.ex3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.kdg.portfolio.ex3 to javafx.fxml;
    exports be.kdg.portfolio.ex3;
}