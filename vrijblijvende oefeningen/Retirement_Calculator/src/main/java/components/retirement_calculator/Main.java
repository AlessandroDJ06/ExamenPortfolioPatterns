package components.retirement_calculator;

import components.retirement_calculator.Model.Retirement;
import components.retirement_calculator.Views.RetirementPresenter;
import components.retirement_calculator.Views.RetirementView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        RetirementView view = new RetirementView();
        Retirement model = new Retirement();
        RetirementPresenter presenter = new RetirementPresenter(model,view);
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
