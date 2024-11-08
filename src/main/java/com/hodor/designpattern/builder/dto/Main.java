package com.hodor.designpattern.builder.dto;

public class Main {

    public static void main(String[] args) {

        Heroe heroe = new Heroe.Builder()
                .age(12)
                .gender("male")
                .name("Hodor")
                .weapon("Sword")
                .armor("leather")
                .build();

        System.out.println(heroe.toString());
    }
}
