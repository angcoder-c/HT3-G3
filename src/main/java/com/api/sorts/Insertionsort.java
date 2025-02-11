package com.api.sorts;
import com.api.IOApp;

import java.util.ArrayList;

public class Insertionsort {
    public ArrayList<Number> sort(ArrayList<Number> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        int n = list.size();
        for (int i = 1; i < n; i++) {
            Number key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).doubleValue() > key.doubleValue()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        return list;
    }

    // para el profiler
    public static void main(String[] args) {
        IOApp app = new IOApp();
        Insertionsort sort = new Insertionsort();
        // Desordenado
        // sort.sort(app.randomNumbers(3000));
        // ordenado
        sort.sort(sort.sort(app.randomNumbers(3000)));
    }
}