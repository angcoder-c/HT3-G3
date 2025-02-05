package com.api;

import java.util.ArrayList;
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
        return new ArrayList<Number>();
    }

    public ArrayList<Number> insertion () {
        // arturo
        return new ArrayList<Number>();
    }

    public ArrayList<Number> radix () {
        // arturo
        return new ArrayList<Number>();
    }

    public ArrayList<Number> bucket () {
        // rene
        return new ArrayList<Number>();
    }
}
