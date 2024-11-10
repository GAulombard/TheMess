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

        Joueur noah = new Joueur();
        noah.setNom("Noah");
        noah.setPrenom("Yannik");
        noah.setSexe('H');
        noah = joueurRepository.create(noah);

        Joueur joueur = joueurRepository.getById(noah.getId());
        joueur.setPrenom("Yannick");
        joueurRepository.update(joueur);

        joueurRepository.delete(noah.getId());

    }
}
