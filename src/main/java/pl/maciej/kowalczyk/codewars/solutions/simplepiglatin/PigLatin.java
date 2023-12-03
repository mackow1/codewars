package pl.maciej.kowalczyk.codewars.solutions.simplepiglatin;

/*
https://www.codewars.com/kata/520b9d2ad5c005041100000f/train/java

Move the first letter of each word to the end of it, then add "ay" to the end of the word.
Leave punctuation marks untouched.

Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !
 */

public class PigLatin {
    public static String pigIt(String str) {

        String[] arrayString = str.split(" ");
        String result = "";

        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].matches("\\b[A-Za-z]+\\b")) {
                result += reposition(arrayString[i]);

                if (i != arrayString.length - 1) {
                    result += " ";
                }
            } else {
                result += arrayString[i];
            }
        }

        return result;
    }

    private static String reposition(String s) {
        String firstLetter = String.valueOf(s.charAt(0));
        return s.substring(1) + firstLetter + "ay";
    }
}