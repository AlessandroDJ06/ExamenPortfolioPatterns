package components.reverse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Reverse model = new Reverse("Enter text here");
        ReverseView view = new ReverseView();
        ReversePresenter presenter = new ReversePresenter(model,view);
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
