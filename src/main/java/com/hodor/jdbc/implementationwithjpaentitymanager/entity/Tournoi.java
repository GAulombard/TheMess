package com.hodor.jdbc.implementationwithjpaentitymanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TOURNOI")
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Tournoi{" +
               "nom='" + nom + '\'' +
               ", code='" + code + '\'' +
               '}';
    }
}
