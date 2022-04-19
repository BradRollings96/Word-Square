package com.company.app;

import java.util.Scanner;
import static com.company.word_finder.WordFinder.findUniqueCharacters;

public class App {

    public static void startup() {
        System.out.println("Enter the dimensions for your word square between 4-7, " +
                "\n e.g for a four letter word square, enter the number 4");

        Scanner numberScanner = new Scanner(System.in);
        int lengthOfWords = numberScanner.nextInt();

        System.out.println("Enter all of characters you wish to use for your word square one one line" +
                "\nFor example: aaccdeeeemmnnnoo");

        String allCharacters = readInCharacters();
        findUniqueCharacters(lengthOfWords, allCharacters);
    }

    public static String readInCharacters() {
        java.util.Scanner wordScanner = new java.util.Scanner(System.in);
        String allCharacters = wordScanner.nextLine();

        System.out.println("\n");

        return allCharacters;
    }
}
