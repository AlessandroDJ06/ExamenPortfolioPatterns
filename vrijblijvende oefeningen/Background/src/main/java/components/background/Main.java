package components.background;

import components.background.Models.Background;
import components.background.Views.BackgroundPresenter;
import components.background.Views.BackgroundView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BackgroundView view = new BackgroundView();
        Background model = new Background();
        BackgroundPresenter presenter = new BackgroundPresenter(model,view);

        Scene scene = new Scene(view,400,250);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("background");

    }

    public static void main(String[] args) {
        Application.launch();
    }
}
