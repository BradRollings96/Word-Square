package com.company.word_square;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class WordSquareTest {

    @Test
    public void testThatResultSizeWillBeTheSameAsWordLengthIfItIsAValidWordSquareWithFourWords() {

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> words = new ArrayList<>();

        words.add("once");
        words.add("moan");
        words.add("acme");
        words.add("need");

        int currentIndex = 0;
        ArrayList<String> canMakeAWordSquare = wordSquare.findAllPossibleWords(words, currentIndex);

        Assertions.assertEquals(words.size(), canMakeAWordSquare.size());
    }

    @Test
    public void testThatResultSizeWillNotBeTheSameAsWordLengthIfItIsNotAValidWordSquareWithFourWords() {

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> words = new ArrayList<>();

        words.add("open");
        words.add("moan");
        words.add("acme");
        words.add("need");

        int currentIndex = 0;
        ArrayList<String> makeAWordSquare = wordSquare.findAllPossibleWords(words, currentIndex);

        Assertions.assertNotEquals(words.size(), makeAWordSquare.size());
    }

    @Test
    public void testThatResultSizeWillBeTheSameAsWordLengthIfItIsAValidWordSquareWithFiveWords() {

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> words = new ArrayList<>();

        words.add("armor");
        words.add("earth");
        words.add("threw");
        words.add("stone");
        words.add("feast");

        int currentIndex = 0;
        ArrayList<String> makeAWordSquare = wordSquare.findAllPossibleWords(words, currentIndex);

        Assertions.assertEquals(words.size(), makeAWordSquare.size());
    }

    @Test
    public void testThatResultSizeWillNotBeTheSameAsWordLengthIfItIsNotAValidWordSquareWithFiveWords() {

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> words = new ArrayList<>();

        words.add("armor");
        words.add("earth");
        words.add("threw");
        words.add("stoin");
        words.add("feast");

        int currentIndex = 0;
        ArrayList<String> makeAWordSquare = wordSquare.findAllPossibleWords(words, currentIndex);

        Assertions.assertNotEquals(words.size(), makeAWordSquare.size());
    }

    @Test
    public void testThatResultSizeWillBeTheSameAsWordLengthIfItIsAValidWordSquareWithFiveWordsWithDifferentWords() {

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> words = new ArrayList<>();

        words.add("ember");
        words.add("above");
        words.add("revue");
        words.add("heart");
        words.add("trees");

        int currentIndex = 0;
        ArrayList<String> makeAWordSquare = wordSquare.findAllPossibleWords(words, currentIndex);

        Assertions.assertEquals(words.size(), makeAWordSquare.size());
    }

    @Test
    public void testThatResultSizeWillNotBeTheSameAsWordLengthIfItIsNotAValidWordSquareWithFiveWordsWithDifferentWords() {

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> words = new ArrayList<>();

        words.add("ember");
        words.add("above");
        words.add("revue");
        words.add("heart");
        words.add("treas");

        int currentIndex = 0;
        ArrayList<String> makeAWordSquare = wordSquare.findAllPossibleWords(words, currentIndex);

        Assertions.assertNotEquals(words.size(), makeAWordSquare.size());
    }

    @Test
    public void testThatResultSizeWillBeTheSameAsWordLengthIfItIsAValidWordSquareWithSevenWords() {

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> words = new ArrayList<>();

        words.add("valuers");
        words.add("renamed");
        words.add("degrade");
        words.add("odyssey");
        words.add("amoebas");
        words.add("bravado");
        words.add("analogy");

        int currentIndex = 0;
        ArrayList<String> makeAWordSquare = wordSquare.findAllPossibleWords(words, currentIndex);

        Assertions.assertEquals(words.size(), makeAWordSquare.size());
    }

    @Test
    public void testThatResultSizeWillNotBeTheSameAsWordLengthIfItIsNotAValidWordSquareWithSevenWords() {

        WordSquare wordSquare = new WordSquare();
        ArrayList<String> words = new ArrayList<>();

        words.add("valuers");
        words.add("renamed");
        words.add("degrade");
        words.add("odyssey");
        words.add("amoebas");
        words.add("bravada");
        words.add("analogy");

        int currentIndex = 0;
        ArrayList<String> makeAWordSquare = wordSquare.findAllPossibleWords(words, currentIndex);

        Assertions.assertNotEquals(words.size(), makeAWordSquare.size());
    }
}
