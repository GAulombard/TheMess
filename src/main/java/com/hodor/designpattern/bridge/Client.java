package com.hodor.designpattern.bridge;

public class Client {
    public static void main(String[] args) {
        App app1 = new Facebook(new Android());
        App app2 = new Instagram(new IOS());
        App app3 = new Instagram(new Android());


        app1.runApp();
        app2.runApp();
        app3.runApp();
    }
}
