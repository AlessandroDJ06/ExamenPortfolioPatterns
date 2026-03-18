package be.kdg.portfolio.ex04.view.flagscreen;

import be.kdg.portfolio.ex04.model.FlagType;
import be.kdg.portfolio.ex04.model.ModelWorldOfColors;

public class FlagScreenPresenter {
    private final ModelWorldOfColors model;
    private final FlagScreenView view;

    public FlagScreenPresenter(
            ModelWorldOfColors model, FlagScreenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getGenerateButton().setOnMouseClicked(e -> {
            if (view.getVertical().isSelected()) {
                model.setFlagType(FlagType.VERTICAL);
            } else {
                model.setFlagType(FlagType.HORIZONTAL);
            }
        });
    }
    private void updateView() {

    }
}

