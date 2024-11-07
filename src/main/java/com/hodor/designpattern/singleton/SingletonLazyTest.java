package com.hodor.designpattern.singleton;

public class SingletonLazyTest {

    public static void main(String[] args) {
        SingletonLazy instance1 = SingletonLazy.getInstance();
        SingletonLazy instance2 = SingletonLazy.getInstance();

        //should be the same instance for both
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
