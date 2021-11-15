package jarekjal.codewars;


import jarejal.codewars.CreatePhoneNumber;
import org.junit.Assert;
import org.junit.Test;
        import static org.junit.Assert.assertEquals;

public class CreatePhoneNumberTest {
    @Test
    public void tests() {
        Assert.assertEquals("(123) 456-7890", CreatePhoneNumber.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}