package com.hodor.jdbc.implementationwithhibernateorm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EPREUVE")
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Short annee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TOURNOI")
    private Tournoi tournoi;
    @Column(name = "TYPE_EPREUVE")
    private Character typeEpreuve;

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

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    @Override
    public String toString() {
        return "Epreuve{" +
               "id=" + id +
               ", annee=" + annee +
               ", tournoi=" + tournoi +
               ", typeEpreuve=" + typeEpreuve +
               '}';
    }
}
