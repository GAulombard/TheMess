package com.hodor.games;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangedMan {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        // fetch wordlist from file
        List<String> words = generateWordlist();

        //choose random word from list
        String word = getRandomWord(words);
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        printWordState(word, playerGuesses);

        while (true) {
            System.out.println("Choose a letter : ");
            playerGuesses.add(sc.next().charAt(0));
            printWordState(word, playerGuesses);
        }

    }

    private static void printWordState(String word, List<Character> playerGuesses) {
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
    }

    private static String getRandomWord(List<String> words) {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

    private static List<String> generateWordlist() throws FileNotFoundException {
        Scanner wordlist = new Scanner(new File("french-wordlist.txt"));
        List<String> words = new ArrayList<>();

        while (wordlist.hasNextLine()) {
            words.add(wordlist.nextLine());
        }

        wordlist.close();
        return words;
    }
}
