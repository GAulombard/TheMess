package com.hodor.designpattern.behavioral.strategy;

import java.util.Random;

public class RandomcaseStrategy implements PrintStrategy {
    @Override
    public String formatString(String input) {
        String output = "";
        Random random = new Random();
        for (Character ch : input.toCharArray()) {
            if (random.nextBoolean()) {
                output += ch.toString().toUpperCase();
            } else {
                output += ch.toString().toLowerCase();
            }
        }
        return output;
    }
}
