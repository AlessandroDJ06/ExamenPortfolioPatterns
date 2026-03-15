package be.kdg.portfolio.ex3.view.MainScreen;

import be.kdg.portfolio.ex3.model.DiceThrowsSimulator;
import be.kdg.portfolio.ex3.view.AboutScreen.AboutScreenPresenter;
import be.kdg.portfolio.ex3.view.AboutScreen.AboutScreenView;
import be.kdg.portfolio.ex3.view.Alerts.Warnings;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.InputStream;

public class MainScreenPresenter {

    private DiceThrowsSimulator model;
    private MainScreenView view;
    private final Warnings WARNINGS;
    private StackPane numberOfTens;
    private StackPane numberOfUnits;

    public MainScreenPresenter(DiceThrowsSimulator model, MainScreenView view) {
        this.model = model;
        this.view = view;
        this.WARNINGS = new Warnings();
        this.numberOfTens = this.view.getNumberTens();
        this.numberOfUnits = this.view.getNumberUnit();
        EventHandlers();
        updateView();
    }


    private void EventHandlers() {
        view.getBtnGenerate().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int maxValue = (int)view.getSpinnerMax().getValue();
                int minValue = (int)view.getSpinnerMin().getValue();
                try{
                    model.multiSidedDiceThrow(minValue,maxValue);
                } catch (IllegalArgumentException e){
                    WARNINGS.showError(e);
                }
                updateView();
            }
        });

        view.getAbout().setOnAction(event -> {
            AboutScreenView aboutView = new AboutScreenView();
            AboutScreenPresenter aboutPresenter = new AboutScreenPresenter(model,aboutView);
            Stage aboutStage = new Stage();
            aboutStage.initOwner(view.getScene().getWindow());
            aboutStage.initModality(Modality.APPLICATION_MODAL);
            aboutStage.setScene(new Scene(aboutView));
            aboutStage.showAndWait();
        });

        view.getExit().setOnAction(event -> {
            WARNINGS.handleCloseEvent(event,view);
        });
    }

    private void updateView() {
        String nameOfFileTens = "number" + model.getMultiSidedDiceValue() / 10 + ".jpg";
        String nameOfFileUnit = "number" + model.getMultiSidedDiceValue() % 10 + ".jpg";
        InputStream tens =getClass().getResourceAsStream("/images/"+nameOfFileTens);
        InputStream units =getClass().getResourceAsStream("/images/"+nameOfFileUnit);


        if (numberOfTens.getChildren().isEmpty()){
            try {
                if ( tens == null) throw new IOException("Bestand niet gevonden: " + nameOfFileTens);
                numberOfTens.getChildren().add(new ImageView(new Image(tens)));
            } catch (IOException e) {
                numberOfTens.getChildren().add(new Label(String.format("%d",model.getMultiSidedDiceValue() / 10)));
            }

        } else if (numberOfTens.getChildren().getFirst() instanceof ImageView){
            ((ImageView) numberOfTens.getChildren().getFirst()).setImage(
                    new Image(tens)
            );

        } else if (numberOfTens.getChildren().getFirst() instanceof Label) {
            ((Label) numberOfTens.getChildren().getFirst()).setText(
                    String.format("%d",model.getMultiSidedDiceValue() / 10)
            );

        }

        if (numberOfUnits.getChildren().isEmpty()){
            try {
                if ( units == null) throw new IOException("Bestand niet gevonden: " + nameOfFileUnit);
                numberOfUnits.getChildren().add(
                        new ImageView(new Image(units))
                );
            } catch (IOException e) {
                numberOfUnits.getChildren().add(
                        new Label(String.format("%d",model.getMultiSidedDiceValue() % 10))
                );
            }
        } else if (numberOfUnits.getChildren().getFirst() instanceof ImageView){
            ((ImageView) view.getNumberUnit().getChildren().getFirst()).setImage(
                    new Image(units)
            );
        } else if (numberOfUnits.getChildren().getFirst() instanceof Label) {
            ((Label) view.getNumberUnit().getChildren().getFirst()).setText(
                    String.format("%d",model.getMultiSidedDiceValue() % 10)
            );
        }

    }


    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) { WARNINGS.handleCloseEvent(event,view); }});
    }


}

