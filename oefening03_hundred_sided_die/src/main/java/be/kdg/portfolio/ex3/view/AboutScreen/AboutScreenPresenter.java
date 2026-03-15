package be.kdg.portfolio.ex3.view.AboutScreen;

import be.kdg.portfolio.ex3.model.DiceThrowsSimulator;
import be.kdg.portfolio.ex3.view.Alerts.Warnings;

public class AboutScreenPresenter {
    private DiceThrowsSimulator model;
    private AboutScreenView view;
    private final Warnings WARNINGS;

    public AboutScreenPresenter(DiceThrowsSimulator model,AboutScreenView view){
        this.view = view;
        this.model = model;
        this.WARNINGS = new Warnings();
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
            WARNINGS.showError(view.getImageLoadException());
        }
    }
}
