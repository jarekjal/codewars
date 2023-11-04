package jarekjal.codewars.kyu5;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PickPeaksTest {

    @Test
    public void test() {

        var result1 = PickPeaks.getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3});
        assertEquals(result1.get("pos"), new ArrayList<Integer>(Arrays.asList(3, 7)));
        assertEquals(result1.get("peaks"), new ArrayList<Integer>(Arrays.asList(6, 3)));

        var result2 = PickPeaks.getPeaks(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1});
        assertEquals(result2.get("pos"), new ArrayList<Integer>(Arrays.asList(1)));
        assertEquals(result2.get("peaks"), new ArrayList<Integer>(Arrays.asList(2)));

        var result3 = PickPeaks.getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1});
        assertEquals(result3.get("pos"), new ArrayList<Integer>(Arrays.asList(3, 7, 10)));
        assertEquals(result3.get("peaks"), new ArrayList<Integer>(Arrays.asList(6, 3, 2)));

        var result4 = PickPeaks.getPeaks(new int[]{3, 2, 3, 3, 1, 2});
        assertEquals(result4.get("pos"), new ArrayList<Integer>(Arrays.asList(2)));
        assertEquals(result4.get("peaks"), new ArrayList<Integer>(Arrays.asList(3)));

    }

}