package com.hodor.jdbc.implementationwithhibernateorm.controller;

import com.hodor.jdbc.implementationwithhibernateorm.entity.Epreuve;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;
import com.hodor.jdbc.implementationwithhibernateorm.service.EpreuveService;
import com.hodor.jdbc.implementationwithhibernateorm.service.TournoiService;

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
        Epreuve epreuve = epreuveService.getEpreuve(id);
    }

    public void afficheDetailEpreuveAvecTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id de l'epreuve: ");
        long id = scanner.nextLong();
        epreuveService.getEpreuveAvecTournoi(id);
    }

    public void afficheDetailEpreuveSansTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id de l'epreuve: ");
        long id = scanner.nextLong();
        epreuveService.getEpreuveSansTournoi(id);
    }
}
