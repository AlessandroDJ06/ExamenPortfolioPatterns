package components.background.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BackgroundView extends BorderPane {
    private Button button;
    public BackgroundView(){
        this.button = new Button("repaint");
        setBottom(button);
        BorderPane.setAlignment(button, Pos.BOTTOM_RIGHT);
        setPadding(new Insets(10));
    }

    public Button getButton(){
        return this.button;
    }
}
