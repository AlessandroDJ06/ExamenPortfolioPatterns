package be.kdg.portfolio.ex3.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainScreenView extends BorderPane {

    private ImageView numberTens;
    private ImageView numberUnit;

    private Spinner spinnerFieldMax;
    private Spinner spinnerFieldMin;
    private Button btnGenerate;

    public MainScreenView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        numberTens = new ImageView();
        numberUnit = new ImageView();
        btnGenerate = new Button("Generate");
        spinnerFieldMax = new Spinner<Integer> (1,99,6);
        spinnerFieldMin = new Spinner<Integer> (0,98,1);
    }

    private void layoutNodes() {
        btnGenerate.setPrefWidth(80);
        Label minLabel = new Label("Min:");
        Label maxLabel = new Label("Max:");
        GridPane playfield = new GridPane();
        playfield.setPadding(new Insets(10));
        playfield.setHgap(10);
        playfield.setVgap(10);
        playfield.add(minLabel, 3, 1);
        playfield.add(spinnerFieldMin, 3, 2);
        playfield.add(maxLabel, 4, 1);
        playfield.add(spinnerFieldMax, 4, 2);
        playfield.add(btnGenerate, 3, 3, 2, 1);
        GridPane.setHalignment(btnGenerate, HPos.CENTER);
        this.setCenter(playfield);
    }
    ImageView getNumberTens() { return this.numberTens; }
    ImageView getNumberUnit() { return this.numberUnit; }
    Spinner getSpinnerMin () { return this.spinnerFieldMin;}
    Spinner getSpinnerMax () { return this.spinnerFieldMax;}
    Button getBtnGenerate() { return btnGenerate; }
}