package com.hodor.jdbc.implementationwithhibernateorm.controller;

import com.hodor.jdbc.implementationwithhibernateorm.dto.MatchDTO;
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

    public void tapidVert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du match pour tapis vert: ");
        long id = scanner.nextLong();
        matchService.tapisVert(id);
    }

    public void creerNouveauMatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du match pour tapis vert: ");
        long id = scanner.nextLong();
        MatchDTO dto = new MatchDTO();
        matchService.createMatch(dto);
    }
}
