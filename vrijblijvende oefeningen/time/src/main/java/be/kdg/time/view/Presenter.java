package be.kdg.time.view;

import be.kdg.time.model.TimeModel;
import javafx.event.EventHandler;

import java.time.LocalTime;

public class Presenter {
    private TimeModel timeModel;
    private TimeView timeView;

    public Presenter(TimeModel model, TimeView view) {
        this.timeModel = model;
        this.timeView = view;
        addEventHandlers();
    }

    public void updateView(){
        timeView.applyDaylightSun(timeModel.getDaylightPercentage(),timeModel.getSunHeight(),timeModel.getSunPositionX());
    }

    public void addEventHandlers(){
        timeView.getSlider().setOnMouseDragged( mouseEvent -> {
            double time = timeView.getSlider().getValue();

            int hours = (int)time;
            int minutes = (int)Math.round((time-hours) * 60);

            LocalTime localTime = LocalTime.of(hours,minutes);
            timeModel.setCurrentTime(localTime);
            updateView();
        });
    }
}
