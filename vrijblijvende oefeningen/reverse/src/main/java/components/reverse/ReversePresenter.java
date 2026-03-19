package components.reverse;

public class ReversePresenter {
    private Reverse model;
    private ReverseView view;

    public ReversePresenter(Reverse model,ReverseView view){
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers(){
        view.getButton().setOnAction(event -> {
            model.setText(view.getTextField().getText());
            model.reverseText();
            updateView();
        });
    }

    private void updateView(){
        view.getTextField().setText(model.getText());
    }
}
