package components.oefening01_trafficlights.utils;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers;

    public Observable(){
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void notifyObservers(Object args){
        for (Observer observer : observers){
            observer.update(args);
        }
    }
}
