package jarekjal.codewars;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralsTest {

    @Test
    public void testToRoman() throws Exception {
        assertThat("1 converts to 'I'", RomanNumerals.toRoman(1), is("I"));
        assertThat("2 converts to 'II'", RomanNumerals.toRoman(2), is("II"));
        assertThat("1980 MCMLXXX", RomanNumerals.toRoman(1980), is("MCMLXXX"));
        assertThat("1666 MDCLXVI", RomanNumerals.toRoman(1666), is("MDCLXVI"));
        assertThat("3666 MMMDCLXVI", RomanNumerals.toRoman(3666), is("MMMDCLXVI"));
        assertThat("666 DCLXVI", RomanNumerals.toRoman(666), is("DCLXVI"));
        assertThat("1888 MDCCCLXXXVIII", RomanNumerals.toRoman(1888), is("MDCCCLXXXVIII"));
    }

    @Test
    public void testFromRoman() throws Exception {
        assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("II"), is(2));
    }
}