package jarekjal.codewars;

import jarejal.codewars.PangramChecker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PangramCheckerTest {
    @Test
    public void test1() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        PangramChecker pc = new PangramChecker();
        assertEquals(true, pc.check(pangram1));
    }
    @Test
    public void test2() {
        String pangram2 = "You shall not pass!";
        PangramChecker pc = new PangramChecker();
        assertEquals(false, pc.check(pangram2));
    }

    @Test
    public void test3() {
        String pangram2 = "Abcdefghijklmnopqrstuvwxyz";
        PangramChecker pc = new PangramChecker();
        assertEquals(true, pc.check(pangram2));
    }
}
