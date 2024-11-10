package com.hodor.jdbc.implementationwithhibernateorm.service;

import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;
import com.hodor.jdbc.implementationwithhibernateorm.repository.TournoiRepositoryImpl;

public class TournoiService {

    private TournoiRepositoryImpl tournoiRepository;

    public TournoiService() {
        this.tournoiRepository = new TournoiRepositoryImpl();
    }

    public Tournoi createTournoi(Tournoi tournoi) {
        return tournoiRepository.create(tournoi);
    }

    public Tournoi getTournoi(Long id) {
        return tournoiRepository.getById(id);
    }
}
