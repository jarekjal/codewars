package jarekjal.codewars.kyu4;

import static org.junit.Assert.*;

import jarekjal.codewars.kyu4.DoubleLinear;
import org.junit.Test;


public class DoubleLinearTest {

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests dblLinear");
        testing(DoubleLinear.dblLinear(10), 22);
        testing(DoubleLinear.dblLinear(20), 57);
        testing(DoubleLinear.dblLinear(30), 91);
        testing(DoubleLinear.dblLinear(50), 175);

        testing(DoubleLinear.dblLinear(20000), 377625);
    }
}
