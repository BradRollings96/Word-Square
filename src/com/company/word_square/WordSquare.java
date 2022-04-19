package com.company.word_square;

import java.util.ArrayList;


public class WordSquare {

    private final ArrayList<String> wordSquareWords = new ArrayList<>();
    private int columnWordIndex = 0; //columnWordIndex goes to the right (increments) if the letters of a column are equal to a word
    private int wordRowIndex = 0; //wordRowIndex goes down a row to the next word (increments) if it finds a match

    //Runs permutation to find every possible combination of the array provided from wordsFound
    public ArrayList<String> findAllPossibleWords(ArrayList<String> wordsFound, int currentIndex) {
        if (wordSquareWords.size() == wordsFound.size()) {
            return wordSquareWords;
        }
        for (int indexPosition = currentIndex; indexPosition < wordsFound.size(); indexPosition++) {
            java.util.Collections.swap(wordsFound, indexPosition, currentIndex);
            findAllPossibleWords(wordsFound, currentIndex + 1);
            java.util.Collections.swap(wordsFound, currentIndex, indexPosition);
        }
        return createWordSquare(wordsFound, currentIndex);
    }

    //If it is, then treat this as the first row and column and call isWordSquareValid()
    private ArrayList<String> createWordSquare(ArrayList<String> wordsFound, int currentIndex) {
        int endOfWords = wordsFound.size() - 1;

        if (wordRowIndex == wordsFound.size()) {
            return wordSquareWords;
        }

        if (currentIndex == endOfWords) {
            String columnWord = findColumnWord(wordsFound);

            //When the first row and column are the same, check that all of the other words are in the correct structure
            //to create a word square by checking the next word down with the next character along and repeating this until
            //one can be made
            if (columnWord.equals(wordsFound.get(wordRowIndex))) {
                wordSquareWords.add(columnWord);
                wordRowIndex++;
                columnWordIndex++;

                createWordSquare(wordsFound, currentIndex);
            }
        }
        return wordSquareWords;
    }

    //This works by concatenating the first letter of each element (columnWordIndex) and checking if the result is equal to the first element (first row).
    //Then it will check the second character of each word and check if that is equal to the second word, then it will check if the third character of each
    //word is equal to the third word and so on
    private String findColumnWord(ArrayList<String> wordsFound) {
        String columnWord = "";
        for (String word : wordsFound) {
            columnWord += word.charAt(columnWordIndex);
        }
        return columnWord;
    }
}
