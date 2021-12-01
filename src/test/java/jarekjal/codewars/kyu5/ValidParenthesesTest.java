package jarekjal.codewars.kyu5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ValidParenthesesTest {
    @Test
    public void sampleTest() {
        assertEquals(true, ValidParentheses.validParentheses("()"));
        assertEquals(false, ValidParentheses.validParentheses("())"));
        assertEquals(true, ValidParentheses.validParentheses("32423(sgsdg)"));
        assertEquals(false, ValidParentheses.validParentheses("(dsgdsg))2432"));
        assertEquals(true, ValidParentheses.validParentheses("adasdasfa"));
    }
}
