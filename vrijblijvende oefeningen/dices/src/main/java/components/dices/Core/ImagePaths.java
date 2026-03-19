package components.dices.Core;

import javafx.scene.image.Image;

import java.util.Objects;

public enum ImagePaths {
    DIE1("/assets/die1.png"),
    DIE2("/assets/die2.png"),
    DIE3("/assets/die3.png"),
    DIE4("/assets/die4.png"),
    DIE5("/assets/die5.png"),
    DIE6("/assets/die6.png");

    private final Image image;

    ImagePaths(String path){
        this.image=new Image(getClass().getResourceAsStream(path));
    }

    public Image getImage(){
        return this.image;
    }

    public static Image of(int value) {
        return values()[value - 1].getImage();
    }
}
