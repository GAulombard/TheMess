package com.hodor.jdbc.firstimplementation;

import com.hodor.jdbc.firstimplementation.controller.JoueurController;
import com.hodor.jdbc.firstimplementation.entity.*;
import com.hodor.jdbc.firstimplementation.repository.JoueurRepositoryImpl;
import com.hodor.jdbc.firstimplementation.repository.TournoiRepositoryImpl;
import com.hodor.jdbc.firstimplementation.service.JoueurService;
import com.hodor.jdbc.firstimplementation.service.MatchService;
import com.hodor.jdbc.firstimplementation.service.TournoiService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        /*JoueurService joueurService = new JoueurService();
*//*        Joueur bartoli = joueurService.getById(21L);

        List<Joueur> joueurs = joueurService.list();
        joueurs.forEach(System.out::println);*//*

        Joueur noah = new Joueur();
        noah.setNom("Noah");
        noah.setPrenom("Yannik");
        noah.setSexe('H');
        noah = joueurService.createJoueur(noah);

        Joueur joueur = joueurService.getJoueur(noah.getId());

        *//*joueur.setPrenom("Yannick");
        joueurService.update(joueur);

        joueurService.delete(noah.getId());*//*

        TournoiService tournoiService = new TournoiService();
        Tournoi test = new Tournoi();
        test.setNom("Test");
        test.setCode("TS");
        test = tournoiService.createTournoi(test);

        Tournoi tournoi = tournoiService.getTournoi(test.getId());

        MatchService matchService = new MatchService();
        Match match = new Match();
        Score score = new Score();
        Joueur federer = new Joueur();
        federer.setId(32L);

        Joueur murray = new Joueur();
        murray.setId(34L);

        Epreuve epreuve = new Epreuve();
        epreuve.setId(10L);

        score.setSet1((byte)3);
        score.setSet2((byte)4);
        score.setSet3((byte)6);
        score.setMatch(match);

        match.setScore(score);
        match.setVainqueur(federer);
        match.setFinaliste(murray);
        match.setEpreuve(epreuve);


        matchService.enregistrerNouveauMatch(match);*/

        JoueurController joueurController = new JoueurController();
        joueurController.afficheDetailJoueur();

    }
}
