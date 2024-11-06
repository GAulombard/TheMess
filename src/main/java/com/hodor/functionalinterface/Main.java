package com.hodor.functionalinterface;

public class Main {

    public static void main(String[] args) {

        // avec creation d'une classe
        Printer printer = new ConsolPrinter();
        printer.print("Hello world !");

        // sans creation de classe si ce n'est pas necessaire
        // classe anonyme
        Printer printer1 = new Printer() {
            @Override
            public void print(String message) {
                System.out.println("Via anonyme class : " + message);
            }
        };

        printer1.print("Hello anonyme class !");

        // ou via lambda expression
        Printer printer2 = (String msg) -> {
            System.out.println("Via lambda expression : " + msg);
        };

        printer2.print("Hello lambda expression !");

        // lambda simplifié
        Printer printer3 = msg -> System.out.println("Via lambda expression simplifié : " + msg);

        printer3.print("Hello lambda expression !");

        // lambda simplifié avec reference de methode
        Printer printer4 = System.out::println;
        printer4.print("Hello method reference !");
    }

}
