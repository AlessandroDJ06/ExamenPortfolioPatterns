package be.kdg.portfolio.ex04.view.randomcolorsscreen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class RandomColorsScreenView extends BorderPane {
    Button buttonUpLeft;
    Button buttonCenter;
    Button buttonDownRight;
    GridPane gridOfColors;
    Button buttonDone;
    public RandomColorsScreenView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        buttonUpLeft = new Button();
        buttonCenter = new Button();
        buttonDownRight= new Button();
        this.gridOfColors = new GridPane();
        this.gridOfColors.setMinSize(3,3);
        buttonDone = new Button("Done");
    }
    private void layoutNodes() {
        this.buttonUpLeft.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0))));
        this.buttonCenter.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0))));
        this.buttonDownRight.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0))));
        this.gridOfColors.add(buttonUpLeft,0,0);
        this.gridOfColors.add(buttonCenter,1,1);
        this.gridOfColors.add(buttonDownRight,2,2);
        buttonDone.setMaxWidth(Double.MAX_VALUE);
        this.setCenter(this.gridOfColors);
        this.setBottom(this.buttonDone);
    }
    Button getButtonUpLeft() {
        return buttonUpLeft;
    }
    Button getButtonCenter() {
        return buttonCenter;
    }
    Button getButtonDownRight() {
        return buttonDownRight;
    }
    GridPane getGridOfColors () {
        return this.gridOfColors;
    }
    Button getButtonDone () {
        return this.buttonDone;
    }
}
