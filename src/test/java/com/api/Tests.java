package com.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.api.sorts.Quicksort;

public class Tests {
    @Test
    public void test() {
        assertEquals(true, true);
    }

    @Test
    public void testQuicksort() {
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, Quicksort.sort(input));
    }
    /*
     @Test
     public void test() {
        // Assert methods
     }
     */
}