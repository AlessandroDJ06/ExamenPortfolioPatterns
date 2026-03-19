package be.kdg.portfolio.ex3.view.resultoverview;

import be.kdg.portfolio.ex3.dao.DieThrow;
import be.kdg.portfolio.ex3.model.DiceThrowsSimulator;

import java.util.List;

public class ResultsPresenter {
    private DiceThrowsSimulator model;
    private ResultsView view;

    public ResultsPresenter(DiceThrowsSimulator model, ResultsView view){
        this.model = model;
        this.view = view;
        updateView();
    }


    private void updateView() {
        List<DieThrow> history = model.getThrowsArchive().getHistory();
        StringBuilder sb = new StringBuilder(
                String.format("Aantal worpen: %d \n",model.getThrowsArchive().getTotalNumberOfThrows())
        );

        for (DieThrow dt : history) {
            sb.append(dt.toString()).append("\n");
        }
        view.getResultsOverview().setText(sb.toString());
    }
}
