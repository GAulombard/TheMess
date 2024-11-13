package com.hodor.jdbc.implementationwithhibernateorm.controller;

import com.hodor.jdbc.implementationwithhibernateorm.service.EpreuveService;

import java.util.Scanner;

public class EpreuveController {

    private EpreuveService epreuveService;

    public EpreuveController() {
        this.epreuveService = new EpreuveService();
    }

    public void afficheDetailEpreuve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id de l'epreuve: ");
        long id = scanner.nextLong();
        epreuveService.getEpreuveDetaille(id);
    }

    public void afficheDetailEpreuveSansTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id de l'epreuve: ");
        long id = scanner.nextLong();
        epreuveService.getEpreuveSansTournoi(id);
    }
}
