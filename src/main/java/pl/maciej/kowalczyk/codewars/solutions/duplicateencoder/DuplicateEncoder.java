package pl.maciej.kowalczyk.codewars.solutions.duplicateencoder;

/*
https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/java

The goal of this exercise is to convert a string to a new string
where each character in the new string is "(" if that character appears only once in the original string,
or ")" if that character appears more than once in the original string.
Ignore capitalization when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("
Notes
Assertion messages may be unclear about what they display in some languages.
If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
 */

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {
    static String encode(String word) {
        word = word.toLowerCase();
        Map<Character, Integer> characters = convertToMap(word);

        String result = "";

        for (int i = 0; i < word.length(); i++){
            if (characters.get(word.charAt(i)) > 1) {
                result += ")";
            } else {
                result += "(";
            }
        }
        return result;
    }

    private static Map<Character, Integer> convertToMap(String word) {
        Map<Character, Integer> characters = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!characters.containsKey(c)) {
                characters.put(c, 1);
            } else {
                characters.put(c, characters.get(c) + 1);
            }
        }
        return characters;
    }
}
