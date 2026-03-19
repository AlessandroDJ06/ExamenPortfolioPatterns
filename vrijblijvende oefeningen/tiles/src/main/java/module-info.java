module be.kdg.tiles {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.kdg.tiles to javafx.fxml;
    exports be.kdg.tiles;
}