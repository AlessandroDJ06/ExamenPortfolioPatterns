package components.oefening01_trafficlights.View.trafficlightscreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class TrafficLightView extends BorderPane {
    // private Node attributes (controls)
    private Circle topCircle;
    private Circle middleCircle;
    private Circle bottomCircle;
    private RadioButton startRadioButton;
    private RadioButton stopRadioButton;
    private MenuItem exitMI;
    private MenuItem showDataMI;
    private Button switchColorButton;
    private Button flashingButton;



    public TrafficLightView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        topCircle = new Circle(25);
        middleCircle = new Circle(25);
        bottomCircle = new Circle(25);
        //topCircle.setFill(Color.RED);
        startRadioButton = new RadioButton("ON");
        stopRadioButton = new RadioButton("OFF");
        exitMI = new MenuItem("Exit");
        showDataMI = new MenuItem("ShowData");
        this.switchColorButton = new Button("Switch Color");
        this.flashingButton = new Button("Flashing");
    }

    private void layoutNodes() {
        // package-private Getters
        // for controls used by Presenter
        VBox lights = new VBox();
        lights.setAlignment(Pos.CENTER);
        lights.getChildren().addAll(topCircle, middleCircle, bottomCircle);
        lights.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        this.setCenter(lights);
        BorderPane.setMargin(lights,new Insets(15));
        ToggleGroup onOff = new ToggleGroup();
        startRadioButton.setToggleGroup(onOff);
        stopRadioButton.setToggleGroup(onOff);
        onOff.selectToggle(stopRadioButton);
        VBox onOffRadioButtons = new VBox();
        onOffRadioButtons.getChildren().addAll(startRadioButton, stopRadioButton);
        this.setLeft(onOffRadioButtons);
        BorderPane.setMargin(onOffRadioButtons,new Insets(15));
        Menu mainMenu = new Menu("Help",null, showDataMI, exitMI);
        MenuBar menuBar = new MenuBar(mainMenu);
        setTop(menuBar);

        VBox controls = new VBox(this.switchColorButton,this.flashingButton);
        setRight(controls);
        BorderPane.setMargin(controls,new Insets(10));
        controls.setSpacing(10);
    }

    Circle getTopCircle () {
        return this.topCircle;
    }
    Circle getMiddleCircle () {
        return this.middleCircle;
    }
    Circle getBottomCircle () {
        return this.bottomCircle;
    }
    RadioButton getStartRadioButton () {
        return startRadioButton;
    }
    RadioButton getStopRadioButton() {
        return stopRadioButton;
    }
    MenuItem getExitItem() {
        return this.exitMI;
    }
    MenuItem getshowDataItem() {
        return this.showDataMI;
    }
    Button getFlashingButton() {
        return this.flashingButton;
    }
    Button getSwitchColorButton(){
        return this.switchColorButton;
    }
}


