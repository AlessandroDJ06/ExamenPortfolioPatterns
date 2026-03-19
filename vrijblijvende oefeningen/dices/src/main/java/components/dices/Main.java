package components.dices;

import components.dices.Model.Dice;
import components.dices.View.DicePresenter;
import components.dices.View.DiceView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DiceView view = new DiceView();
        Dice model = new Dice();
        DicePresenter presenter = new DicePresenter(model,view);
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
