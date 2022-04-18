package com.company.wordfinder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordFinder {
    ArrayList<String> englishDictionary = new ArrayList<>();
    Set<String> foundWordsList = new HashSet<>();

    int wordIndex = 0; //we initially search for the first word in our dictionary
    int charArrayIndex = 0; //we want to iterate through the char array from the first value, so we always start with zero
    String lettersFound = "";

    public static void setupDictionary(WordFinder wordFinder) {

        wordFinder.englishDictionary.add("rose");
        wordFinder.englishDictionary.add("oven");
        wordFinder.englishDictionary.add("send");
        wordFinder.englishDictionary.add("ends");

//        wordFinder.englishDictionary.add("amoebas");
//        wordFinder.englishDictionary.add("bravado");
//        wordFinder.englishDictionary.add("odyssey");
//        wordFinder.englishDictionary.add("renamed");
//        wordFinder.englishDictionary.add("valuers");
//        wordFinder.englishDictionary.add("degrade");
//        wordFinder.englishDictionary.add("analogy");


//        wordFinder.englishDictionary.add("earth");
//        wordFinder.englishDictionary.add("stone");
//        wordFinder.englishDictionary.add("threw");
//        wordFinder.englishDictionary.add("armor");
//        wordFinder.englishDictionary.add("feast");
    }

    public Set<String> findOuterWord(WordFinder wordFinder, ArrayList<Character> charArray) {

        if (charArrayIndex == charArray.size() - 1) {
            return foundWordsList;
        }

        if (wordIndex == wordFinder.englishDictionary.size()) {
            charArrayIndex++;
            wordIndex = 0;
            findOuterWord(wordFinder, charArray);
        }

        for (int letterCounter = 0; letterCounter < wordFinder.englishDictionary.get(wordIndex).length() + 1; letterCounter++) {

            if (charArrayIndex == charArray.size() - 1) {
                return foundWordsList;
            } else if (letterCounter == wordFinder.englishDictionary.get(wordFinder.wordIndex).length()) {
                wordIndex++;
                wordFinder.findOuterWord(wordFinder, charArray);
            } else if (charArray.get(wordFinder.charArrayIndex) == wordFinder.englishDictionary.get(wordIndex).charAt(letterCounter)) {
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
        int wordLength = wordFinder.englishDictionary.get(wordIndex).length();
        String word = wordFinder.englishDictionary.get(wordIndex);

        for (int charInWordIndex = 0; charInWordIndex < wordFinder.englishDictionary.get(wordIndex).length(); charInWordIndex++) {
            if (charArray.get(foundWordCounter) == wordFinder.englishDictionary.get(wordIndex).charAt(charInWordIndex)) {
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
