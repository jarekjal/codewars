package jarejal.codewars;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Survivors5Test {
    @Test
    public void lengthOne() {
        assertEquals("afs", sort(Survivors5.survivors(new String[]{"afs"})));
        assertEquals("kl", sort(Survivors5.survivors(new String[]{"l k"})));
        assertEquals("bb", sort(Survivors5.survivors(new String[]{"bb bb"})));
        assertEquals("adfg", sort(Survivors5.survivors(new String[]{"afdg  bb"})));
    }

    @Test
    public void lengthMultiple() {
        assertEquals("ab", sort(Survivors5.survivors(new String[]{"ab", "  ", "d"})));
        assertEquals("", sort(Survivors5.survivors(new String[]{"a", " b ", "d"})));
        assertEquals("ab", sort(Survivors5.survivors(new String[]{"a", "b", "  d"})));
        assertEquals("jv", sort(Survivors5.survivors(new String[]{"a", " ", " v", " j"})));

        assertEquals("", sort(Survivors5.survivors(new String[]{"tb", "ch", "  gt"})));
        assertEquals("abcd", sort(Survivors5.survivors(new String[]{"    abcd", "f"})));
        assertEquals("ar", sort(Survivors5.survivors(new String[]{"      ", "      ", "  ra  ", "      ", "      "})));
        assertEquals("fgx", sort(Survivors5.survivors(new String[]{"             a", "      ", "", "        fxg"})));

        assertEquals("zzzzz", sort(Survivors5.survivors(new String[]{"b", "f", "", "aaa", "z z", "zzz"})));
        assertEquals("bz", sort(Survivors5.survivors(new String[]{"   a", "bz"})));
        assertEquals("", sort(Survivors5.survivors(new String[]{"opq", "   ", "amd   "})));
        assertEquals("abcdefg", sort(Survivors5.survivors(new String[]{"a b", "cde", "f g"})));

        assertEquals("ab", sort(Survivors5.survivors(new String[]{"ab  ", "ch  ", " ", " gt "})));
        assertEquals("aat", sort(Survivors5.survivors(new String[]{"r     ", "    ", "  aa  ", "        ", "j    g  t"})));
        assertEquals("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", sort(Survivors5.survivors(new String[]{"xxxx xxxxx xx", "xxxxxxxxxxxx", "xxx xxxx xx"})));
        assertEquals("abcdefghijklm", sort(Survivors5.survivors(new String[]{"a  z  m", "bc   kl", " de ij ", "  fgh  "})));

        assertEquals("x", sort(Survivors5.survivors(new String[]{"      o      ", "     o o     ", "    o   o    ", "   o  x  o   ", "    o   o    ", "     o o     ", "      o      "})));
        assertEquals("ccddddhiijjjjkmsux", sort(Survivors5.survivors(new String[]{"   oc umdd    ", "  o hjk  h  ", "  o      j", "         j", "ll   sddiijccx"})));
        assertEquals("", sort(Survivors5.survivors(new String[]{"a gggg", "aa ggg  ", "aaa gg         ", "aaaa g        "})));
    }

    @Test
    public void islands() {
        assertEquals("df", sort(Survivors5.survivors(new String[]{"a", "", "fd"})));
        assertEquals("kklp", sort(Survivors5.survivors(new String[]{"agd", "", "", "", "klkp"})));
    }

    @Test
    public void newEdge() {
        assertEquals("", sort(Survivors5.survivors(new String[]{" l", "bon b", "m  n m  ", "p  oj p o j", "    u z", " f   ic", "h     r", " ej x ", "  x", " bdr", "  fp  b ", "dkh  o", "  pw", " b ", "tld lk", "    dur", " wm ", "x  ", "o g", "  f px"})));
        assertEquals("addkmoty", sort(Survivors5.survivors(new String[]{" o", "", "  ", "", "", " o    ia  ", "wn  g    ", "  e g v  w", " mk  z", "u    ", "a    o ", "n ", "   i  ", "n  bk", " d  t t ", "        q  ", "", "  l  ", "", " dmy s  d "})));
        assertEquals("", sort(Survivors5.survivors(new String[]{" q   x", "    ", "  dr      ", "g t   ", "s   d e", "    a  e", " z i  s ", "     o   ", "o  u  j   ", " o z", "ib    e  ", "    qe db", "    ", " dzu      ", "", " w xqks ", "  f   n", "k   ", "", " l  e i  f"})));
    }

    static private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
