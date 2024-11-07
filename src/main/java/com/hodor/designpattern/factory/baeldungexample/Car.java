package com.hodor.designpattern.factory.baeldungexample;

public class Car implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}
