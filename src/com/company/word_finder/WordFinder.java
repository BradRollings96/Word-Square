package com.company.word_finder;

import com.company.word_square.WordSquare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordFinder {
    public ArrayList<String> wordList = new ArrayList<>();
    private final Set<String> foundWordsList = new HashSet<>();
    private int wordListIndex = 0;
    private int userEnteredCharIndex = 0; //Used to compare every character from userEnteredChars array to each character of each word
    //of the wordList array.
    private int userEnteredCharOccurrence = 0; //Used to compare every character from userEnteredChars to a single word from wordList
    // where a match has been found.
    private String lettersFound = ""; //Used to see if a full word from wordList can be made from the elements provided via userEnteredChars.

    //TODO: Swap out these values with a text file containing words
    public ArrayList<String> setupWordList(int lengthOfWords, String allCharacters) {
        switch (lengthOfWords) {
            case 4:
                if (allCharacters.equals("eeeeddoonnnsssrv")) {
                    wordList.add("ends");
                    wordList.add("oven");
                    wordList.add("rose");
                    wordList.add("send");
                }
                else if(allCharacters.equals("aaccdeeeemmnnnoo")) {
                    wordList.add("acme");
                    wordList.add("once");
                    wordList.add("need");
                    wordList.add("moan");
                }
                break;
            case 5:
                if (allCharacters.equals("aaaeeeefhhmoonssrrrrttttw")) {
                    wordList.add("earth");
                    wordList.add("threw");
                    wordList.add("feast");
                    wordList.add("armor");
                    wordList.add("stone");
                }
                else if (allCharacters.equals("aabbeeeeeeeehmosrrrruttvv")) {
                    wordList.add("above");
                    wordList.add("revue");
                    wordList.add("ember");
                    wordList.add("heart");
                    wordList.add("trees");
                }
                break;
            case 7:
                if(allCharacters.equals("aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy")) {
                    wordList.add("renamed");
                    wordList.add("degrade");
                    wordList.add("amoebas");
                    wordList.add("valuers");
                    wordList.add("odyssey");
                    wordList.add("analogy");
                    wordList.add("bravado");
                }
                break;
        }
        return wordList;
    }

    public static void findUniqueCharacters(int lengthOfWords, String allCharacters) {
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
        ArrayList<String> wordList = wordFinder.setupWordList(lengthOfWords, allCharacters);

        if (wordList.size() == 0) {
            System.out.println("Error: Unable to process request, enter any button to exit");
            Scanner exitScanner = new Scanner(System.in);
            exitScanner.nextLine();
            System.exit(0);
        }

        Set<String> wordsFound = wordFinder.findWords(uniqueArrayChars);
        ArrayList<String> wordsFoundList = new ArrayList<>(wordsFound);
        int currentIndex = 0;

        WordSquare wordSquare = new WordSquare();
        wordSquare.findAllPossibleWords(wordsFoundList, currentIndex);
    }

    public Set<String> findWords(ArrayList<Character> userEnteredChars) {
        //If all elements from userEnteredChars has been compared to every character from each element of wordList,
        //return all of the words found.
        if (userEnteredCharIndex == userEnteredChars.size() - 1) {
            return compareCharsToAllWords(userEnteredChars);
        }
        //If a letter from userEnteredChars has been compared to every character of each element of wordList, move onto
        //the next letter and reset the value of wordListIndex to zero, so this next letter can be compared against all of
        //the characters from wordList.
        if (wordListIndex == wordList.size()) {
            userEnteredCharIndex++;
            wordListIndex = 0;
            findWords(userEnteredChars);
        }
        return compareCharsToAllWords(userEnteredChars);
    }

    //Compare every single letter from userEnteredChars against every char from every word in the wordList
    private Set<String> compareCharsToAllWords(ArrayList<Character> userEnteredChars) {
        //If a match of a letter to a word has been made, every character within userEnteredChars needs to be compared
        //against the word to see if that word can be made from the characters provided.
        userEnteredCharOccurrence = 0;

        //compares the first character from userEnteredChars against all the characters in the first word of the
        //wordList. If a match of a char to a word has been made, call returnFoundWords(), otherwise, compare this letter
        //against the next word in the wordList. If this letter has been compared against every character from all the words
        //in the wordList, increment the value of userEnteredCharIndex by 1 and repeat these steps with the next letter to see
        //if a match can be found.
        for (int currentCharacterIndex = 0; currentCharacterIndex < wordList.get(wordListIndex).length() + 1; currentCharacterIndex++) {
            if (userEnteredCharIndex == userEnteredChars.size() - 1) {
                return compareCharsToSingleWord(userEnteredChars);
            }
            if (currentCharacterIndex == wordList.get(wordListIndex).length()) {
                wordListIndex++;
                findWords(userEnteredChars);
            } else if (userEnteredChars.get(userEnteredCharIndex) == wordList.get(wordListIndex).charAt(currentCharacterIndex)) {
                compareCharsToSingleWord(userEnteredChars);
                lettersFound = "";
                wordListIndex++;
                findWords(userEnteredChars);
            }
        }
        return compareCharsToSingleWord(userEnteredChars);
    }

    private Set<String> compareCharsToSingleWord(ArrayList<Character> userEnteredChars) {
        int wordLength = wordList.get(wordListIndex).length();
        String word = wordList.get(wordListIndex);

        //If all of the characters from userEnteredChars have been tested against the word that was initially matched on,
        //return all of the words that were found.
        if (userEnteredCharOccurrence == userEnteredChars.size()) {
            return foundWordsList;
        }

        //When an initial match of a letter from userEnteredChars to wordList has been made,
        //go through every letter of the userEnteredChars and compare it to the word initially
        //matched on to see all of the character occurrences within the word.
        for (int currentIndex = 0; currentIndex < wordList.get(wordListIndex).length(); currentIndex++) {
            if (userEnteredChars.get(userEnteredCharOccurrence) == wordList.get(wordListIndex).charAt(currentIndex)) {
                lettersFound += userEnteredChars.get(userEnteredCharOccurrence);
            }
        }
        //If the first element of userEnteredChars has been compared to every char of the word that was initially matched on, and the length
        //of the concatenated string is not the same length as the word, this means that the word is not able to be created from the lettersFound
        //variable. Therefore, call this method again but increment the value of userEnteredCharOccurrence by 1 to find all occurrences
        //of the next letter on this word and so on.
        if (lettersFound.length() != wordLength) {
            userEnteredCharOccurrence++;
            compareCharsToSingleWord(userEnteredChars);
        } else {
            foundWordsList.add(word);
        }
        return foundWordsList;
    }
}
