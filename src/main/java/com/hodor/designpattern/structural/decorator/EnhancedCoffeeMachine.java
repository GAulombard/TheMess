package com.hodor.designpattern.structural.decorator;

import com.hodor.designpattern.structural.decorator.thirdpartylibraries.CoffeeMachine;
import com.hodor.designpattern.structural.decorator.thirdpartylibraries.NormalCoffeeMachine;

public class EnhancedCoffeeMachine implements CoffeeMachine {

    private NormalCoffeeMachine machine;

    public EnhancedCoffeeMachine(NormalCoffeeMachine machine) {
        this.machine = machine;
    }

    // overiding behaviour
    @Override
    public void makeSmallCofee() {
        System.out.println("Enhanced coffee machine: Making small coffee");
    }

    // unaltered behaviour
    @Override
    public void makeLargeCofee() {
        machine.makeLargeCofee();
    }

    // Extend behaviour
    public void makeMilkCoffee() {
        System.out.println("Enhanced coffee machine: Making milk coffee");
        machine.makeLargeCofee();
        System.out.println("Enhanced coffee machine: adding milk");
        System.out.println("Enhanced coffee machine: adding sugar");
    }
}
