package com.api.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Radixssort<T extends Number & Comparable<T>> {

    public void sort(List<T> data) {
        if (data == null || data.isEmpty()) return;

        T max = getMax(data);

        for (long exp = 1; getLongValue(max) / exp > 0; exp *= 10) {
            bucketPass(data, exp);
        }
    }

    private T getMax(List<T> data) {
        T max = data.get(0);
        for (T num : data) {
            if (num.compareTo(max) > 0) {
                max = num;
            }
        }
        return max;
    }

    private void bucketPass(List<T> data, long exp) {
        int n = data.size();
        List<T> output = new ArrayList<>(Collections.nCopies(n, data.get(0))); 

        int[] count = new int[10]; 

        for (T num : data) {
            int digit = (int) ((getLongValue(num) / exp) % 10);
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            T num = data.get(i);
            int digit = (int) ((getLongValue(num) / exp) % 10);
            output.set(count[digit] - 1, num);
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            data.set(i, output.get(i));
        }
    }

    private long getLongValue(T num) {
        return num.longValue(); 
    }

}


