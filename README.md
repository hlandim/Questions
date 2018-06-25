## 1. Replacing characters in place:

Given an array of characters, write a method to replace all the spaces with “&32”.
You may assume that the array has sufficient slots at the end to hold the additional
characters, and that you are given the “true” length of the array. (Please perform this
operation in place with no other auxiliary structure).

Example:  
Input: “User is not allowed “, 19  
Output: “User&32is&32not&32allowed”

Solution: [here](Q1-2-3-5-7/src/QuestionOne.kt)

## 2. Check words with jumbled letters:

Our brain can read texts even if letters are jumbled, like the following sentence: “Yuo
cna porbalby raed tihs esaliy desptie teh msispeillgns.” Given two strings, write a
method to decide if one is a partial-permutation of the other. Consider a
partial-permutation only if:

- The first letter hasn’t changed place
- If word has more than 3 letters, up to 2/3 of the letters have changed place

Examples:  
you, yuo -> true  
probably, porbalby -> true  
despite, desptie -> true  
moon, nmoo -> false  
misspellings, mpeissngslli -> false

Solution: [here](Q1-2-3-5-7/src/QuestionTwo.kt)

## 3. Check words with typos:
There are three types of typos that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to
check if they are one typo (or zero typos) away.  

Examples:  
pale, ple -> true   
pales, pale -> true  
pale, bale -> true 
pale, bake -> false  
Solution: [here](Q1-2-3-5-7/src/QuestionThree.kt)
