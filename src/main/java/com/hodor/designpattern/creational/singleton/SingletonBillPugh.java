package com.hodor.designpattern.creational.singleton;

public class SingletonBillPugh {
    private SingletonBillPugh() {}

    private static class InnerStaticClass {
        private static final SingletonBillPugh instance = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return InnerStaticClass.instance;
    }
}
