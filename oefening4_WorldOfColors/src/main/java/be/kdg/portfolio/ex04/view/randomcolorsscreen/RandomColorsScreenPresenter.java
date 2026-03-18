package be.kdg.portfolio.ex04.view.randomcolorsscreen;

import be.kdg.portfolio.ex04.model.FlagType;
import be.kdg.portfolio.ex04.model.ModelWorldOfColors;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomColorsScreenPresenter {
    private final ModelWorldOfColors model;
    private final RandomColorsScreenView view;
    private List<Color> colors;
    Random randomIndex;
    public RandomColorsScreenPresenter(ModelWorldOfColors model, RandomColorsScreenView view) {
        this.model = model;
        this.view = view;
        createListJavaFXColors();
        this.randomIndex = new Random (System.currentTimeMillis());
        addEventHandlers();
        updateView();
    }

    public void createListJavaFXColors() {
        Field[] declaredFields = Color.class.getDeclaredFields();
        this.colors = new ArrayList<>();
        for (Field field : declaredFields) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
                try {
                    this.colors.add((Color) field.get(null));
                } catch ( IllegalArgumentException | IllegalAccessException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Unable to assess colors");
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                }
            }
        }
    }
    private void changeColor (Button button){
        Color newColor = this.colors.get(randomIndex.nextInt(this.colors.size()));
        button.setBackground(new Background(new BackgroundFill(newColor, new CornerRadii(0), new Insets(0))));
    }
    private void addEventHandlers() {
        view.getButtonUpLeft().setOnMouseClicked(e ->{
            changeColor(view.getButtonUpLeft());
        });
        view.getButtonCenter().setOnMouseClicked(e ->{
            changeColor(view.getButtonCenter());
        });
        view.getButtonDownRight().setOnMouseClicked(e ->{
            changeColor(view.getButtonDownRight());
        });
        view.getButtonDone().setOnMouseClicked(e ->{
            extractColor(view.getButtonUpLeft(),0);
            extractColor(view.getButtonCenter(),1);
            extractColor(view.getButtonDownRight(),2);
            view.getScene().getWindow().hide();
        });
    }
    private void extractColor(Button button, int index){
        Paint paint = button.getBackground().getFills().get(0).getFill();
        Color backgroundColor = (Color) paint;
        model.getFlagColors()[index].setRed(backgroundColor.getRed());
        model.getFlagColors()[index].setGreen(backgroundColor.getGreen());
        model.getFlagColors()[index].setBlue(backgroundColor.getBlue());
    }
    private void updateView() {
        GridPane grid = view.getGridOfColors();
        if (model.getFlagType() == FlagType.HORIZONTAL) {
            adjustButton (view.getButtonUpLeft(),0,0,1,3);
            adjustButton (view.getButtonCenter(),1,0,1,3);
            adjustButton (view.getButtonDownRight(),2,0,1,3);
            grid.setHgap(0);
            grid.setVgap(1);
        } else {
            adjustButton (view.getButtonUpLeft(),0,0,3,1);
            adjustButton (view.getButtonCenter(),0,1,3,1);
            adjustButton (view.getButtonDownRight(),0,2,3,1);
            grid.setHgap(1);
            grid.setVgap(0);
        }
    }
    private void adjustButton (Button button, int row, int column, int spanRow, int spanColumn){
        button.setMinHeight(spanRow*40);
        button.setMinWidth(spanColumn*40);
        GridPane.setColumnIndex(button,column);
        GridPane.setRowIndex(button,row);
        GridPane.setColumnSpan(button,spanColumn);
        GridPane.setRowSpan(button,spanRow);
    }
}
