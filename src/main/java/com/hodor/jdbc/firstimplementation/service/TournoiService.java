package com.hodor.jdbc.firstimplementation.service;

import com.hodor.jdbc.firstimplementation.entity.Tournoi;
import com.hodor.jdbc.firstimplementation.repository.TournoiRepositoryImpl;

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
