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

`wordArray = {"rose", "oven", "send", "ends"`
<br></br>
`charArray = ['d', 'e', 'n', 'o', 'r', 's', 'v']`

#### findCharInWord

1. The `findCharInWord` method works by starting with the first element of the char array and going through the characters of the first word in the word array, if this character from the 
char array is found in this word, then a call to the method `returnFoundWords` is made. If the letter is not found, and the end char of the word has been reached, then the variable `wordIndex`
is incremented in an attempt to find the first character `'d'` in the next word of the array. These steps are repeated until the first letter has checked every char from 
every word in the `wordArray`, then the `charArrayIndex` variable is incremented by one and the variable `wordIndex` is reset to zero. The next letter `'e'` is then compared against all the characters in the `wordArray`.
These steps are repeated until the last letter `'v'` is reached and then return the variable  `foundWordList`
   

2. When a match is finally made, which in this example would be the letter `'d'` on the word `send`, then a call the method `returnFoundWords` is made

#### returnFoundWords

3. When a match of a letter from the `charArray` to a word form the `wordArray` is made, then iterate over each character of this word and compare it to the letters from the `charArray`, starting with the first letter to see how many instances of the letter you can find. 
If there is a match, concatenate this letter to a string variable called `lettersFound`, then move along to the next letter in the `charArray` which is `'e'` and find any matches with this letter in this same word, and repeat these steps until the last letter `'v'` is reached in the `charArray`


4. Eventually, if the correct characters are in the `charArray`, the length of the `lettersFound` variable will be equal to the length of the word being searched for; which means that this word can be made from the characters provided in the `charArray`.
This word is then added to an array list `foundWordsList` and the method is exited.
   

5. Once the method is returned back to `findCharInWord`, then the `wordIndex` variable is incremented so the letter from the `charArray` can also be checked against the other words remaining in the `wordArray`


6. When the first letter has been checked against all the words, and therefore the `wordindex` is equal to the length of the `wordArray`, the `wordIndex` is reset back to zero and the `charArrayIndex` is incremented by one. This will now
test the next character along in the `charArray` `'b'` with the first word in the `wordArray` and all the steps above are repeated until the last letter of the `charArray` has been reached
