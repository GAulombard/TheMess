package com.hodor.designpattern.behavioral.memento;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator("Initial");
        CareTaker careTaker = new CareTaker();

        careTaker.saveState(originator.createMemento());
        System.out.println("Current state is: " + originator.state);

        originator.state = "state 1";
        careTaker.saveState(originator.createMemento());
        System.out.println("Current state is: " + originator.state);

        originator.state = "state 2";
        careTaker.saveState(originator.createMemento());
        System.out.println("Current state is: " + originator.state);

        System.out.println("---- UNDO: CTRL+Z ----");

        originator.restoreMemento(careTaker.restoreState(careTaker.mementos.size()-2));
        System.out.println("Current state is: " + originator.state);

        System.out.println("---- UNDO: CTRL+Z ----");

        originator.restoreMemento(careTaker.restoreState(careTaker.mementos.size()-3));
        System.out.println("Current state is: " + originator.state);

        System.out.println("---- REDO: CTRL+MAJ+Z ----");

        originator.restoreMemento(careTaker.restoreState(careTaker.mementos.size()-2));
        System.out.println("Current state is: " + originator.state);
    }
}
