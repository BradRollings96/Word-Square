package com.company.word_finder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordFinder {
    ArrayList<String> wordList = new ArrayList<>();
    Set<String> foundWordsList = new HashSet<>();

    int wordIndex = 0; //we initially search for the first word in our dictionary
    int charArrayIndex = 0; //we want to iterate through the char array from the first value, so we always start with zero
    String lettersFound = "";

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
                    wordFinder.wordList.add("armor");
                    wordFinder.wordList.add("stone");
                    wordFinder.wordList.add("feast");
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

    public Set<String> findOuterWord(WordFinder wordFinder, ArrayList<Character> charArray) {

        if (charArrayIndex == charArray.size() - 1) {
            return foundWordsList;
        }

        if (wordIndex == wordFinder.wordList.size()) {
            charArrayIndex++;
            wordIndex = 0;
            findOuterWord(wordFinder, charArray);
        }

        for (int letterCounter = 0; letterCounter < wordFinder.wordList.get(wordIndex).length() + 1; letterCounter++) {

            if (charArrayIndex == charArray.size() - 1) {
                return foundWordsList;
            } else if (letterCounter == wordFinder.wordList.get(wordFinder.wordIndex).length()) {
                wordIndex++;
                wordFinder.findOuterWord(wordFinder, charArray);
            } else if (charArray.get(wordFinder.charArrayIndex) == wordFinder.wordList.get(wordIndex).charAt(letterCounter)) {
                int foundWordCounter = 0;
                wordFinder.returnFoundWords(wordFinder, charArray, foundWordCounter);
                wordFinder.lettersFound = "";
                wordIndex++;
                wordFinder.findOuterWord(wordFinder, charArray);
            }
        }
        return foundWordsList;
    }

    private Set<String> returnFoundWords(WordFinder wordFinder, ArrayList<Character> charArray, int foundWordCounter) {
        int wordLength = wordFinder.wordList.get(wordIndex).length();
        String word = wordFinder.wordList.get(wordIndex);

        for (int counter = 0; counter < wordFinder.wordList.get(wordIndex).length(); counter++) {
            if (charArray.get(foundWordCounter) == wordFinder.wordList.get(wordIndex).charAt(counter)) {
                wordFinder.lettersFound += charArray.get(foundWordCounter);
            }
        }

        //we've gone through all the instances of a letter in the for loop above and the length of the string isn't the same
        //as the length of the word were, looking for, therefore weve tested all instances of that char against the word and need
        //to call this method again but with the next letter along in the charArray list.
        if (lettersFound.length() != wordLength) {
            foundWordCounter++;
            wordFinder.returnFoundWords(wordFinder, charArray, foundWordCounter);
        } else {
            wordFinder.foundWordsList.add(word);
        }
        return wordFinder.foundWordsList;
    }
}
