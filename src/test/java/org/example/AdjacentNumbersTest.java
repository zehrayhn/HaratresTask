package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdjacentNumbersTest {

    private AdjacentNumbers adjacentNumbers;

    @Before
    public void setUp() {
        adjacentNumbers = new AdjacentNumbers();

    }

    @Test
    public void findAdjacentNumbersTest() {


        String expected = "D={\"12 15\", \"32 35\"}";
        String output = adjacentNumbers.showAdjacentNumbers();
        Assert.assertEquals(expected, output);
        System.out.println(output);

    }


}
