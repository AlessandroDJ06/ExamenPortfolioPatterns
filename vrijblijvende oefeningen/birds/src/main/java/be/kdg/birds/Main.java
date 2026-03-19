package be.kdg.birds;

import be.kdg.birds.View.birdView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.show();
        Scene scene = new Scene(new birdView());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/angrybird.png"));


	}
}
