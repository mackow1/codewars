package pl.maciej.kowalczyk.codewars.solutions.humanreadbletime;

/*
https://www.codewars.com/kata/52685f7382004e774f0001f7/train/java

Write a function, which takes a non-negative integer (seconds) as input
and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.
 */

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        String result = "";

        int hours = seconds / 3600;
        int minutes = (seconds - hours * 3600) / 60;
        seconds = seconds % 60;

        result += hours >= 10 ? "" + hours : "0" + hours;
        result += minutes >= 10 ? ":" + minutes : ":0" + minutes;
        result += seconds >= 10 ? ":" + seconds : ":0" + seconds;

        return result;
    }
}
