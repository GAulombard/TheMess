package com.hodor.jdbc.firstimplementation.controller;

import com.hodor.jdbc.firstimplementation.entity.Joueur;
import com.hodor.jdbc.firstimplementation.service.JoueurService;

import java.util.Scanner;

public class JoueurController {

    private JoueurService joueurService;

    public JoueurController() {
        this.joueurService = new JoueurService();
    }

    public void afficheDetailJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du joueur: ");
        long id = scanner.nextLong();
        Joueur joueur = joueurService.getJoueur(id);
    }
}
