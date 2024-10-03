package pl.maciej.kowalczyk.codewars.solutions.firstnonrepeatingcharacter;

/*
https://www.codewars.com/kata/52bc74d4ac05d0945d00054e/train/java

Write a function named first_non_repeating_letter† that takes a string input, and returns the first character that is not repeated anywhere in the string.

For example, if given the input 'stress', the function should return 't', since the letter t only occurs once in the string, and occurs first in the string.

As an added challenge, upper- and lowercase letters are considered the same character, but the function should return the correct case for the initial letter. For example, the input 'sTreSS' should return 'T'.

If a string contains all repeating characters, it should return an empty string ("");

† Note: the function is called firstNonRepeatingLetter for historical reasons, but your function should handle any Unicode character.
 */

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Kata {

    private static final Logger LOGGER = Logger.getLogger(Kata.class.getName());

    public static String firstNonRepeatingLetter(String s) {
        LOGGER.info("firstNonRepeatingLetter(" + s + ")");
        String result = "";
        int indexOfFoundCharacter;

        Set<String> lettersFound = new HashSet<>();

        String lowerCased = s.toLowerCase();
        StringBuilder sb = new StringBuilder(lowerCased);
        String letterToFind;

        while (!sb.isEmpty()) {
            letterToFind = String.valueOf(sb.charAt(0));
            sb.deleteCharAt(0);

            if (sb.indexOf(letterToFind) == -1 && !lettersFound.contains(letterToFind)) {
                indexOfFoundCharacter = lowerCased.indexOf(letterToFind);
                result = String.valueOf(s.charAt(indexOfFoundCharacter));
                break;
            }
            lettersFound.add(letterToFind);
        }

        LOGGER.info("firstNonRepeatingLetter(...) = " + result);
        return result;
    }
}
