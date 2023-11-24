package pl.maciej.kowalczyk.codewars.solutions.multiplesof3or5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(23, new Solution().solution(10));
        assertEquals(78, new Solution().solution(20));
        assertEquals(14, new Solution().solution(7));
        assertEquals(0, new Solution().solution(1));
        assertEquals(45, new Solution().solution(15));
        assertEquals(195, new Solution().solution(30));
    }

}
