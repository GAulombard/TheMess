package com.hodor.designpattern.factory.baeldungexample;

public class Motorcycle implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("Build Motorcycle");
    }
}
