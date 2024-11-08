package com.hodor.designpattern.creational.factory.baeldungexample;

public class Car implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}
