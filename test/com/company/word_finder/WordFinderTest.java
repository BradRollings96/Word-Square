package com.company.word_finder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Set;

public class WordFinderTest {

    @Test
    public void testFindOuterWordToSeeIfItReturnsAllWordsWithCorrectData() {
        WordFinder wordFinder = new WordFinder();
        ArrayList<Character> charArray = new ArrayList<>();

        //Given a character Array that contains all the letters that will make all the words from the wordList array
        charArray.add('a');
        charArray.add('c');
        charArray.add('d');
        charArray.add('e');
        charArray.add('m');
        charArray.add('n');
        charArray.add('o');

        wordFinder.wordList.add("acme");
        wordFinder.wordList.add("moan");
        wordFinder.wordList.add("once");
        wordFinder.wordList.add("need");

        //when we findOuterWord
        Set<String> isMatch = wordFinder.findWords(wordFinder, charArray);

        //then we will expect the length of returnFoundWords to be equal to the length of the wordList
        Assertions.assertEquals(isMatch.size(), wordFinder.wordList.size());
    }

    @Test
    public void testFindOuterWordToSeeIfItReturnsAllWordsWithIncorrectData() {
        WordFinder wordFinder = new WordFinder();
        ArrayList<Character> charArray = new ArrayList<>();

        //Given a character Array containing letters that will not make all of the words from the wordList
        charArray.add('a');
        charArray.add('c');
        charArray.add('d');
        charArray.add('e');
        charArray.add('m');
        charArray.add('n');
        charArray.add('o');

        wordFinder.wordList.add("acme");
        wordFinder.wordList.add("moan");
        wordFinder.wordList.add("open");
        wordFinder.wordList.add("need");

        //when we call to findCharInWord is made
        Set<String> isMatch = wordFinder.findWords(wordFinder, charArray);

        //then we will expect the length of findCharInWord to be less than the length of the wordList array
        Assertions.assertNotEquals(isMatch.size(), wordFinder.wordList.size());
    }
}
