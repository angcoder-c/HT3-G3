package com.api.sorts;
import java.util.ArrayList;

public class Quicksort {
    public static ArrayList<Number> sort(ArrayList<Number> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }
        quicksort(list, 0, list.size() - 1);
        return list;
    }

    private static void quicksort(ArrayList<Number> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quicksort(list, low, pivotIndex - 1);
            quicksort(list, pivotIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Number> list, int low, int high) {
        double pivot = list.get(high).doubleValue();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).doubleValue() <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static void swap(ArrayList<Number> list, int i, int j) {
        Number temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
