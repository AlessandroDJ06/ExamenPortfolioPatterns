package be.kdg.portfolio.ex3.view.resultoverview;

import be.kdg.portfolio.ex3.model.DiceThrowsSimulator;
import be.kdg.portfolio.ex3.view.alerts.Warnings;

public class ResultsPresenter {
    private DiceThrowsSimulator model;
    private ResultsView view;

    public ResultsPresenter(DiceThrowsSimulator model, ResultsView view){
        this.model = model;
        this.view = view;
        updateView();
    }


    private void updateView(){
        view.getResultsOverview().setText(model.getThrowsArchive().getHistory().toString());
    }
}
