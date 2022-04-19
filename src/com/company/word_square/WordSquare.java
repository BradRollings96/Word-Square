package com.company.word_square;

import java.util.ArrayList;

public class WordSquare {

    ArrayList<String> wordSquareWords = new ArrayList<>();

    //columnWordIndex goes to the right (increments) if the letters of a column are equal to a word
    int columnWordIndex = 0;

    //wordRowIndex goes down a row to the next word (increments) if it finds a match
    int wordRowIndex = 0;
    boolean hasWordSquareBeenFound = false;


    //Runs permutation to find every possible combination of the array provided from WordFinder
    public ArrayList<String> findAllPossibleWords(ArrayList<String> wordsFound, int currentIndex) {
        if (wordSquareWords.size() == wordsFound.size()) {
            return wordSquareWords;
        }
        for (int indexPosition = currentIndex; indexPosition < wordsFound.size(); indexPosition++) {
            java.util.Collections.swap(wordsFound, indexPosition, currentIndex);
            findAllPossibleWords(wordsFound, currentIndex + 1);
            java.util.Collections.swap(wordsFound, currentIndex, indexPosition);
        }

        hasMatchBeenFound(wordsFound, currentIndex);
        return wordSquareWords;
    }

    //This works by concatenating the first element of each word and checking if the result is equal to the word on the first row.
    //If it is, add this word to an array called
    private void hasMatchBeenFound(ArrayList<String> wordsFound, int currentIndex) {
        int endOfWords = wordsFound.size() - 1;
        if (currentIndex == endOfWords) {
            String columnWord = findColumnWord(wordsFound);

            if (columnWord.equals(wordsFound.get(wordRowIndex))) {
                wordSquareWords.add(columnWord);
                wordRowIndex++;
                columnWordIndex++;

                ArrayList<String> fullWordSquare = isWordSquareValid(wordsFound);
                fullWordSquare.forEach(System.out::println);
            }
        }
    }

    private ArrayList<String> isWordSquareValid(ArrayList<String> wordsFound) {
        String columnWord = "";

        if (wordRowIndex == wordsFound.size()) {
            return wordSquareWords;
        }
        for (int characterIndex = 0; characterIndex < wordsFound.get(wordRowIndex).length(); characterIndex++) {
            columnWord += wordsFound.get(wordRowIndex).charAt(characterIndex);
        }

        if (columnWord.equals(wordsFound.get(wordRowIndex))) {
            wordSquareWords.add(columnWord);
            wordRowIndex++;
            columnWordIndex++;
            if (wordRowIndex == wordsFound.size()) {
                return wordSquareWords;
            } else {
                isWordSquareValid(wordsFound);
            }
        }
        return wordSquareWords;
    }

    private String findColumnWord(ArrayList<String> wordsFound) {
        String columnWord = "";
        for (String word : wordsFound) {
            columnWord += word.charAt(columnWordIndex);
        }
        return columnWord;
    }
}
