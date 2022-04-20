package com.company.app;

import java.util.Scanner;
import static com.company.word_finder.WordFinder.findUniqueCharacters;

public class App {

    public static void startup() {
        System.out.println("Enter the dimensions for your word square from 4, 5, 7, " +
                "\n e.g for a four letter word square, enter the number 4");

        Scanner numberScanner = new Scanner(System.in);
        String lengthOfWords = numberScanner.nextLine();
        int lengthOfWordsNumber = 0;

        try {
            lengthOfWordsNumber = Integer.parseInt(lengthOfWords);
        } catch (Exception e) {
            exitApplication();
        }

        System.out.println("Enter all of characters you wish to use for your word square one one line" +
                "\nFor example: aaccdeeeemmnnnoo");

        String allCharacters = readInCharacters();
        findUniqueCharacters(lengthOfWordsNumber, allCharacters);
    }

    public static void exitApplication() {
        System.out.println("An error has occurred: Enter any key to exit");
        java.util.Scanner exitScanner = new java.util.Scanner(System.in);
        exitScanner.nextLine();
        System.exit(0);
    }

    public static String readInCharacters() {
        java.util.Scanner wordScanner = new java.util.Scanner(System.in);
        String allCharacters = wordScanner.nextLine();

        System.out.println("\n");
        return allCharacters;
    }
}
