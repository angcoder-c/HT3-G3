package com.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.api.sorts.Quicksort;
import com.api.sorts.Mergesort;
import com.api.sorts.Insertionsort;
import com.api.sorts.Radixsort;
import com.api.sorts.Bucketsort;

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

        // Usando directamente el método estático de Quicksort
        assertEquals(expected, Quicksort.sort(input));
    }

    @Test
    public void testMergeSort() {
        Mergesort mergeSort = new Mergesort();  // Instanciamos la clase
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, mergeSort.sort(input));  // Usamos la instancia
    }

    @Test
    public void testInsertionSort() {
        Insertionsort insertionSort = new Insertionsort();  // Instanciamos la clase
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, insertionSort.sort(input));  // Usamos la instancia
    }

    @Test
    public void testRadixSort() {
        Radixsort radixSort = new Radixsort();  // Instanciamos la clase
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, radixSort.sort(input));  // Usamos la instancia
    }

    @Test
    public void testBucketSort() {
        Bucketsort bucketSort = new Bucketsort();  // Instanciamos la clase
        ArrayList<Number> input = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        ArrayList<Number> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8));

        assertEquals(expected, bucketSort.sort(input));  // Usamos la instancia
    }
}