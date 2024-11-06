package com.hodor.functionalinterface;

public class ConsolPrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
