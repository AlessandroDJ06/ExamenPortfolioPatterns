package components.background.Views;

import components.background.Models.Background;

public class BackgroundPresenter {
    private Background model;
    private BackgroundView view;

    public BackgroundPresenter(Background model, BackgroundView view){
        this.model = model;
        this.view = view;

        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){
        view.getButton().setOnAction(e -> {
                    model.setRandomColor();
                    updateView();
                }
        );
    }

    private void updateView(){
        view.setStyle(String.format("-fx-background-color: %s;",model.getBackGroundColor()) );
    }
}
