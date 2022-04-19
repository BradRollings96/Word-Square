package com.company.word_square;

import com.company.app.App;

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

        //If the for loop has tried every possible combination and has been unsuccessful in creating a word square,
        // notify the user and exit the application
        if (currentIndex == 0 && wordSquareWords.size() != wordsFound.size()) {
            System.out.println("Error: Unable to make word square from words provided\nEnter any button to exit");
            App.exitApplication();
        }

        returnWordSquare(wordsFound, currentIndex);
        return wordSquareWords;
    }

    //If it is, then treat this as the first row and column and call isWordSquareValid()
    private void returnWordSquare(ArrayList<String> wordsFound, int currentIndex) {
        int endOfWords = wordsFound.size() - 1;
        if (currentIndex == endOfWords) {
            String columnWord = findColumnWord(wordsFound);

            //When the first row and column are the same, check that all of the other words are in the correct structure
            //to create a word square by checking the next word down with the next character along and repeating this until
            //one can be made
            if (columnWord.equals(wordsFound.get(wordRowIndex))) {
                wordSquareWords.add(columnWord);
                wordRowIndex++;
                columnWordIndex++;

                isWordSquareValid(wordsFound).forEach(System.out::println);
            }
        }
    }

    //Once the first row and first column are equal, then check that the second letter of each word
    //is equal to the second element, then check that the third character of each element is equal to the third word and so on...
    private ArrayList<String> isWordSquareValid(ArrayList<String> wordsFound) {
        String columnWord = "";

        //When this condition is true, a word square has been made, so return its value
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
