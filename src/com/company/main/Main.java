package com.company.main;

import com.company.wordfinder.WordFinder;
import com.company.wordsquare.WordSquare;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter all of characters you wish to use for your word square one one line\nFor example: aaccdeeeemmnnnoo");

        Scanner sc = new Scanner(System.in);
        String allCharacters = sc.nextLine();

        ArrayList<Character> charArray = new ArrayList<>();

        for(int i = 0; i < allCharacters.length(); i++) {
            charArray.add(allCharacters.charAt(i));
        }

        Set<Character> uniqeChars = new HashSet<>(charArray);
        ArrayList<Character> uniqueArrayChars = new ArrayList<>(uniqeChars);

        WordFinder wordFinder = new WordFinder();

        wordFinder.setupDictionary(wordFinder);

        Set<String> wordsFound = wordFinder.findOuterWord(wordFinder, uniqueArrayChars);

        ArrayList<String> wordsFoundList = new ArrayList<>(wordsFound);

        System.out.println("words found " + wordsFoundList);

        int k = 0;

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> wordSquareWordsList = wordSquare.permute(wordsFoundList, k);

        System.out.println(wordSquareWordsList);

    }
}
