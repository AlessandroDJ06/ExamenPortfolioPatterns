package components.oefening01_trafficlights.View.showdata;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class ShowDataView extends BorderPane {
    private Button okButton;
    private TextArea textWithDurations;
    public ShowDataView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        okButton = new Button("OK");
        okButton.setPrefWidth(60);
        textWithDurations = new TextArea();
    }

    private void layoutNodes() {
        BorderPane.setAlignment(okButton, Pos.CENTER);
        setBottom(okButton);
        BorderPane.setMargin(okButton,new Insets(15));
        BorderPane.setAlignment(textWithDurations, Pos.CENTER);
        setCenter(textWithDurations);
        BorderPane.setMargin(textWithDurations,new Insets(15));
    }
    Button getBtnOk() { return okButton; }
    TextArea getTextWithDurations () {return textWithDurations;}
}

