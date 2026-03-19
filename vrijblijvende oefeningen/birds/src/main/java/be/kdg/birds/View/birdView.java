package be.kdg.birds.View;

import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class birdView extends BorderPane {
    public birdView(){
        Image image = new Image("/angrybird.png");
        Image image1 = new Image("/profile-button2.png");
        ImageView icon = new ImageView(image1);

        

        MenuBar menuBar = new MenuBar();

        Menu file = new Menu("File");
        menuBar.getMenus().add(file);
        file.setGraphic(new ImageView(image));
        setTop(menuBar);

        MenuItem menuItem = new MenuItem("Bird");
        menuItem.setGraphic(new ImageView(image));
        file.getItems().add(menuItem);

        CheckBox checkBox = new CheckBox();
        checkBox.setGraphic(icon);

        checkBox.setOnMouseEntered(e -> {
            checkBox.setScaleX(1.1);
            checkBox.setScaleY(1.1);
            checkBox.setCursor(Cursor.HAND);
        });

        checkBox.setOnMouseExited(e -> {
            checkBox.setScaleX(1.0);
            checkBox.setScaleY(1.0);
        });

        setCenter(checkBox);
    }


}
