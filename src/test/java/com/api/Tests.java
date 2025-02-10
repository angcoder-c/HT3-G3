package com.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.api.sorts.Quicksort;
import com.api.sorts.MergeSort;
import com.api.sorts.InsertionSort;
import com.api.sorts.RadixSort;
import com.api.sorts.BucketSort;

public class Tests {

    @Test
    public void test() {
        // Prueba trivial, siempre pasa
        assertEquals(true, true);
    }

    @Test
    public void testQuicksort() {
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, Quicksort.sort(input));
    }

    @Test
    public void testMergeSort() {
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, MergeSort.sort(input));
    }

    @Test
    public void testInsertionSort() {
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, InsertionSort.sort(input));
    }

    @Test
    public void testRadixSort() {
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, RadixSort.sort(input));
    }

    @Test
    public void testBucketSort() {
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, BucketSort.sort(input));
    }
}