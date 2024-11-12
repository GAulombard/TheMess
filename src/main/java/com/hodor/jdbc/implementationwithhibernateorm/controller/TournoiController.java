package com.hodor.jdbc.implementationwithhibernateorm.controller;

import com.hodor.jdbc.implementationwithhibernateorm.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;
import com.hodor.jdbc.implementationwithhibernateorm.service.TournoiService;

import java.util.Scanner;

public class TournoiController {

    private TournoiService tournoiService;

    public TournoiController() {
        this.tournoiService = new TournoiService();
    }

    public void afficheDetailTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du tournoi: ");
        long id = scanner.nextLong();
        tournoiService.getTournoi(id);
    }

    public void creerTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom du tournoi: ");
        String nom = scanner.nextLine();
        System.out.print("Code du Tournoi: ");
        String code = scanner.nextLine();
        TournoiDTO tournoi = new TournoiDTO();
        tournoi.setNom(nom);
        tournoi.setCode(code);

        tournoiService.createTournoi(tournoi);
    }

    public void supprimerTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du tournoi: ");
        long id = scanner.nextLong();
        tournoiService.deleteTournoi(id);
    }
}
