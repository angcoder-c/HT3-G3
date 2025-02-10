package com.api;

import java.util.ArrayList;

import com.api.sorts.Bucketsort;
import com.api.sorts.Insertionsort;
import com.api.sorts.Mergesort;
import com.api.sorts.Quicksort;

public class Sort implements AlgorithmInterface {
    private ArrayList<Number> source = new ArrayList<>();

    public Sort (ArrayList<Number> source) {
        this.source = source;
    }

    // quick sort
    public ArrayList<Number> quick() {
        Quicksort sort = new Quicksort();
        return sort.sort(this.source);
    }

    public ArrayList<Number> merge () {
        // rene
        Mergesort sort = new Mergesort();
        return sort.sort(this.source);
    }

    public ArrayList<Number> insertion () {
        // arturo
        Insertionsort sort = new Insertionsort();
        return sort.sort(this.source);
    }

    public ArrayList<Number> radix () {
        // arturo
        Radixsort sort = new Radixsort();
        return sort.sort(this.source);
    }

    public ArrayList<Number> bucket () {
        // rene
        Bucketsort sort = new Bucketsort();
        return sort.sort(this.source);
    }
}
