package com.hodor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sandbox {
    public static void main(String[] args) {

        List<String> colors1 = new ArrayList<>();
        Collections.addAll(colors1,"black","red","yellow");
        System.out.println(colors1);

        for(String item : colors1) {
            System.out.println(item);
        }

        colors1.addFirst("blue");
        System.out.println(colors1);
        System.out.println(colors1.get(1));


        colors1.set(1,"purple");
        System.out.println(colors1);

        colors1.remove(2);
        System.out.println(colors1);
    }
}