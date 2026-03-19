package components.retirement_calculator.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class RetirementView extends BorderPane {
    private TextField inputField;
    private Button button;
    private Label yearLabel;
    private Insets insets;

    public RetirementView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.inputField = new TextField();
        this.button = new Button("BirtYear > RetirementYear");
        this.yearLabel = new Label();
        this.insets = new Insets(10);
    }

    private void layoutNodes(){
        setPadding(this.insets);
        setLeft(this.inputField);
        BorderPane.setAlignment(this.inputField, Pos.CENTER_LEFT);
        setMargin(this.inputField,this.insets);
        this.inputField.setPrefColumnCount(4);

        setCenter(this.button);
        BorderPane.setAlignment(this.button,Pos.CENTER);
        setMargin(this.button,this.insets);

        setRight(this.yearLabel);
        BorderPane.setAlignment(this.yearLabel,Pos.CENTER_RIGHT);
        setMargin(this.yearLabel,this.insets);
    }

    TextField getInputField() {
        return inputField;
    }

    Button getButton() {
        return button;
    }

    Label getYearLabel() {
        return yearLabel;
    }
}
