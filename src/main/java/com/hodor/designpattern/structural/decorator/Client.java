package com.hodor.designpattern.structural.decorator;

import com.hodor.designpattern.structural.decorator.thirdpartylibraries.NormalCoffeeMachine;

public class Client {
    public static void main(String[] args) {
        NormalCoffeeMachine normal = new NormalCoffeeMachine();
        EnhancedCoffeeMachine enhanced = new EnhancedCoffeeMachine(normal);

        normal.makeSmallCofee();
        normal.makeLargeCofee();

        enhanced.makeSmallCofee();
        enhanced.makeLargeCofee();
        enhanced.makeMilkCoffee();
    }
}
