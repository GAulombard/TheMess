package com.hodor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Sandbox {
    public static void main(String[] args) {

        List<List<Object>> myList = new ArrayList<>();

        var test = Stream.of(1,2,3,4,5,6,7,8).reduce(Integer::sum);
        System.out.println(test);

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