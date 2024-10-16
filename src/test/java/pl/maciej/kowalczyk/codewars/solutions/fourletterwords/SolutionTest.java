package pl.maciej.kowalczyk.codewars.solutions.fourletterwords;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {
    @Test
    public void basicTests() {
        String[] alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
        String[] bob = new String[]{"boar", "clap", "mere", "lend", "near", "peat", "pure", "more", "plan", "soap"};
        assertEquals( 0, Solution.mutations(alice, bob, "maze", 0)); // Alice goes  first, Alice   wins
        assertEquals( 1, Solution.mutations(alice, bob, "send", 0)); // Alice goes  first, Bob     wins
        assertEquals( 1, Solution.mutations(alice, bob, "boat", 0)); // Alice fails first, Bob     wins
        assertEquals(-1, Solution.mutations(alice, bob, "apse", 0)); // Alice fails first, neither wins
        assertEquals( 1, Solution.mutations(alice, bob, "flap", 1)); // Bob   goes  first, Bob     wins
        assertEquals( 0, Solution.mutations(alice, bob, "soar", 1)); // Bob   goes  first, Alice   wins
        assertEquals( 0, Solution.mutations(alice, bob, "more", 1)); // Bob   fails first, Alice   wins
        assertEquals(-1, Solution.mutations(alice, bob, "calm", 1)); // Bob   fails first, neither wins
    }
}