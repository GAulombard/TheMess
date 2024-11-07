package com.hodor.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Radar implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Radar observer flash");
    }
}
