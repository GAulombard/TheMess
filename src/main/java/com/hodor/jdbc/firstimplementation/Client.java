package com.hodor.jdbc.firstimplementation;

import com.hodor.jdbc.firstimplementation.entity.Joueur;
import com.hodor.jdbc.firstimplementation.entity.Tournoi;
import com.hodor.jdbc.firstimplementation.repository.JoueurRepositoryImpl;
import com.hodor.jdbc.firstimplementation.repository.TournoiRepositoryImpl;
import com.hodor.jdbc.firstimplementation.service.JoueurService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        JoueurService joueurService = new JoueurService();
/*        Joueur bartoli = joueurService.getById(21L);

        List<Joueur> joueurs = joueurService.list();
        joueurs.forEach(System.out::println);*/

        Joueur noah = new Joueur();
        noah.setNom("Noah");
        noah.setPrenom("Yannik");
        noah.setSexe('H');
        //noah = joueurService.createJoueur(noah);
        joueurService.createJoueur(noah);

/*        Joueur joueur = joueurService.getById(noah.getId());
        joueur.setPrenom("Yannick");
        joueurService.update(joueur);

        joueurService.delete(noah.getId());

        TournoiRepositoryImpl tournoiRepository = new TournoiRepositoryImpl();
        List<Tournoi> tournois = tournoiRepository.list();
        tournois.forEach(System.out::println);*/

    }
}
