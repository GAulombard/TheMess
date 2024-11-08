package com.hodor.designpattern.builder;

public class Apartment {
    private int sqm;
    private int rooms;
    private String city;
    private String area;
    private boolean kitchen;

    public Apartment(int sqm, int rooms, String city, String area, boolean kitchen) {
        this.sqm = sqm;
        this.rooms = rooms;
        this.city = city;
        this.area = area;
        this.kitchen = kitchen;
    }

    public int getSqm() {
        return sqm;
    }

    public int getRooms() {
        return rooms;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public boolean isKitchen() {
        return kitchen;
    }

    public void display() {
        System.out.println("");
        System.out.println("Apartment has:");
        if (sqm != -1) {
            System.out.println(sqm + " sqm");
        }
        if (rooms != 1) {
            System.out.println(rooms + " rooms");
        }
        if (city != "") {
            System.out.println("Apartment is in " + city);
        }
        if (area != "") {
            System.out.println("Apartment is in " + area);
        }
        if (kitchen) {
            System.out.println("Apartment had a kitchen");
        }
        System.out.println("");
    }
}
