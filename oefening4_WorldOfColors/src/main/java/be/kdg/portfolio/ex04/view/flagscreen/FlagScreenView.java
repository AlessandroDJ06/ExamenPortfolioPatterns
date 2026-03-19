package be.kdg.portfolio.ex04.view.flagscreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FlagScreenView extends BorderPane {
    RadioButton horizontal;
    RadioButton vertical;
    Button generateButton;
    Button endButton;
    public FlagScreenView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        horizontal = new RadioButton("Horizontal banners");
        vertical = new RadioButton("Vertical banners");
    }
    private void layoutNodes() {
        BorderPane centralPane = new BorderPane();
        Label title = new Label("Create a new 3 color Flag");
        title.setStyle("-fx-background-color: aqua");
        title.setStyle("-fx-font-size: 18");
        title.setPadding(new Insets(10));
        Label info = new Label("Make a choice:");
        ToggleGroup typeOfFlag = new ToggleGroup();

        horizontal.setToggleGroup(typeOfFlag);
        vertical.setToggleGroup(typeOfFlag);
        generateButton = new Button ("Generate Flag");
        endButton = new Button ("End Program");

        HBox navigation = new HBox(generateButton,endButton);
        BorderPane.setAlignment(navigation, Pos.CENTER);
        VBox buttons = new VBox(horizontal,vertical);
        BorderPane.setAlignment(buttons,Pos.CENTER_RIGHT);
        centralPane.setCenter(buttons);
        centralPane.setBottom(navigation);
        centralPane.setTop(title);
        centralPane.setLeft(info);
        this.setPadding(new Insets(10));
        this.setMargin(info, new Insets(0,20,0,0));

        setCenter(centralPane);
    }
    RadioButton getHorizontal (){
        return this.horizontal;
    }
    RadioButton getVertical(){
        return vertical;
    }
    Button getGenerateButton (){
        return generateButton;
    }
    Button getEndButton (){
        return endButton;
    }
}
