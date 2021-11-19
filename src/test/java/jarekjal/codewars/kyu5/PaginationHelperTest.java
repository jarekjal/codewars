package jarekjal.codewars.kyu5;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaginationHelperTest {
    @Test
    public void testSomething() {
        PaginationHelper<Integer> helper = new PaginationHelper<>(List.of(1, 2, 3, 4, 5), 2);
        assertEquals(3, helper.pageCount());
    }
}