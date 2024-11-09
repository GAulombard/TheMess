package com.hodor.designpattern.behavioral.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws IOException {
        Game game = new Game();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        do {
            System.out.print("-- Please input command: ");
            input = br.readLine().trim().toLowerCase();
            switch (input) {
                case "w":
                    game.state.onWelcomeScreen();
                    break;
                case "p":
                    game.state.onPlaying();
                    break;
                case "b":
                    game.state.onBreak();
                    break;
                case "e":
                    game.state.onEndGame();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("-- unknown command --");
                    break;
            }
        } while (!input.equals("exit"));

    }
}
