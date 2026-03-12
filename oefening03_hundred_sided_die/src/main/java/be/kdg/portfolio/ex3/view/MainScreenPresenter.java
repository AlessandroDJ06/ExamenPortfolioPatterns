package be.kdg.portfolio.ex3.view;

import be.kdg.portfolio.ex3.model.DiceThrowsSimulator;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class MainScreenPresenter {

    private DiceThrowsSimulator model;
    private MainScreenView view;

    public MainScreenPresenter(DiceThrowsSimulator model, MainScreenView view) {
        this.model = model;
        this.view = view;
        EventHandlers();
        updateView();
    }


    private void EventHandlers() {
        view.getBtnGenerate().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int maxValue = (int)view.getSpinnerMax().getValue();
                int minValue = (int)view.getSpinnerMin().getValue();
                updateView();
            }
        });
    }

    private void updateView() {
        String nameOfFileTens = "number" + model.getMultiSidedDiceValue() / 10 + ".jpg";
        String nameOfFileUnit = "number" + model.getMultiSidedDiceValue() % 10 + ".jpg";
    }
    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) { handleCloseEvent(event); }});
    }

    private void handleCloseEvent(Event event){
        final Alert stopWindow = new Alert(Alert.AlertType.CONFIRMATION);
        stopWindow.setHeaderText("You're closing the application.");
        stopWindow.setContentText("Are you sure?");
        stopWindow.setTitle("WARNING!");
        stopWindow.getButtonTypes().clear();
        ButtonType noButton = new ButtonType("No");
        ButtonType yesButton = new ButtonType("Yes");
        stopWindow.getButtonTypes().addAll(yesButton, noButton);
        stopWindow.showAndWait();
        if (stopWindow.getResult() == null || stopWindow.getResult().equals(noButton)) {
            event.consume();
        } else {
            view.getScene().getWindow().hide();
        }
    }
}

