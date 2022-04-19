package com.company.word_finder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordFinderTest {

    @Test
    public void testThatFindWordsSizeWillFindAllFourWordsIfItHasCorrectCharacters() {
        WordFinder wordFinder = new WordFinder();

        wordFinder.wordList.add("acme");
        wordFinder.wordList.add("moan");
        wordFinder.wordList.add("once");
        wordFinder.wordList.add("need");

        char[] chars = {'a', 'c', 'd', 'e', 'm', 'n', 'o'};
        ArrayList<Character> charArray = new ArrayList<>();

        for(char c: chars) {
            charArray.add(c);
        }

        Set<String> findWordsFromChars = wordFinder.findWords(charArray);

        Assertions.assertEquals(findWordsFromChars.size(), wordFinder.wordList.size());
    }

    @Test
    public void testThatFindWordsSizeWillNotFindAllFourWordsIfItHasIncorrectCharacters() {
        WordFinder wordFinder = new WordFinder();

        wordFinder.wordList.add("acme");
        wordFinder.wordList.add("moan");
        wordFinder.wordList.add("onpe");
        wordFinder.wordList.add("need");

        char[] chars = {'a', 'c', 'd', 'e', 'm', 'n', 'o'};
        ArrayList<Character> charArray = new ArrayList<>();

        for(char c: chars) {
            charArray.add(c);
        }

        Set<String> findWordsFromChars = wordFinder.findWords(charArray);

        Assertions.assertNotEquals(findWordsFromChars.size(), wordFinder.wordList.size());
    }

    @Test
    public void testThatFindWordsSizeWillFindAllFiveWordsIfItHasCorrectCharacters() {
        WordFinder wordFinder = new WordFinder();

        wordFinder.wordList.add("acme");
        wordFinder.wordList.add("armor");
        wordFinder.wordList.add("feast");
        wordFinder.wordList.add("threw");
        wordFinder.wordList.add("stone");

        char[] chars = {'a', 'e', 'f', 'h', 'm', 'n', 'o', 'r', 's', 't', 'w'};
        ArrayList<Character> charArray = new ArrayList<>();

        for(char c: chars) {
            charArray.add(c);
        }

        Set<String> findWordsFromChars = wordFinder.findWords(charArray);

        Assertions.assertEquals(findWordsFromChars.size(), wordFinder.wordList.size());
    }

    @Test
    public void testThatFindWordsSizeWillNotFindAllFiveWordsIfItHasIncorrectCharacters() {
        WordFinder wordFinder = new WordFinder();

        wordFinder.wordList.add("acme");
        wordFinder.wordList.add("armor");
        wordFinder.wordList.add("feast");
        wordFinder.wordList.add("thrzw");
        wordFinder.wordList.add("stone");

        char[] chars = {'a', 'e', 'f', 'h', 'm', 'n', 'o', 'r', 's', 't', 'w'};
        ArrayList<Character> charArray = new ArrayList<>();

        for(char c: chars) {
            charArray.add(c);
        }

        Set<String> findWordsFromChars = wordFinder.findWords(charArray);

        Assertions.assertNotEquals(findWordsFromChars.size(), wordFinder.wordList.size());
    }

    @Test
    public void testThatFindWordsWillFindAllFiveWordsIfItHasCorrectCharacters() {
        WordFinder wordFinder = new WordFinder();

        wordFinder.wordList.add("above");
        wordFinder.wordList.add("heart");
        wordFinder.wordList.add("ember");
        wordFinder.wordList.add("revue");
        wordFinder.wordList.add("trees");

        char[] chars = {'a', 'b', 'e', 'h', 'm', 'o', 'r', 's', 't', 'u', 'v'};
        ArrayList<Character> charArray = new ArrayList<>();

        for(char c: chars) {
            charArray.add(c);
        }

        Set<String> findWordsFromChars = wordFinder.findWords(charArray);

        Assertions.assertEquals(findWordsFromChars.size(), wordFinder.wordList.size());
    }

    @Test
    public void testThatFindWordsWillNotFindAllFiveWordsIfItHasIncorrectCharacters() {
        WordFinder wordFinder = new WordFinder();

        wordFinder.wordList.add("above");
        wordFinder.wordList.add("heart");
        wordFinder.wordList.add("embxr");
        wordFinder.wordList.add("revue");
        wordFinder.wordList.add("trees");

        char[] chars = {'a', 'b', 'e', 'h', 'm', 'o', 'r', 's', 't', 'u', 'v'};
        ArrayList<Character> charArray = new ArrayList<>();

        for(char c: chars) {
            charArray.add(c);
        }

        Set<String> findWordsFromChars = wordFinder.findWords(charArray);

        Assertions.assertNotEquals(findWordsFromChars.size(), wordFinder.wordList.size());
    }

    @Test
    public void testThatFindWordsSizeWillFindAllSevenWordsIfItHasCorrectCharacters() {
        WordFinder wordFinder = new WordFinder();

        wordFinder.wordList.add("valuers");
        wordFinder.wordList.add("analogy");
        wordFinder.wordList.add("amoebas");
        wordFinder.wordList.add("odyssey");
        wordFinder.wordList.add("degrade");
        wordFinder.wordList.add("renamed");
        wordFinder.wordList.add("bravado");

        char[] chars = {'a', 'b', 'd', 'e', 'g', 'l', 'm', 'n', 'o', 'r', 's', 'u', 'v', 'y'};
        ArrayList<Character> charArray = new ArrayList<>();

        for(char c: chars) {
            charArray.add(c);
        }

        Set<String> findWordsFromChars = wordFinder.findWords(charArray);

        Assertions.assertEquals(findWordsFromChars.size(), wordFinder.wordList.size());
    }

    @Test
    public void testThatFindWordsSizeWillNotFindAllSevenWordsIfItHasIncorrectCharacters() {
        WordFinder wordFinder = new WordFinder();

        wordFinder.wordList.add("valuers");
        wordFinder.wordList.add("analogy");
        wordFinder.wordList.add("amoebas");
        wordFinder.wordList.add("odyssey");
        wordFinder.wordList.add("degrade");
        wordFinder.wordList.add("renamed");
        wordFinder.wordList.add("bravadz");

        char[] chars = {'a', 'b', 'd', 'e', 'g', 'l', 'm', 'n', 'o', 'r', 's', 'u', 'v', 'y'};
        ArrayList<Character> charArray = new ArrayList<>();

        for(char c: chars) {
            charArray.add(c);
        }

        Set<String> findWordsFromChars = wordFinder.findWords(charArray);

        Assertions.assertNotEquals(findWordsFromChars.size(), wordFinder.wordList.size());
    }
}
