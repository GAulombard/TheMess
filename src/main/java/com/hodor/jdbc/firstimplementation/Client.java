package com.hodor.jdbc.firstimplementation;

import com.hodor.jdbc.firstimplementation.entity.Joueur;
import com.hodor.jdbc.firstimplementation.repository.JoueurRepositoryImpl;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        JoueurRepositoryImpl joueurRepository = new JoueurRepositoryImpl();
        Joueur bartoli = joueurRepository.getById(21L);

        List<Joueur> joueurs = joueurRepository.list();
        joueurs.forEach(System.out::println);

//        Joueur noah = new Joueur();
//        noah.setNom("Noah");
//        noah.setPrenom("Yannik");
//        noah.setSexe('H');
//        joueurRepository.create(noah);
//
//        Joueur joueur = joueurRepository.getById(47L);
//        joueur.setPrenom("Yannick");
//        joueurRepository.update(joueur);
//
//        joueurRepository.delete(47L);

    }
}
