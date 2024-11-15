package com.hodor.jdbc.implementationwithjpaentitymanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "JOUEUR")
@NamedQuery(query = "select j from Joueur j where j.sexe=?1", name = "given_sex")
@NamedQuery(query = "select j from Joueur j where j.nom=?1", name = "given_name")
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Character sexe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "Joueur{" + "nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", sexe=" + sexe + '}';
    }
}
