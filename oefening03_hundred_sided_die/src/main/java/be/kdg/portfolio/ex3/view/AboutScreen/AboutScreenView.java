package be.kdg.portfolio.ex3.view.AboutScreen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.io.InputStream;


public class AboutScreenView extends BorderPane {
    private ImageView diceImageView;
    private Button confirmationButton;
    private Exception imageLoadException;

    public AboutScreenView(){
        initialiseNodes();
        layoutNodes();
    }

    public void initialiseNodes(){
        this.diceImageView = new ImageView();
        this.confirmationButton = new Button("ok");
        this.imageLoadException = null;
    }

    public void layoutNodes(){
        try {
            InputStream is =getClass().getResourceAsStream("/images/dic100.png");
            if ( is == null) throw new IOException("Bestand niet gevonden");
            diceImageView.setImage(new Image(is));
        } catch (IOException e) {
            this.imageLoadException = e;
        }

        setCenter(diceImageView);
        setBottom(confirmationButton);
        BorderPane.setAlignment(confirmationButton, Pos.BOTTOM_RIGHT);
    }

    public Exception getImageLoadException() {
        return imageLoadException;
    }

    public Button getConfirmationButton() {
        return confirmationButton;
    }
}
