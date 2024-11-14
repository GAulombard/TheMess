package com.hodor.jdbc.implementationwithhibernateorm.controller;

import com.hodor.jdbc.implementationwithhibernateorm.entity.Joueur;
import com.hodor.jdbc.implementationwithhibernateorm.entity.Score;
import com.hodor.jdbc.implementationwithhibernateorm.service.ScoreService;

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
