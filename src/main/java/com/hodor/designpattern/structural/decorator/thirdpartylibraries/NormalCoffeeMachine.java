package com.hodor.designpattern.structural.decorator.thirdpartylibraries;

public class NormalCoffeeMachine implements CoffeeMachine{
    @Override
    public void makeSmallCofee() {
        System.out.println("Normal coffee machine: Making small coffee");
    }

    @Override
    public void makeLargeCofee() {
        System.out.println("Normal coffee machine: Making large coffee");
    }
}
