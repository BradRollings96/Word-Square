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
    public ArrayList<String> setupWordList(int lengthOfWords, String allCharacters) {
        switch (lengthOfWords) {
            case 4:
                if (allCharacters.equals("eeeeddoonnnsssrv")) {
                    this.wordList.add("ends");
                    this.wordList.add("oven");
                    this.wordList.add("rose");
                    this.wordList.add("send");
                }
                else if(allCharacters.equals("aaccdeeeemmnnnoo")) {
                    this.wordList.add("acme");
                    this.wordList.add("once");
                    this.wordList.add("need");
                    this.wordList.add("moan");
                }
                break;
            case 5:
                if (allCharacters.equals("aaaeeeefhhmoonssrrrrttttw")) {
                    this.wordList.add("earth");
                    this.wordList.add("threw");
                    this.wordList.add("feast");
                    this.wordList.add("armor");
                    this.wordList.add("stone");
                }
                else if (allCharacters.equals("aabbeeeeeeeehmosrrrruttvv")) {
                    this.wordList.add("above");
                    this.wordList.add("revue");
                    this.wordList.add("ember");
                    this.wordList.add("heart");
                    this.wordList.add("trees");
                }
                break;
            case 7:
                if(allCharacters.equals("aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy")) {
                    this.wordList.add("renamed");
                    this.wordList.add("degrade");
                    this.wordList.add("amoebas");
                    this.wordList.add("valuers");
                    this.wordList.add("odyssey");
                    this.wordList.add("analogy");
                    this.wordList.add("bravado");
                }
                break;
        }
        return this.wordList;
    }

    public Set<String> findWords(ArrayList<Character> userEnteredChars) {
        //If all elements from userEnteredChars has been compared to every character from each element of wordList,
        //return all of the words found.
        if (this.userEnteredCharIndex == userEnteredChars.size() - 1) {
            return this.compareCharsToAllWords(userEnteredChars);
        }
        //If a letter from userEnteredChars has been compared to every character of each element of wordList, move onto
        //the next letter and reset the value of wordListIndex to zero, so this next letter can be compared against all of
        //the characters from wordList.
        if (this.wordListIndex == this.wordList.size()) {
            this.userEnteredCharIndex++;
            this.wordListIndex = 0;
            this.findWords(userEnteredChars);
        }
        return this.compareCharsToAllWords(userEnteredChars);
    }

    //Compare every single letter from userEnteredChars against every char from every word in the wordList
    private Set<String> compareCharsToAllWords(ArrayList<Character> userEnteredChars) {
        //If a match of a letter to a word has been made, every character within userEnteredChars needs to be compared
        //against the word to see if that word can be made from the characters provided.
        this.userEnteredCharOccurrence = 0;

        //compares the first character from userEnteredChars against all the characters in the first word of the
        //wordList. If a match of a char to a word has been made, call returnFoundWords(), otherwise, compare this letter
        //against the next word in the wordList. If this letter has been compared against every character from all the words
        //in the wordList, increment the value of userEnteredCharIndex by 1 and repeat these steps with the next letter to see
        //if a match can be found.
        for (int currentCharacterIndex = 0; currentCharacterIndex < this.wordList.get(wordListIndex).length() + 1; currentCharacterIndex++) {
            if (this.userEnteredCharIndex == userEnteredChars.size() - 1) {
                return this.compareCharsToSingleWord(userEnteredChars);
            }
            if (currentCharacterIndex == this.wordList.get(this.wordListIndex).length()) {
                this.wordListIndex++;
                this.findWords(userEnteredChars);
            } else if (userEnteredChars.get(this.userEnteredCharIndex) == this.wordList.get(wordListIndex).charAt(currentCharacterIndex)) {
                this.compareCharsToSingleWord(userEnteredChars);
                this.lettersFound = "";
                this.wordListIndex++;
                this.findWords(userEnteredChars);
            }
        }
        return this.compareCharsToSingleWord(userEnteredChars);
    }

    private Set<String> compareCharsToSingleWord(ArrayList<Character> userEnteredChars) {
        int wordLength = this.wordList.get(wordListIndex).length();
        String word = this.wordList.get(wordListIndex);

        //If all of the characters from userEnteredChars have been tested against the word that was initially matched on,
        //return all of the words that were found.
        if (this.userEnteredCharOccurrence == userEnteredChars.size()) {
            return this.foundWordsList;
        }

        //When an initial match of a letter from userEnteredChars to wordList has been made,
        //go through every letter of the userEnteredChars and compare it to the word initially
        //matched on to see all of the character occurrences within the word.
        for (int currentIndex = 0; currentIndex < this.wordList.get(wordListIndex).length(); currentIndex++) {
            if (userEnteredChars.get(this.userEnteredCharOccurrence) == this.wordList.get(wordListIndex).charAt(currentIndex)) {
                this.lettersFound += userEnteredChars.get(this.userEnteredCharOccurrence);
            }
        }
        //If the first element of userEnteredChars has been compared to every char of the word that was initially matched on, and the length
        //of the concatenated string is not the same length as the word, this means that the word is not able to be created from the lettersFound
        //variable. Therefore, call this method again but increment the value of userEnteredCharOccurrence by 1 to find all occurrences
        //of the next letter on this word and so on.
        if (this.lettersFound.length() != wordLength) {
            this.userEnteredCharOccurrence++;
            this.compareCharsToSingleWord(userEnteredChars);
        } else {
            this.foundWordsList.add(word);
        }
        return this.foundWordsList;
    }
}
