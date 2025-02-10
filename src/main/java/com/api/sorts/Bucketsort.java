package com.api.sorts;

import java.util.ArrayList;
import java.util.Collections;

public class Bucketsort {

    public ArrayList<Number> sort(ArrayList<Number> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        Number minValue = Collections.min(list, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
        Number maxValue = Collections.max(list, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));

        int bucketCount = list.size();
        ArrayList<ArrayList<Number>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Number item : list) {
            int bucketIndex = (int) ((item.doubleValue() - minValue.doubleValue()) /
                    (maxValue.doubleValue() - minValue.doubleValue()) * (bucketCount - 1));
            buckets.get(bucketIndex).add(item);
        }

        list.clear();
        for (ArrayList<Number> bucket : buckets) {
            bucket.sort((a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
            list.addAll(bucket);
        }

        return list;
    }
}