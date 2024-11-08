package com.hodor.designpattern.structural.proxy;

public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.png");

        image.display(); // first time we load the real image
        System.out.println();
        image.display(); // second time no need to load the image
    }
}
