package com.hodor.jdbc.implementationwithjpaentitymanager.controller;

import com.hodor.jdbc.implementationwithjpaentitymanager.service.ScoreService;

import java.util.Scanner;

public class ScoreController {

    private ScoreService scoreService;

    public ScoreController() {
        this.scoreService = new ScoreService();
    }

    public void afficheDetailScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du score: ");
        long id = scanner.nextLong();
        scoreService.getScore(id);
    }

    public void supprimerScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id du score: ");
        long id = scanner.nextLong();
        scoreService.deleteScore(id);
    }
}
