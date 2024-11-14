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

    public void renommerJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du joueur: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Nouveau nom: ");
        String nom = scanner.nextLine();
        joueurService.renome(id, nom);
    }

    public void changerSexe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du joueur: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Nouveau sexe: ");
        Character sexe = scanner.nextLine().charAt(0);
        joueurService.changerSexe(id, sexe);
    }

    public void supprimerJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du joueur: ");
        long id = scanner.nextLong();
        joueurService.deleteJoueur(id);
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

    public void afficheListeJoueur() {
        System.out.println("Liste des joueurs (H) ou (F) : ");
        Scanner scanner = new Scanner(System.in);
        char sexe = scanner.nextLine().charAt(0);
        joueurService.getListJoueur(sexe);
    }
}
