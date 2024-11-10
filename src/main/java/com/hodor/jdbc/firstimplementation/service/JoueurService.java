package com.hodor.jdbc.firstimplementation.service;

import com.hodor.jdbc.firstimplementation.entity.Joueur;
import com.hodor.jdbc.firstimplementation.repository.JoueurRepositoryImpl;

public class JoueurService {

    private JoueurRepositoryImpl joueurRepository;

    public JoueurService() {
        this.joueurRepository = new JoueurRepositoryImpl();
    }

    public Joueur createJoueur(Joueur joueur) {
        return joueurRepository.create(joueur);
    }

    public Joueur getJoueur(Long id) {
        return joueurRepository.getById(id);
    }

}
