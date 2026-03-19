package components.dices.View;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Objects;

public class DiceView extends GridPane {
    private ImageView imageView1;
    private ImageView imageView2;
    private Button button;


    public DiceView() {
        initialiseNodes();
        layoutNodes();

    }

    private void initialiseNodes() {
        this.imageView1 = new ImageView();
        this.imageView2 = new ImageView();
        this.button = new Button("Roll");
    }


    private void layoutNodes() {
        add(imageView1,0,0);
        GridPane.setHalignment(imageView1, HPos.CENTER);
        add(imageView2, 1, 0);
        GridPane.setHalignment(imageView2, HPos.CENTER);

        add(button,0,1,2,1);
        GridPane.setHalignment(button,HPos.CENTER);

        setPadding(new Insets(10));

        setHgap(10);
        setVgap(10);
    }

    Button getButton(){
        return this.button;
    }

    ImageView getImageView1(){
        return this.imageView1;
    }

    ImageView getImageView2(){
        return this.imageView2;
    }


}
