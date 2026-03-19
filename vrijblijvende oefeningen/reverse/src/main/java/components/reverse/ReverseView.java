package components.reverse;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ReverseView extends GridPane {
    private TextArea textField;
    private Button button;

    public ReverseView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.textField = new TextArea();
        this.button = new Button("reverse");
    }

    private void layoutNodes(){
        setHgap(10);
        setVgap(10);
        textField.setMaxHeight(10);
        add(textField,0,0,2,1);
        add(button,1,1);
        GridPane.setHalignment(button, HPos.RIGHT);
        setPadding(new Insets(10));
    }

    Button getButton(){
        return this.button;
    }

    TextArea getTextField(){
        return this.textField;
    }

}
