package test.java.lesson1;
import org.testng.annotations.*;

import static main.java.lesson1.Task1.min;
import static org.testng.Assert.assertEquals;

public class Task1Test {
    @Test(dataProvider = "variables")
    public void checkResultIsCorrectForPartitionEquivalenceCases (int a, int b, int c){
        int actualMin = min(a, b, c);
        int expectedMin = Math.min(a, Math.min(b, c));
        assertEquals(
                actualMin,
                expectedMin,
                "Expected min of (" + a + ", " + b + ", " + c + ") is " + expectedMin
        );

    }

    @DataProvider(name = "variables")
    public Object[][] getData() {
        return new Object[][] {
                {1, 1, 1},
                {2, 4, 6},
                {5, 3, 7},
                {4, 7, -3},
                {2, 2, 5},
        };
    }
}
