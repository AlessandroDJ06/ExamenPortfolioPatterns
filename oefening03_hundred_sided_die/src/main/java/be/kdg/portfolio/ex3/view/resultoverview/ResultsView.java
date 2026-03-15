package be.kdg.portfolio.ex3.view.resultoverview;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class ResultsView extends BorderPane {
    private TextArea resultsOverview;

    public ResultsView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.resultsOverview = new TextArea();
    }

    private void layoutNodes(){
        setTop(new Label("ResultsOverview"));
        setCenter(resultsOverview);

        resultsOverview.setEditable(false);
        resultsOverview.setWrapText(true);
    }

    TextArea getResultsOverview() {
        return resultsOverview;
    }
}
