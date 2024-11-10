package com.hodor.jdbc.implementationwithhibernateorm.service;

import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import com.hodor.jdbc.implementationwithhibernateorm.repository.JoueurRepositoryImpl;

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

    public Joueur renome(Long id, String nom) {
        return joueurRepository.renome(id, nom);
    }

}
