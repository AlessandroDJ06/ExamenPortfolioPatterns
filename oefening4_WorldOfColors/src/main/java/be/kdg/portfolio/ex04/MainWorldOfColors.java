package be.kdg.portfolio.ex04;

import be.kdg.portfolio.ex04.model.ModelWorldOfColors;
import be.kdg.portfolio.ex04.view.flagscreen.FlagScreenPresenter;
import be.kdg.portfolio.ex04.view.flagscreen.FlagScreenView;
import be.kdg.portfolio.ex04.view.randomcolorsscreen.RandomColorsScreenPresenter;
import be.kdg.portfolio.ex04.view.randomcolorsscreen.RandomColorsScreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWorldOfColors extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ModelWorldOfColors model = new ModelWorldOfColors();
        FlagScreenView view = new FlagScreenView();
        primaryStage.setScene(new Scene(view));
        new FlagScreenPresenter(model,view);
        primaryStage.show();
    }
}

