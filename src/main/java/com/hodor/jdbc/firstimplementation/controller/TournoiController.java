package com.hodor.jdbc.firstimplementation.controller;

import com.hodor.jdbc.firstimplementation.entity.Joueur;
import com.hodor.jdbc.firstimplementation.entity.Tournoi;
import com.hodor.jdbc.firstimplementation.service.JoueurService;
import com.hodor.jdbc.firstimplementation.service.TournoiService;

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
        Tournoi tournoi = tournoiService.getTournoi(id);
    }

    public void creerTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom du tournoi: ");
        String nom = scanner.next();
        System.out.print("Code du Tournoi: ");
        String code = scanner.next();
        Tournoi tournoi = new Tournoi();
        tournoi.setNom(nom);
        tournoi.setCode(code);

        tournoiService.createTournoi(tournoi);
    }
}
