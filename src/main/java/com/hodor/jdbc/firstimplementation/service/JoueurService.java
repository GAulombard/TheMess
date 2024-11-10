package com.hodor.jdbc.firstimplementation.service;

import com.hodor.jdbc.firstimplementation.entity.Joueur;
import com.hodor.jdbc.firstimplementation.repository.JoueurRepositoryImpl;

public class JoueurService {

    private JoueurRepositoryImpl joueurRepository;

    public JoueurService() {
        this.joueurRepository = new JoueurRepositoryImpl();
    }

    public void createJoueur(Joueur joueur) {
        joueurRepository.create(joueur);
    }

}
