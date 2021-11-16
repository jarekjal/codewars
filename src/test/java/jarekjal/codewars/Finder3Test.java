package jarekjal.codewars;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Finder3Test {
    @Test
    public void sampleTests() {

        String a = "000\n" +
                "000\n" +
                "000",

                b = "010\n" +
                        "010\n" +
                        "010",

                c = "010\n" +
                        "101\n" +
                        "010",

                d = "0707\n" +
                        "7070\n" +
                        "0707\n" +
                        "7070",

                e =     "700000\n" +
                        "077770\n" +
                        "077770\n" +
                        "077770\n" +
                        "077770\n" +
                        "000007",

                f =     "777000\n" +
                        "007000\n" +
                        "007000\n" +
                        "007000\n" +
                        "007000\n" +
                        "007777",

                g = "000000\n" +
                        "000000\n" +
                        "000000\n" +
                        "000010\n" +
                        "000109\n" +
                        "001010",

        h =     "7777000000\n" +
                "0007000000\n" +
                "0007000000\n" +
                "0007770000\n" +
                "0000070000\n" +
                "0000070000\n" +
                "0000070000\n" +
                "0000070000\n" +
                "0000070000\n" +
                "0000077777";

        Assert.assertEquals(0, Finder3.pathFinder(a));
        assertEquals(2, Finder3.pathFinder(b));
        assertEquals(4, Finder3.pathFinder(c));
        assertEquals(42, Finder3.pathFinder(d));
        assertEquals(14, Finder3.pathFinder(e));
        assertEquals(0, Finder3.pathFinder(f));
        assertEquals(4, Finder3.pathFinder(g));
        //assertEquals(0, Finder3.pathFinder(h));
    }
}