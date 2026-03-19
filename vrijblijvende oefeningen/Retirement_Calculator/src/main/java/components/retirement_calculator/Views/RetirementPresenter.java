package components.retirement_calculator.Views;

import components.retirement_calculator.Model.Retirement;

public class RetirementPresenter {
    private Retirement model;
    private RetirementView view;

    public RetirementPresenter(Retirement model,RetirementView view){
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    public void addEventHandlers(){
        view.getButton().setOnAction(event -> {
            int number = Integer.parseInt(view.getInputField().getText());
            model.setBirthYear(number);
            System.out.println(number);
            updateView();
        });
    }

    public void updateView(){
        view.getYearLabel().setText(String.format("%d",model.getRetirementYear()));
    }
}
