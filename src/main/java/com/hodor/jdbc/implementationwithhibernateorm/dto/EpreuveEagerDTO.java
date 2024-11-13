package com.hodor.jdbc.implementationwithhibernateorm.dto;

import com.hodor.jdbc.implementationwithhibernateorm.entity.Tournoi;

import java.util.Set;

public class EpreuveEagerDTO {

    private Long id;
    private Short annee;
    private TournoiDTO tournoi;
    private Character typeEpreuve;
    private Set<JoueurDTO> participants;

    public Character getTypeEpreuve() {
        return typeEpreuve;
    }

    public void setTypeEpreuve(Character typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getAnnee() {
        return annee;
    }

    public void setAnnee(Short annee) {
        this.annee = annee;
    }

    public TournoiDTO getTournoi() {
        return tournoi;
    }

    public void setTournoi(TournoiDTO tournoi) {
        this.tournoi = tournoi;
    }

    @Override
    public String toString() {
        return "EpreuveEagerDTO{" +
               "id=" + id +
               ", annee=" + annee +
               ", tournoi=" + tournoi +
               ", typeEpreuve=" + typeEpreuve +
               ", participants=" + participants +
               '}';
    }

    public Set<JoueurDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<JoueurDTO> participants) {
        this.participants = participants;
    }
}
