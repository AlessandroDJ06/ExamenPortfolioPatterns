module components.background {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens components.background to javafx.fxml;
    exports components.background;
    exports components.background.Views;
    opens components.background.Views to javafx.fxml;
}