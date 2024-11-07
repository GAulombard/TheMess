package com.hodor.designpattern.observer;

import java.util.Observable;

public class Car extends Observable {

    private int speed;

    public Car(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        if (speed > 130) {
            setChanged();
            notifyObservers();
        }
    }
}
