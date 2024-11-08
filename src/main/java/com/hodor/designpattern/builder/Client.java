package com.hodor.designpattern.builder;

public class Client {
    public static void main(String[] args) {
        ApartmentBuilder builder = new ApartmentBuilder();

        Apartment ap1 = builder.setSqm(25)
                .setRooms(2)
                .setCity("London")
                .setArea("Kensington")
                .setKitchen(true)
                .build();

        ap1.display();

        Apartment ap2 = builder.setRooms(2)
                .setCity("Paris")
                .build();

        ap2.display();
    }
}
