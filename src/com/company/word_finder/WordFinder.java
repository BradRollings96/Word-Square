package com.company.word_finder;

import java.util.ArrayList;
import java.util.HashSet;
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
    public ArrayList<String> setupWordList(WordFinder wordFinder, int lengthOfWords, String allCharacters) {

        switch (lengthOfWords) {
            case 4:
                if (allCharacters.equals("eeeeddoonnnsssrv")) {
                    wordFinder.wordList.add("ends");
                    wordFinder.wordList.add("oven");
                    wordFinder.wordList.add("rose");
                    wordFinder.wordList.add("send");
                }
                else if(allCharacters.equals("aaccdeeeemmnnnoo")) {
                    wordFinder.wordList.add("acme");
                    wordFinder.wordList.add("once");
                    wordFinder.wordList.add("need");
                    wordFinder.wordList.add("moan");
                }
                break;
            case 5:
                if (allCharacters.equals("aaaeeeefhhmoonssrrrrttttw")) {
                    wordFinder.wordList.add("earth");
                    wordFinder.wordList.add("threw");
                    wordFinder.wordList.add("feast");
                    wordFinder.wordList.add("armor");
                    wordFinder.wordList.add("stone");
                }
                else if (allCharacters.equals("aabbeeeeeeeehmosrrrruttvv")) {
                    wordFinder.wordList.add("above");
                    wordFinder.wordList.add("revue");
                    wordFinder.wordList.add("ember");
                    wordFinder.wordList.add("heart");
                    wordFinder.wordList.add("trees");
                }
                break;
            case 7:
                if(allCharacters.equals("aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy")) {
                    wordFinder.wordList.add("renamed");
                    wordFinder.wordList.add("degrade");
                    wordFinder.wordList.add("amoebas");
                    wordFinder.wordList.add("valuers");
                    wordFinder.wordList.add("odyssey");
                    wordFinder.wordList.add("analogy");
                    wordFinder.wordList.add("bravado");
                }
                break;
        }
        return wordFinder.wordList;
    }

    public Set<String> findWords(WordFinder wordFinder, ArrayList<Character> userEnteredChars) {
        //If all elements from userEnteredChars has been compared to every character from each element of wordList,
        //return all of the words found.
        if (wordFinder.userEnteredCharIndex == userEnteredChars.size() - 1) {
            return wordFinder.compareCharsToAllWords(wordFinder, userEnteredChars);
        }
        //If a letter from userEnteredChars has been compared to every character of each element of wordList, move onto
        //the next letter and reset the value of wordListIndex to zero, so this next letter can be compared against all of
        //the characters from wordList.
        if (wordFinder.wordListIndex == wordFinder.wordList.size()) {
            wordFinder.userEnteredCharIndex++;
            wordFinder.wordListIndex = 0;
            findWords(wordFinder, userEnteredChars);
        }
        return wordFinder.compareCharsToAllWords(wordFinder, userEnteredChars);
    }

    //Compare every single letter from userEnteredChars against every char from every word in the wordList
    private Set<String> compareCharsToAllWords(WordFinder wordFinder, ArrayList<Character> userEnteredChars) {
        //If a match of a letter to a word has been made, every character within userEnteredChars needs to be compared
        //against the word to see if that word can be made from the characters provided.
        wordFinder.userEnteredCharOccurrence = 0;

        //compares the first character from userEnteredChars against all the characters in the first word of the
        //wordList. If a match of a char to a word has been made, call returnFoundWords(), otherwise, compare this letter
        //against the next word in the wordList. If this letter has been compared against every character from all the words
        //in the wordList, increment the value of userEnteredCharIndex by 1 and repeat these steps with the next letter to see
        //if a match can be found.
        for (int currentCharacterIndex = 0; currentCharacterIndex < wordFinder.wordList.get(wordListIndex).length() + 1; currentCharacterIndex++) {
            if (wordFinder.userEnteredCharIndex == userEnteredChars.size() - 1) {
                return wordFinder.compareCharsToSingleWord(wordFinder, userEnteredChars);
            }
            if (currentCharacterIndex == wordFinder.wordList.get(wordFinder.wordListIndex).length()) {
                wordFinder.wordListIndex++;
                wordFinder.findWords(wordFinder, userEnteredChars);
            } else if (userEnteredChars.get(wordFinder.userEnteredCharIndex) == wordFinder.wordList.get(wordListIndex).charAt(currentCharacterIndex)) {
                wordFinder.compareCharsToSingleWord(wordFinder, userEnteredChars);
                wordFinder.lettersFound = "";
                wordFinder.wordListIndex++;
                wordFinder.findWords(wordFinder, userEnteredChars);
            }
        }
        return wordFinder.compareCharsToSingleWord(wordFinder, userEnteredChars);
    }

    private Set<String> compareCharsToSingleWord(WordFinder wordFinder, ArrayList<Character> userEnteredChars) {
        int wordLength = wordFinder.wordList.get(wordListIndex).length();
        String word = wordFinder.wordList.get(wordListIndex);

        //If all of the characters from userEnteredChars have been tested against the word that was initially matched on,
        //return all of the words that were found.
        if (wordFinder.userEnteredCharOccurrence == userEnteredChars.size()) {
            return wordFinder.foundWordsList;
        }

        //When an initial match of a letter from userEnteredChars to wordList has been made,
        //go through every letter of the userEnteredChars and compare it to the word initially
        //matched on to see all of the character occurrences within the word.
        for (int currentIndex = 0; currentIndex < wordFinder.wordList.get(wordListIndex).length(); currentIndex++) {
            if (userEnteredChars.get(wordFinder.userEnteredCharOccurrence) == wordFinder.wordList.get(wordListIndex).charAt(currentIndex)) {
                wordFinder.lettersFound += userEnteredChars.get(wordFinder.userEnteredCharOccurrence);
            }
        }
        //If the first element of userEnteredChars has been compared to every char of the word that was initially matched on, and the length
        //of the concatenated string is not the same length as the word, this means that the word is not able to be created from the lettersFound
        //variable. Therefore, call this method again but increment the value of userEnteredCharOccurrence by 1 to find all occurrences
        //of the next letter on this word and so on.
        if (lettersFound.length() != wordLength) {
            wordFinder.userEnteredCharOccurrence++;
            wordFinder.compareCharsToSingleWord(wordFinder, userEnteredChars);
        } else {
            wordFinder.foundWordsList.add(word);
        }
        return wordFinder.foundWordsList;
    }
}
