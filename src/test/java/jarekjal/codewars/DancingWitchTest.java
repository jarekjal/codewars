package jarekjal.codewars;

import static org.junit.Assert.*;

import jarejal.codewars.DancingWitch;
import org.junit.Assert;
import org.junit.Test;

public class DancingWitchTest {
    @Test
    public void basic() {
        Assert.assertEquals("a", DancingWitch.figureOut(new String[]{"a b", " ba"}));
        assertEquals("b", DancingWitch.figureOut(new String[]{"ab kl", "ba kl", "a blk"}));
        assertEquals("w", DancingWitch.figureOut(new String[]{"icwth", "wicth", "witch"}));
        assertEquals("f", DancingWitch.figureOut(new String[]{"abcdef", "abcfde"}));
        assertEquals("a", DancingWitch.figureOut(new String[]{"a  b  c", "a b  c ", " ba   c"}));
        assertEquals("x", DancingWitch.figureOut(new String[]{"bc  x", " bcx ", " xbc "}));
        assertEquals("c", DancingWitch.figureOut(new String[]{"abcd", "cabd"}));
        assertEquals("z", DancingWitch.figureOut(new String[]{"xyz", "yxz", "zyx"}));
        assertEquals("y", DancingWitch.figureOut(new String[]{" x y z ", " xy  z ", "yx   z ", " xy  z "}));
        assertEquals(null, DancingWitch.figureOut(new String[]{"hop", "hpo", "pho"}));
    }

    @Test
    public void newEdge() {
        assertEquals("b", DancingWitch.figureOut(new String[]{"abdgefc", "adbegcf", "daebgfc", "adegfcb", "aedfgbc", "adegfcb", "dagecfb", "adegfcb", "adgefbc"}));
        assertEquals("d", DancingWitch.figureOut(new String[]{"dac   b ", "acd    b", "adc    b", "acd   b ", "ca d   b", "c ad  b ", "c ad  b ", " ca db  ", " ac bd  "}));
        assertEquals(null, DancingWitch.figureOut(new String[]{"cb feg da", "bcf ge ad", "cbfg ea d", "cfb gae d", "fcbga e d", "fbcag  ed", "bfac ged ", "baf cgde "}));
    }
}
