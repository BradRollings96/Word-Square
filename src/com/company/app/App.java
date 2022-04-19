package com.company.app;

import com.company.word_finder.WordFinder;
import com.company.word_square.WordSquare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void startup() {
        System.out.println("Enter the dimensions for your word square between 4-7, " +
                "\n e.g for a four letter word square, enter the number 4");

        Scanner numberScanner = new Scanner(System.in);
        int lengthOfWords = numberScanner.nextInt();

        System.out.println("Enter all of characters you wish to use for your word square one one line" +
                "\nFor example: aaccdeeeemmnnnoo");

        Scanner wordScanner = new Scanner(System.in);
        String allCharacters = wordScanner.nextLine();

        System.out.println("\n");

        ArrayList<Character> charArray = new ArrayList<>();

        for(int characterIndex = 0; characterIndex < allCharacters.length(); characterIndex++) {
            charArray.add(allCharacters.charAt(characterIndex));
        }

        Set<Character> uniqueCharacters = new HashSet<>(charArray);
        ArrayList<Character> uniqueArrayChars = new ArrayList<>(uniqueCharacters);

        retrieveWordList(lengthOfWords, allCharacters, uniqueArrayChars);
    }

    private static void retrieveWordList(int lengthOfWords, String allCharacters, ArrayList<Character> uniqueArrayChars) {
        WordFinder wordFinder = new WordFinder();

        ArrayList<String> wordList = wordFinder.setupWordList(wordFinder, lengthOfWords, allCharacters);

        if (wordList.size() == 0) {
            System.out.println("Error: Unable to process request, enter any button to exit");
            Scanner exitScanner = new Scanner(System.in);
            exitScanner.nextLine();
            System.exit(0);
        }

        Set<String> wordsFound = wordFinder.findOuterWord(wordFinder, uniqueArrayChars);
        ArrayList<String> wordsFoundList = new ArrayList<>(wordsFound);

        int currentIndex = 0;

        WordSquare wordSquare = new WordSquare();
        wordSquare.findAllPossibleWords(wordsFoundList, currentIndex);
    }
}
