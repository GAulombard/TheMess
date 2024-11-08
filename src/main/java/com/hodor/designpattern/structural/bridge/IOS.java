package com.hodor.designpattern.structural.bridge;

public class IOS implements PhoneOS{
    @Override
    public void upload(String data) {
        System.out.println("Iphone uploadinf data: " + data);
    }

    @Override
    public void download(String url) {
        System.out.println("Iphone downloading data from url: " + url);
    }

    @Override
    public void display(String data) {
        System.out.println("Iphone displaying data: " + data);
    }
}
