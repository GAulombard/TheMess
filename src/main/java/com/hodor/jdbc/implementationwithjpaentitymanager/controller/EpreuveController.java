package com.hodor.jdbc.implementationwithjpaentitymanager.controller;

import com.hodor.jdbc.implementationwithjpaentitymanager.service.EpreuveService;

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

    public void afficheListeEpreuve() {
        System.out.println("Liste des epreuves, code : ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        epreuveService.getListEpreuve(code);
    }
}
