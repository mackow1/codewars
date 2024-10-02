package pl.maciej.kowalczyk.codewars.solutions.weightforweight;

/*
https://www.codewars.com/kata/55c6126177c9441a570000cc/train/java

My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month a list with the weights of members is published and each month he is the last on the list which means he is the heaviest.

I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list". It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.

For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.

Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?

Example:
"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:

"100 180 90 56 65 74 68 86 99"
When two numbers have the same "weight", let us class them as if they were strings (alphabetical ordering) and not numbers:

180 is before 90 since, having the same "weight" (9), it comes before as a string.

All numbers in the list are positive numbers and the list can be empty.
 */

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WeightSort {

    private static final Logger LOGGER = Logger.getLogger(WeightSort.class.getName());

    public static String orderWeight(String string) {
        LOGGER.info("orderWeight(" + string + ")");

        String result = Arrays.stream(string.split(" "))
                .sorted(Comparator.comparingInt(WeightSort::splitAndAdd)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.joining(" "));

        LOGGER.info("orderWeight(...) = " + result);
        return result;
    }

    private static int splitAndAdd(String numberAsString) {
        LOGGER.info("splitAndAdd(" + numberAsString + ")");

        int sum = 0;

        for (char c : numberAsString.toCharArray()) {
            sum += Character.getNumericValue(c);
        }

        LOGGER.info("splitAndAdd(...) = " + sum);
        return sum;
    }
}