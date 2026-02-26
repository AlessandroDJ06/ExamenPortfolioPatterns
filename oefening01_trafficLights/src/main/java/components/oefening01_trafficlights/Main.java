package components.oefening01_trafficlights;


import components.oefening01_trafficlights.Model.TrafficLightOperations;
import components.oefening01_trafficlights.View.trafficlightscreen.TrafficLightPresenter;
import components.oefening01_trafficlights.View.trafficlightscreen.TrafficLightView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args){
        Application.launch(args);}

    @Override
    public void start(Stage primaryStage) {
        TrafficLightOperations model = new TrafficLightOperations();
        TrafficLightView view = new TrafficLightView();
        primaryStage.setScene(new Scene(view));
        new TrafficLightPresenter(model, view);
        primaryStage.show();
    }
}
