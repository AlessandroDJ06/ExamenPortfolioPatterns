package components.oefening02_numericalsystemconverter;


import components.oefening02_numericalsystemconverter.model.ModelConverter;
import components.oefening02_numericalsystemconverter.view.ConverterPresenter;
import components.oefening02_numericalsystemconverter.view.ConverterView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) {
        ModelConverter model = new ModelConverter();
        ConverterView view = new ConverterView();
        primaryStage.setScene(new Scene(view));
        new ConverterPresenter(model, view);
        primaryStage.show();
    }
}
