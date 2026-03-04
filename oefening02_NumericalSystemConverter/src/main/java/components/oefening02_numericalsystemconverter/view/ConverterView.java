package components.oefening02_numericalsystemconverter.view;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ConverterView extends BorderPane {
    private TextField decimalValue;
    private Label convertedValue;
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
    }

    private void layoutNodes() {

    }


}
