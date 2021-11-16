package jarekjal.codewars;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DubstepTest {
    @Test
    public void Test1() {
        Assert.assertEquals("ABC", new Dubstep().songDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
        assertEquals("R L", new Dubstep().songDecoder("RWUBWUBWUBLWUB"));
    }
}