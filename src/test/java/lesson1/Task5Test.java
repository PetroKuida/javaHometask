package test.java.lesson1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static main.java.lesson1.Task5.reverse;
import static org.testng.Assert.assertEquals;

public class Task5Test {
    @Parameters({"testString"})
    @Test
    public void testRevertedString(String testString) {
        String actualResult = reverse(testString);
        String expectedResult = new StringBuilder(testString).reverse().toString();
        assertEquals(
                actualResult,
                expectedResult,
                "reverse string should be " + expectedResult
        );
    }
}
