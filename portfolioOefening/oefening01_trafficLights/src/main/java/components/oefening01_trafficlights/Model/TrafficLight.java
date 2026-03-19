package components.oefening01_trafficlights.Model;

public class TrafficLight {
    private TrafficLightStatus trafficLightStatus;
    private TrafficLightColor trafficLightColor;
    private FlashingStatus flashingStatus;

    public TrafficLight() {
        this(false);
        setFlashingStatus(false);
    }
    public TrafficLight(boolean status) {
        setTrafficLightStatus (status);
        setFlashingStatus(false);
    }
    public void setTrafficLightStatus (boolean status) {
        if (status) {
            this.trafficLightStatus = TrafficLightStatus.LIGHT_ON;
            this.trafficLightColor = TrafficLightColor.TL_RED;
        } else this.trafficLightStatus = TrafficLightStatus.LIGHT_OFF;
    }

    public void setFlashingStatus(boolean flashingStatus) {
        if (flashingStatus){
            this.flashingStatus = FlashingStatus.FLASHING_ON;
        } else {
            this.flashingStatus = FlashingStatus.FLASHING_OFF;
        }
    }

    public FlashingStatus getFlashingStatus(){
        return this.flashingStatus;
    }

    public TrafficLightStatus getTrafficLightStatus() {
        return trafficLightStatus;
    }
    public TrafficLightColor getTrafficLightColor() {
        return trafficLightColor;
    }
    public void nextColor () {
        if(trafficLightStatus == TrafficLightStatus.LIGHT_ON) {
            switch (trafficLightColor) {
                case TL_GREEN:
                    trafficLightColor = TrafficLightColor.TL_YELLOW;
                    break;
                case TL_YELLOW:
                    trafficLightColor = TrafficLightColor.TL_RED;
                    break;
                case TL_RED:
                    trafficLightColor = TrafficLightColor.TL_GREEN;
                    break;
            }
        }
    }
}
