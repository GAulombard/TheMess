package com.hodor.pattern.observer;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(100);
        car.getSpeed();
        car.setSpeed(130);

        Radar radar = new Radar();
        car.addObserver(radar);
        car.setSpeed(200);

    }
}
