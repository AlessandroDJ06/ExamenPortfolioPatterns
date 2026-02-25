module components.oefening01_traffic_lights {
    requires javafx.controls;
    requires javafx.fxml;


    opens components.oefening01_traffic_lights to javafx.fxml;
    exports components.oefening01_traffic_lights;
}