package jarejal.codewars;

import org.junit.Test;
        import static org.junit.Assert.assertEquals;
        import org.junit.runners.JUnit4;

public class ColouredTrianglesTest {

    @Test
    public void examples() {
        // assertEquals("expected", "actual");
        assertEquals('R', ColouredTriangles.triangle("GB"));
        assertEquals('R', ColouredTriangles.triangle("RRR"));
        assertEquals('B', ColouredTriangles.triangle("RGBG"));
        assertEquals('G', ColouredTriangles.triangle("RBRGBRB"));
        assertEquals('G', ColouredTriangles.triangle("RBRGBRBGGRRRBGBBBGG"));
        assertEquals('B', ColouredTriangles.triangle("B"));
    }
}