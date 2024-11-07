package com.hodor.designpattern.factory.baeldungexample;

public class CarFactory extends MotorVehicleFactory{
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
