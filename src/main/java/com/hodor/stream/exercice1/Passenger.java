package com.hodor.stream.exercice1;

public class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                '}';
    }
}
