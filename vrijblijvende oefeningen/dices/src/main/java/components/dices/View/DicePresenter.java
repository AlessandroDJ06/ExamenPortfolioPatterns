package components.dices.View;

import components.dices.Core.ImagePaths;
import components.dices.Model.Dice;
import javafx.scene.image.Image;

import java.util.Objects;

public class DicePresenter {
    private Dice model;
    private DiceView view;

    public DicePresenter(Dice model, DiceView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getButton().setOnAction(event -> {
            model.toss();
            updateView();
        });
    }

    private void updateView() {
        view.getImageView1().setImage(ImagePaths.of(model.getNumberOfPips1()));
        view.getImageView2().setImage(ImagePaths.of(model.getNumberOfPips2()));
    }

}
