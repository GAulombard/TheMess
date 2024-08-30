package com.hodor.string;

public class StringImmutable {

    public static void main(String[] args) {

        // String are immutable
        String name = "Jojo"; // name point to the object "Jojo"
        name = "Another Jojo"; // name point now towards the object "Another Jojo", but the object "Jojo" stays in memory

        String anotherName = "Another Jojo"; // will point to the same String object as name variable, in the string pool memory. It allows to save memory

        // you can create a separate string pool by using "new"
        String aThirdName = new String("Another Jojo");

        //proof with == that compare reference in memory
        System.out.println(name == anotherName); // should return true
        System.out.println(name == aThirdName); // should return false
        System.out.println(name.equals(aThirdName)); // should return true
    }
}
