package test.java.lesson1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import static main.java.lesson1.Task2.result;

public class Task2Test {

    @Test
    public void checkTotalNumberOfNames () {

        int actualNum = (result().split("Petro", -1).length - 1);
        System.out.println(actualNum);
        int expectedNum = 50;
        assertEquals(
                actualNum,
                expectedNum,
                "Expected number of name occurance is " + expectedNum
        );
    }
}
