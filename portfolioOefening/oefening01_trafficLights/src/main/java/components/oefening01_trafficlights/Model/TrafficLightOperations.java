package components.oefening01_trafficlights.Model;

import components.oefening01_trafficlights.utils.Observable;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;

public class TrafficLightOperations extends Observable {

    // private attributes
    private TrafficLight trafficLight;
    private Map<TrafficLightColor, List<Duration>> durations;
    LocalTime startTime;
    LocalTime endTime;
    private boolean flashingVisible = true;
    // Constructor(s)
    public TrafficLightOperations() {
        trafficLight = new TrafficLight();
        durations = new HashMap<>();
        durations.put(TrafficLightColor.TL_GREEN, new ArrayList<>());
        durations.put(TrafficLightColor.TL_YELLOW, new ArrayList<>());
        durations.put(TrafficLightColor.TL_RED, new ArrayList<>());
    }
    // methods with business logic
    public boolean isTrafficLightOn () {
        return this.trafficLight.getTrafficLightStatus() == TrafficLightStatus.LIGHT_ON;
    }
    public boolean isTrafficLightGreen () {
        return  isTrafficLightOn() && this.trafficLight.getTrafficLightColor() == TrafficLightColor.TL_GREEN;
    }
    public boolean isTrafficLightYellow () {
        return  isTrafficLightOn() && this.trafficLight.getTrafficLightColor() == TrafficLightColor.TL_YELLOW;
    }
    public boolean isTrafficLightRed () {
        return  isTrafficLightOn() && this.trafficLight.getTrafficLightColor() == TrafficLightColor.TL_RED;
    }
    public void switchTrafficLightOn () {
        this.trafficLight.setTrafficLightStatus(true);
        startTime = now();
        notifyObservers(null);
    }
    public void switchTrafficLightOff () {
        this.trafficLight.setTrafficLightStatus(false);
        this.endTime = now();
        addDuration();
        notifyObservers(null);
    }
    public void trafficLightNextColor() {
        this.endTime = now();
        addDuration();
        this.trafficLight.nextColor();
        this.startTime = now();
        notifyObservers(null);
    }

    public void toggleFlashingVisibility() {
        this.flashingVisible = !this.flashingVisible;
        notifyObservers(null); // 2. Verstuur het seintje!
    }

    public boolean isFlashingVisible() {
        return flashingVisible;
    }
    private void addDuration() {
        List<Duration> listOfDurations = this.durations.get(this.trafficLight.getTrafficLightColor());
        Duration difference = (Duration.between(this.startTime, this.endTime));
        listOfDurations.add(difference);
        this.durations.put(this.trafficLight.getTrafficLightColor(),listOfDurations);
    }
    public Map<TrafficLightColor, List<Duration>> getDurations() {
        return durations;
    }
    public List<Duration> getDurationsOfAColor(TrafficLightColor color) {
        return durations.get(color);
    }

    public boolean isTrafficLightFlashing(){
        return this.trafficLight.getFlashingStatus().equals(FlashingStatus.FLASHING_ON);
    }

    public void switchTrafficLightFlashingOn(){
        this.trafficLight.setFlashingStatus(true);
        notifyObservers(null);
    }

    public void switchTrafficLightFlashingOff(){
        this.trafficLight.setFlashingStatus(false);
        notifyObservers(null);
    }

}


