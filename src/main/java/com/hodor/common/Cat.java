package com.hodor.common;

public class Cat {

    private String name;
    private int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void meow() {
        System.out.println("Meow meow !!");
    }

    private void privateMeow() {
        System.out.println("How did you call this ? Meow private Meow !!");
    }

    public static void staticMeow() {
        System.out.println("Meow public and static Meow !!");
    }

    private static void privateAndStaticMeow() {
        System.out.println("Meow private and static Meow !!");
    }
}
