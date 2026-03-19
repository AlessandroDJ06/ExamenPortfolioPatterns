module be.kdg.time {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.kdg.time to javafx.fxml;
    exports be.kdg.time;
}