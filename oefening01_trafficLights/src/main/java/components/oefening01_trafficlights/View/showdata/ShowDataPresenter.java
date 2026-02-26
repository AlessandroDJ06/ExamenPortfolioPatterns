package components.oefening01_trafficlights.View.showdata;


import components.oefening01_trafficlights.Model.TrafficLightColor;
import components.oefening01_trafficlights.Model.TrafficLightOperations;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.time.Duration;
import java.util.List;


public class ShowDataPresenter {

    private final TrafficLightOperations model;
    private final ShowDataView view;
    public ShowDataPresenter(
            TrafficLightOperations model, ShowDataView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }
    private void addEventHandlers() {
        view.getBtnOk().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getScene().getWindow().hide();
            }
        });
    }
    private void updateView() {
        List<Duration> colorList = model.getDurationsOfAColor(TrafficLightColor.TL_RED);
        StringBuilder allInOne = new StringBuilder ("RED\t\t:");
        allInOne.append(showOneColorData(colorList));
        allInOne.append("\nGREEN\t:");
        colorList = model.getDurationsOfAColor(TrafficLightColor.TL_GREEN);
        allInOne.append(showOneColorData(colorList));
        allInOne.append("\nYELLOW\t:");
        colorList = model.getDurationsOfAColor(TrafficLightColor.TL_YELLOW);
        allInOne.append(showOneColorData(colorList));
        view.getTextWithDurations().setText(allInOne.toString());
        //System.out.println(model.getDurations());
    }
    private String showOneColorData (List<Duration> list) {
        StringBuilder oneLine = new StringBuilder("");
        for (Duration duration : list) {
            oneLine.append(" "+ duration.toMillis());
        }
        return oneLine.toString();
    }
}

