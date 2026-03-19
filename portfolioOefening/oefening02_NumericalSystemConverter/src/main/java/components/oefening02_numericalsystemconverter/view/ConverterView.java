package components.oefening02_numericalsystemconverter.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConverterView extends BorderPane {
    private TextField decimalValue;
    private Label convertedValue;
    private Label inputLabel;
    private ComboBox<String> numericalSystems;
    private Button convertButton;

    public ConverterView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        decimalValue = new TextField();
        numericalSystems = new ComboBox<>();
        convertedValue = new Label("XXXXX");
        convertButton = new Button ("Convert");
        inputLabel = new Label("Decimal input value");
    }

    private void layoutNodes() {
        HBox inputSection = new HBox(this.inputLabel,this.decimalValue);
        inputSection.setSpacing(10);
        HBox outputSection = new HBox(this.numericalSystems,this.convertedValue);
        outputSection.setSpacing(10);

        VBox pageLayout = new VBox(inputSection,outputSection);
        setCenter(pageLayout);
        BorderPane.setAlignment(pageLayout,Pos.CENTER);
        pageLayout.setPadding(new Insets(10));
        pageLayout.setSpacing(10);

        this.numericalSystems.getItems().add(0,"binary");
        this.numericalSystems.getItems().add(1,"Octal");
        this.numericalSystems.getItems().add(2,"Hex");

        setBottom(this.convertButton);
        BorderPane.setAlignment(this.convertButton, Pos.CENTER);
        this.convertButton.setPadding(new Insets(10));
    }

    TextField getDecimalValue() {
        return decimalValue;
    }

    Label getConvertedValue() {
        return convertedValue;
    }

    ComboBox<String> getNumericalSystems() {
        return numericalSystems;
    }

    Button getConvertButton() {
        return convertButton;
    }
}
