package com.hodor.designpattern.structural.facade;

public class Comm {

    public void send(String data) {
        System.out.println("sending data: "+data);
    }

    public void receive() {
        System.out.println("Receiving data !");
    }
}
