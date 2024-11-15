package com.hodor.jdbc.implementationwithjpaentitymanager.dto;

public class MatchDTO {

    private Long id;
    private JoueurDTO vainqueur;
    private JoueurDTO finaliste;
    private EpreuveEagerDTO epreuve;
    private ScoreEagerDTO score;

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
               "id=" + id +
               ", vainqueur=" + vainqueur +
               ", finaliste=" + finaliste +
               ", epreuve=" + epreuve +
               ", score=" + score +
               '}';
    }

    public EpreuveEagerDTO getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(EpreuveEagerDTO epreuve) {
        this.epreuve = epreuve;
    }

    public ScoreEagerDTO getScore() {
        return score;
    }

    public void setScore(ScoreEagerDTO score) {
        this.score = score;
    }
}
