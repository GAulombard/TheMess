package com.hodor.stream.exercice1;

import java.util.Set;

public class Trip {
    private Driver driver;
    private Set<Passenger> passengers;
    private int duration; // duration in minutes
    private double distance; // distance in km

    public Trip(Driver driver, Set<Passenger> passengers, int duration, double distance) {
        this.driver = driver;
        this.passengers = passengers;
        this.duration = duration;
        this.distance = distance;
    }

    public Driver getDriver() {
        return driver;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public int getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "duration=" + duration +
                ", distance=" + distance +
                '}';
    }
}
