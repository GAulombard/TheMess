package com.hodor.jdbc.implementationwithhibernateorm.controller;

import com.hodor.jdbc.implementationwithhibernateorm.dto.TournoiDTO;
import com.hodor.jdbc.implementationwithhibernateorm.service.MatchService;
import com.hodor.jdbc.implementationwithhibernateorm.service.TournoiService;

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
}
