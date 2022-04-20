## Word Square Application

This is an application that works by initially entering a number representing what the dimensions
of the word square should be 

The second part you then have to enter the letters you want to use in the word square


This application works via different components the first being a word finder which is designed to find words from the letters provided
that are valid words, it then passes these valid words to the word square to see if can create a word square from the words provided

### Word Finder

The way the word finder works is by passing an array list of characters the user has provided into a function named `findCharInWord`

#### Application Flow
Here is an example of how this application works, given the two arrays below:

`wordList = {"rose", "oven", "send", "ends"`
<br></br>
`userEnteredChars = ['d', 'e', 'n', 'o', 'r', 's', 'v']`

#### compareCharsToAllWords

1. The `compareCharsToAllWords` method works by starting with the first element of the `userEnteredChars` array and going through the characters of the first word in the `wordList`, if this character from the 
`userEnteredChars` is found in this word, then a call to the method `compareCharsToSingleWord` is made. If the letter is not found, and the end character of the word has been reached, then the variable `wordListIndex`
is incremented in an attempt to find the first character `'d'` in the next word of the array. These steps are repeated until the first letter has checked every char from 
every word in the `wordList`, then the `userEnteredCharIndex` variable is incremented by one and the variable `wordListIndex` is reset to zero. The next letter `'e'` is then compared against all the characters in the `wordList`.
These steps are repeated until the last letter `'v'` is reached and then the variable `foundWordList` is returned
   

2. When a match is finally made, which in this example would be the letter `'d'` on the word `send`, then a call the method `compareCharsToSingleWord` is made

#### compareCharsToSingleWord

3. When a match of a letter from `userEnteredChars` to a word form the `wordList` is made, then iterate over each character of this word and compare it to the letters from the `userEnteredChars`, starting with the first letter to see how many instances of the letter you can find. 
If there is a match, concatenate this letter to a string variable called `lettersFound`, then move along to the next letter in the `userEnteredChars` which is `'e'` and find any matches with this letter in this same word, and repeat these steps until the last letter `'v'` is reached in `userEnteredChars`


4. Eventually, if the correct characters are in `userEnteredChars`, the length of the `lettersFound` variable will be equal to the length of the word being searched for; which means that this word can be made from the characters provided in `userEnteredChars`.
This word is then added to an array list `foundWordsList` and the method is exited.


#### compareCharsToAllWords
5. Once the method is returned to `compareCharsToAllWords`, then the `wordListIndex` variable is incremented so the letter `'d'` from `userEnteredChars` can also be checked against the other words remaining in the `wordList`, if a match is found on any other word, steps `2-5` will be repeated 


6. When the first letter has been checked against all the words, and therefore the `wordListindex` is equal to the length of the `wordList`, the `wordListIndex` is reset back to zero and the `userEnteredCharIndex` is incremented by one. This will now
test the next character along in `userEnteredChars` `'e'` with the first word in the `wordList` and all the steps above are repeated until the last letter `'v'` of the `charArray` has been reached
   
### Running the Application

To run the app, run the main method found in `src/com.company/main`, or you can execute the distributable jar file located in `/out/artifacts/Word_Square_jar/Word-Square.jar` via the command line
like so: `java -jar {path_to_jar_file}/Word-Square.jar`
