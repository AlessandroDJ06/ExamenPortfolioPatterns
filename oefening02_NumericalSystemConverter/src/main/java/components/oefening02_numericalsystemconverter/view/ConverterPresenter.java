package components.oefening02_numericalsystemconverter.view;


import components.oefening02_numericalsystemconverter.model.ModelConverter;
import javafx.scene.control.Alert;

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
        view.getConvertButton().setOnAction(event -> {
            try{
                model.convertToNumericalSystem(
                        view.getDecimalValue().getText(),
                        ModelConverter.NumericalSystems.values()[view.getNumericalSystems().getSelectionModel().getSelectedIndex()]
                );
            } catch (IllegalArgumentException exc){
                showError(exc);
            }
        });
    }
    private void updateView() {
        view.getConvertedValue().setText(
                model.getResultvalue());
    }

    private void showError(Exception exc){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText(exc.getMessage());
        alert.showAndWait();
    }

}