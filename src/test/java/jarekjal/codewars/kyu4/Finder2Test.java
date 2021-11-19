package jarekjal.codewars.kyu4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Finder2Test {

    @Test
    public void sampleTests() {

        String a = ".W.\n" +
                ".W.\n" +
                "...",

                b = ".W.\n" +
                        ".W.\n" +
                        "W..",

                c = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        "......",

                d = "......\n" +
                        "......\n" +
                        "......\n" +
                        "......\n" +
                        ".....W\n" +
                        "....W.";

        Assert.assertEquals(a, 4, Finder2.pathFinder(a));
        assertEquals(b, -1, Finder2.pathFinder(b));
        assertEquals(c, 10, Finder2.pathFinder(c));
        assertEquals(d, -1, Finder2.pathFinder(d));
    }
}

