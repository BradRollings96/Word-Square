package com.company.word_square;

import java.util.ArrayList;

public class WordSquare {

    ArrayList<String> wordSquareWords = new ArrayList<>();

    //columnWordIndex goes to the right (increments) if the letters of a column are equal to a word
    int columnWordIndex;

    //word row index goes down a row to the next word (increments) if it finds a match
    int wordRowIndex;
    boolean hasWordSquareBeenFound;

    public WordSquare() {
        this.columnWordIndex = 0;
        this.wordRowIndex = 0;
        this.hasWordSquareBeenFound = false;
    }

    public ArrayList<String> findAllPossibleWords(ArrayList<String> wordsFound, int currentIndex) {

        if(this.wordSquareWords.size() == wordsFound.size()) {
            return this.wordSquareWords;
        }
        for (int indexPosition = currentIndex; indexPosition < wordsFound.size(); indexPosition++) {
            java.util.Collections.swap(wordsFound, indexPosition, currentIndex);
            findAllPossibleWords(wordsFound, currentIndex + 1);
            java.util.Collections.swap(wordsFound, currentIndex, indexPosition);
        }

        if (currentIndex == wordsFound.size() - 1) {

            if (!this.hasWordSquareBeenFound) {

                String columnWord = this.findColumnWord(wordsFound);

                if (columnWord.equals(wordsFound.get(this.wordRowIndex))) {
                    this.wordSquareWords.add(columnWord);
                    this.wordRowIndex++;
                    this.columnWordIndex++;
                    ArrayList<String> fullWordSquare = this.isWordSquareValid(wordsFound);

                    fullWordSquare.forEach(System.out::println);

                } else {
                    return this.wordSquareWords;
                }
            }
            //TODO: If we've iterated through all the values and the word square hasn't been found
           /* if (wordSquare.wordSquareWords.size() == wordSquare.listOfWords.size()) {
                System.out.println("Error: Unable to make a word square with the words provided");
            }*/
        }
        return this.wordSquareWords;
    }

    private ArrayList<String> isWordSquareValid(ArrayList<String> wordsFound) {
        String columnWord = "";

        if (this.wordRowIndex == wordsFound.size()) {
            return this.wordSquareWords;
        }
        for (int characterIndex = 0; characterIndex < wordsFound.get(wordRowIndex).length(); characterIndex++) {
            columnWord += wordsFound.get(wordRowIndex).charAt(characterIndex);
        }

        if (columnWord.equals(wordsFound.get(this.wordRowIndex))) {

            this.wordSquareWords.add(columnWord);
            this.wordRowIndex++;
            this.columnWordIndex++;
            if (this.wordRowIndex == wordsFound.size()) {
                return this.wordSquareWords;
            }
            else {
                this.isWordSquareValid(wordsFound);
            }
        }
        return this.wordSquareWords;
    }

    private String findColumnWord(ArrayList<String> wordsFound) {
        String columnWord = "";
        for (String word : wordsFound) {
            columnWord += word.charAt(this.columnWordIndex);
        }
        return columnWord;
    }
}
