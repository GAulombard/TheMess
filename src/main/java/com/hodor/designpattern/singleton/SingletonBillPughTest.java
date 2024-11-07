package com.hodor.designpattern.singleton;

public class SingletonBillPughTest {
    public static void main(String[] args) {
        SingletonBillPugh instance1 = SingletonBillPugh.getInstance();
        SingletonBillPugh instance2 = SingletonBillPugh.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
