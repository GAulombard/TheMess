package com.hodor.designpattern.creational.factory;

public class ShapeFactory {
    public Shape getFood(String type) {
        if (type == null) {
            return null;
        }

        return switch (type) {
            case "Round" -> new Pizza();
            case "Cylinder" -> new Burrito();
            default -> throw new IllegalArgumentException("Unknown shape");
        };
    }
}
