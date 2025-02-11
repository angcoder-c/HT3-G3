package com.api.sorts;

import com.api.IOApp;

import java.util.ArrayList;
import java.util.Collections;

public class Radixsort {

    public ArrayList<Number> sort(ArrayList<Number> data) {
        if (data == null || data.isEmpty()) return data;

        Number max = getMax(data);

        for (long exp = 1; getLongValue(max) / exp > 0; exp *= 10) {
            bucketPass(data, exp);
        }

        return data;
    }

    private Number getMax(ArrayList<Number> data) {
        Number max = data.get(0);
        for (Number num : data) {
            if (num.doubleValue() > max.doubleValue()) {
                max = num;
            }
        }
        return max;
    }

    private void bucketPass(ArrayList<Number> data, long exp) {
        int n = data.size();
        ArrayList<Number> output = new ArrayList<>(Collections.nCopies(n, data.get(0)));

        int[] count = new int[10];

        for (Number num : data) {
            int digit = (int) ((getLongValue(num) / exp) % 10);
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            Number num = data.get(i);
            int digit = (int) ((getLongValue(num) / exp) % 10);
            output.set(count[digit] - 1, num);
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            data.set(i, output.get(i));
        }
    }

    private long getLongValue(Number num) {
        return num.longValue();
    }

    // para el profiler
    public static void main(String[] args) {
        IOApp app = new IOApp();
        Radixsort sort = new Radixsort();
        // Desordenado
        //sort.sort(app.randomNumbers(3000));
        // ordenado
        sort.sort(sort.sort(app.randomNumbers(3000)));
    }
}