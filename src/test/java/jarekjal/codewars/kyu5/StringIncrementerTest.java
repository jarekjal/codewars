package jarekjal.codewars.kyu5;

import org.junit.Test;

import static jarekjal.codewars.kyu5.StringIncrementer.incrementString;
import static org.junit.Assert.assertEquals;

public class StringIncrementerTest {

    @Test
    public void test() {
        assertEquals(incrementString("fo654obar000"), "fo654obar001");
        assertEquals(incrementString(""), "1");
    }

}