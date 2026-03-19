package be.kdg.portfolio.ex3.view.resultoverview;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
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
        Label title = new Label("ResultsOverview");
        setTop(title);
        BorderPane.setAlignment(title, Pos.TOP_CENTER);

        setCenter(resultsOverview);


        resultsOverview.setEditable(false);
        resultsOverview.setWrapText(true);
        resultsOverview.setBackground(Background.EMPTY);
    }

    TextArea getResultsOverview() {
        return resultsOverview;
    }
}
