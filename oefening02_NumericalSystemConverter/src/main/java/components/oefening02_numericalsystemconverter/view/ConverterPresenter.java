package components.oefening02_numericalsystemconverter.view;


import components.oefening02_numericalsystemconverter.model.ModelConverter;

public class ConverterPresenter {
    private final ModelConverter model;
    private final ConverterView view;

    public ConverterPresenter(ModelConverter model, ConverterView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {

    }
    private void updateView() {/* fills view*/}
}