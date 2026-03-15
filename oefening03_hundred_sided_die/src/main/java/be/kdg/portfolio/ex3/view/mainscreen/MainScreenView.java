package be.kdg.portfolio.ex3.view.mainscreen;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MainScreenView extends BorderPane {

    private StackPane numberTens;
    private StackPane numberUnit;

    private Spinner spinnerFieldMax;
    private Spinner spinnerFieldMin;
    private Button btnGenerate;

    private MenuBar menu;
    private Menu help;
    private MenuItem about;
    private MenuItem exit;
    private Menu results;
    private MenuItem overviewResults;


    public MainScreenView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        numberTens = new StackPane();
        numberUnit = new StackPane();
        btnGenerate = new Button("Generate");
        spinnerFieldMax = new Spinner<Integer> (1,99,6);
        spinnerFieldMin = new Spinner<Integer> (0,98,1);
        menu = new MenuBar();
        help = new Menu("help");
        about = new MenuItem("about");
        exit = new MenuItem("exit");
        results = new Menu("results");
        overviewResults = new MenuItem("results overview");
    }

    private void layoutNodes() {
        setTop(menu);
        menu.getMenus().addAll(help,results);
        help.getItems().addAll(about,exit);
        results.getItems().add(overviewResults);


        btnGenerate.setPrefWidth(80);
        Label minLabel = new Label("Min:");
        Label maxLabel = new Label("Max:");
        GridPane playfield = new GridPane();
        playfield.setPadding(new Insets(10));
        playfield.add(numberTens,3,0);
        playfield.add(numberUnit,4,0);
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
    StackPane getNumberTens() { return this.numberTens; }
    StackPane getNumberUnit() { return this.numberUnit; }
    Spinner getSpinnerMin () { return this.spinnerFieldMin;}
    Spinner getSpinnerMax () { return this.spinnerFieldMax;}
    Button getBtnGenerate() { return btnGenerate; }

    public MenuItem getAbout() {
        return about;
    }

    public MenuItem getExit() {
        return exit;
    }

    public MenuItem getOverviewResults() {
        return overviewResults;
    }
}