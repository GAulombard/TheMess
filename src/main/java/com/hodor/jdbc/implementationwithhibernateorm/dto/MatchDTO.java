package com.hodor.jdbc.implementationwithhibernateorm.dto;

public class MatchDTO {

    private Long id;
    private JoueurDTO vainqueur;
    private JoueurDTO finaliste;
    private EpreuveEagerDTO epreuve;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JoueurDTO getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(JoueurDTO vainqueur) {
        this.vainqueur = vainqueur;
    }

    public JoueurDTO getFinaliste() {
        return finaliste;
    }

    public void setFinaliste(JoueurDTO finaliste) {
        this.finaliste = finaliste;
    }

    @Override
    public String toString() {
        return "MatchDTO{" +
               "vainqueur=" + vainqueur +
               ", finaliste=" + finaliste +
               ", epreuve=" + epreuve +
               '}';
    }

    public EpreuveEagerDTO getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(EpreuveEagerDTO epreuve) {
        this.epreuve = epreuve;
    }
}
