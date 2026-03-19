package be.kdg.portfolio.ex3.view.aboutscreen;

import be.kdg.portfolio.ex3.model.DiceThrowsSimulator;
import be.kdg.portfolio.ex3.view.alerts.Warnings;

public class AboutScreenPresenter {
    private DiceThrowsSimulator model;
    private AboutScreenView view;

    public AboutScreenPresenter(DiceThrowsSimulator model,AboutScreenView view){
        this.view = view;
        this.model = model;
        addEVentHandlers();
        handleIOexception();
    }

    private void addEVentHandlers(){
        view.getConfirmationButton().setOnAction(event -> {
            view.getScene().getWindow().hide();
        });
    }

    private void handleIOexception(){
        if (view.getImageLoadException() != null){
            Warnings.showError(view.getImageLoadException());
        }
    }
}
