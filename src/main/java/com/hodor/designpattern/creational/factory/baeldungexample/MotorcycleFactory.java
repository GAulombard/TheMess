package com.hodor.designpattern.creational.factory.baeldungexample;

public class MotorcycleFactory extends MotorVehicleFactory{
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Motorcycle();
    }
}
