package com.hodor.jdbc.implementationwithhibernateorm.controller;

import com.hodor.jdbc.implementationwithhibernateorm.dto.EpreuveEagerDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.JoueurDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.MatchDTO;
import com.hodor.jdbc.implementationwithhibernateorm.dto.ScoreEagerDTO;
import com.hodor.jdbc.implementationwithhibernateorm.service.MatchService;

import java.util.Scanner;

public class MatchController {

    private MatchService matchService;

    public MatchController() {
        this.matchService = new MatchService();
    }

    public void afficheDetailMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du match: ");
        long id = scanner.nextLong();
        matchService.getMatch(id);
    }

    public void ajouterMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id de l'epreuve: ");
        long idEpreuve = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Id du vainqueur: ");
        long idVainqueur = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Id du finaliste: ");
        long idFinaliste = scanner.nextLong();
        scanner.nextLine();

        MatchDTO dto = new MatchDTO();
        dto.setEpreuve(new EpreuveEagerDTO());
        dto.getEpreuve().setId(idEpreuve);
        dto.setFinaliste(new JoueurDTO());
        dto.getFinaliste().setId(idFinaliste);
        dto.setVainqueur(new JoueurDTO());
        dto.getVainqueur().setId(idVainqueur);

        System.out.print("set 1: ");
        byte set1 = scanner.nextByte();
        scanner.nextLine();
        System.out.print("set 2: ");
        byte set2 = scanner.nextByte();
        scanner.nextLine();
        System.out.print("set 3: ");
        byte set3 = scanner.nextByte();
        scanner.nextLine();
        System.out.print("set 4: ");
        byte set4 = scanner.nextByte();
        scanner.nextLine();
        System.out.print("set 5: ");
        byte set5 = scanner.nextByte();
        scanner.nextLine();

        ScoreEagerDTO scoreEagerDTO = new ScoreEagerDTO();
        scoreEagerDTO.setSet1(set1);
        scoreEagerDTO.setSet2(set2);
        scoreEagerDTO.setSet3(set3);
        scoreEagerDTO.setSet4(set4);
        scoreEagerDTO.setSet5(set5);
        dto.setScore(scoreEagerDTO);
        scoreEagerDTO.setMatchDTO(dto);

        matchService.createMatch(dto);
    }

    public void supprimerMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du match: ");
        long id = scanner.nextLong();
        matchService.deleteMatch(id);
    }

    public void tapisVert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du match pour tapis vert: ");
        long id = scanner.nextLong();
        matchService.tapisVert(id);
    }
}
