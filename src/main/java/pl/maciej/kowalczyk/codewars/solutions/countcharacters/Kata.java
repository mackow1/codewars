package pl.maciej.kowalczyk.codewars.solutions.countcharacters;

import java.util.HashMap;
import java.util.Map;

public class Kata {
    public static Map<Character, Integer> count(String str) {

        char[] charArray = str.toCharArray();
        Map<Character, Integer> characterCounted = new HashMap<>();

        for (Character c : charArray) {
            characterCounted.put(c, characterCounted.getOrDefault(c, 0) + 1);
        }
        return characterCounted;
    }
}