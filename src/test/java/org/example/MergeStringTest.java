package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeStringTest {
    MergeString mergeString;

    @Before
    public void setUp() {
        mergeString = new MergeString();
    }

    @Test
    public void mergeTest() {

        try {
            String output = mergeString.showMerge();
            Assert.assertEquals("haratres", output);
            System.out.println(output);
        } catch (IllegalArgumentException e) {
           System.err.println("Hata: " + e.getMessage());

        }
    }
}
