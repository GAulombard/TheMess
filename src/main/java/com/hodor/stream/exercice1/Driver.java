package com.hodor.stream.exercice1;

public class Driver {
    private String name;

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                '}';
    }
}
