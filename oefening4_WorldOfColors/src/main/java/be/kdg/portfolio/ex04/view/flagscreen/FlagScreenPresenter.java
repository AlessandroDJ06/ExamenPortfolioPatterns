package be.kdg.portfolio.ex04.view.flagscreen;

import be.kdg.portfolio.ex04.model.FlagType;
import be.kdg.portfolio.ex04.model.ModelWorldOfColors;
import be.kdg.portfolio.ex04.view.randomcolorsscreen.RandomColorsScreenPresenter;
import be.kdg.portfolio.ex04.view.randomcolorsscreen.RandomColorsScreenView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class FlagScreenPresenter {
    private final ModelWorldOfColors model;
    private final FlagScreenView view;

    public FlagScreenPresenter(
            ModelWorldOfColors model, FlagScreenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getGenerateButton().setOnAction(event -> {
            if (view.getVertical().isSelected()) {
                model.setFlagType(FlagType.VERTICAL);
            } else {
                model.setFlagType(FlagType.HORIZONTAL);
            }
            RandomColorsScreenView nextView = new RandomColorsScreenView();
            new RandomColorsScreenPresenter(model, nextView);
            Stage newStage = new Stage();
            newStage.setScene(new Scene(nextView));
            newStage.setTitle("Random Colors");
            Stage currentStage = (Stage) view.getScene().getWindow();
            currentStage.hide();
            newStage.setOnCloseRequest(closeEvent -> {
                currentStage.show();
            });
            newStage.setOnHiding(closeEvent -> {
                currentStage.show();
            });
            newStage.show();
        });

        view.getEndButton().setOnAction(event -> {
            showAlerts();
        });
    }
    private void showAlerts() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("message");
        alert.setHeaderText("The flag you made has following characteristics");
        alert.setContentText(model.toString());
        alert.showAndWait();
    }
}

