package com.hodor.designpattern.singleton;

public class SingletonThreadSafeTest {
    public static void main(String[] args) {
        SingletonThreadSafe instance1 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe instance2 = SingletonThreadSafe.getInstance();

        //should be the same instance for both
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
