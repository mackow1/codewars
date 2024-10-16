package pl.maciej.kowalczyk.codewars.solutions.fourletterwords;

/*
https://www.codewars.com/kata/5cb5eb1f03c3ff4778402099/train/java

Our Setup

Alice and Bob work in an office. When the workload is light and the boss isn't looking, they sometimes play simple word games for fun.
This is one of those days!

Today's Game

Alice and Bob are playing what they like to call Mutations, where they take turns trying to "think up" a new four-letter word (made up of four unique letters)
that is identical to the prior word except for only one letter. They just keep on going until their memories fail out.

Their Words

Alice and Bob have memories of the same size, each able to recall 10 to 2000 different four-letter words.
Memory words and initial game word are randomly taken from the same list of 4000 (unique, four-letter, lowercased) words, any of which may appear in both memories.

The expression to "think up" a new word means that for their turn, the player must submit as their response word the first valid,
unused word that appears in their memory (by lowest array index), as their memories are ordered from the most "memorable" words to the least.

The Rules

a valid response word must contain four unique letters
1 letter is replaced while the other 3 stay in position
it must be the lowest indexed valid word in that memory
this word cannot have already been used during the game
the final player to provide a valid word will win the game
if 1st player fails 1st turn, 2nd can win with one word
when both players fail the initial word, there is no winner
Your Task

To determine the winner!
 */

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static final Logger LOGGER = Logger.getLogger(Solution.class.getName());
    public static int mutations(String[] alice, String[] bob, String word, int first) {
        LOGGER.info("mutations(gameWord = " + word + ", first = " + first + ")");

        String wordToCheck = word;
        String aliceWord = "";
        String bobWord = "";
        boolean isGameFinished = false;
        int round = 0;

        List<String> aliceWords = new ArrayList<>(Arrays.asList(alice));
        List<String> bobWords = new ArrayList<>(Arrays.asList(bob));

        aliceWords.remove(word);
        bobWords.remove(word);

        while (!isGameFinished) {
            switch (first) {
                case 0:
                    if (bobWord != null) {
                        first = 1;
                    }

                    aliceWord = gameRound(wordToCheck, aliceWords);

                    if (aliceWord != null) {
                        wordToCheck = aliceWord;
                    }
                    aliceWords.remove(aliceWord);
                    round++;
                    break;
                case 1:
                    if (aliceWord != null) {
                        first = 0;
                    }

                    bobWord = gameRound(wordToCheck, bobWords);

                    if (bobWord != null) {
                        wordToCheck = bobWord;
                    }
                    bobWords.remove(bobWord);
                    round++;
                    break;
            }

            if (aliceWord == null && bobWord == null) {
                first = -1;
                isGameFinished = true;
            } else if (round >= 2 && (aliceWord == null || bobWord == null)) {
                isGameFinished = true;
            }
        }

        LOGGER.info("mutations(...) = " + first);
        return first;
    }

    private static String gameRound(String word, List<String> playersWords) {
        LOGGER.info("gameRound(word = " + word + ", playersWords = " + playersWords + ")");

        Optional<String> resultOptional = playersWords.stream()
                .filter(str -> isWordValidToUse(word, str))
                .findFirst();

        String result = resultOptional.orElse(null);

        LOGGER.info("gameRound(...) = " + result);
        return result;
    }

    private static boolean isWordValidToUse(String opponentWord, String playerWord) {
        LOGGER.info("isWordValidToUse(opponentWord = " + opponentWord + ", playerWord = " + playerWord + ")");

        boolean isWordValid = false;

        Set<Character> playerWordAsSet = playerWord.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        if (playerWordAsSet.size() < 4) {
            LOGGER.info("isWordValidToUse(...) = " + isWordValid);
            return false;
        }

        long howManyCharsAreTheSameAtTheSamePosition = IntStream.range(0, opponentWord.length())
                .filter(i -> opponentWord.charAt(i) == playerWord.charAt(i))
                .count();

        if (howManyCharsAreTheSameAtTheSamePosition == 3) {
            isWordValid = true;
        }

        LOGGER.info("isWordValidToUse(...) = " + isWordValid);
        return isWordValid;
    }
}
