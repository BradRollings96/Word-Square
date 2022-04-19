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

        Set<String> isMatch = wordFinder.findWords(charArray);

        Assertions.assertEquals(isMatch.size(), wordFinder.wordList.size());
    }

    @Test
    public void testFindOuterWordToSeeIfItReturnsAllWordsWithIncorrectData() {
        WordFinder wordFinder = new WordFinder();
        ArrayList<Character> charArray = new ArrayList<>();

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

        Set<String> isMatch = wordFinder.findWords(charArray);

        Assertions.assertNotEquals(isMatch.size(), wordFinder.wordList.size());
    }
}
