package com.hodor.jdbc.implementationwithhibernateorm.controller;

import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import com.hodor.jdbc.implementationwithhibernateorm.service.JoueurService;

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

    public void creerJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom du joueur: ");
        String nom = scanner.next();
        System.out.print("Prenom du joueur: ");
        String prenom = scanner.next();
        System.out.print("Sexe du joueur: ");
        String sexe = scanner.next();
        Joueur joueur = new Joueur();
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setSexe(sexe.charAt(0));

        joueurService.createJoueur(joueur);
    }
}
