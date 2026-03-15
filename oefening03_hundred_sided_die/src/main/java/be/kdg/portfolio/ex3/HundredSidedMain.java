package be.kdg.portfolio.ex3;

import be.kdg.portfolio.ex3.model.DiceThrowsSimulator;
import be.kdg.portfolio.ex3.view.mainscreen.MainScreenPresenter;
import be.kdg.portfolio.ex3.view.mainscreen.MainScreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HundredSidedMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        DiceThrowsSimulator model = new DiceThrowsSimulator();
        MainScreenView view = new MainScreenView();
        MainScreenPresenter presenter = new MainScreenPresenter(model, view);
        Scene scene = new Scene(view);

        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.setTitle("1- to 100-Sided Dice");


        presenter.windowsHandler();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
