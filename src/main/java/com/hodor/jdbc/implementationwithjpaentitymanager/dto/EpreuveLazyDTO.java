package com.hodor.jdbc.implementationwithjpaentitymanager.dto;

public class EpreuveLazyDTO {

    private Long id;
    private Short annee;
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

    @Override
    public String toString() {
        return "EpreuveLazyDTO{" +
               "id=" + id +
               ", annee=" + annee +
               ", typeEpreuve=" + typeEpreuve +
               '}';
    }
}
