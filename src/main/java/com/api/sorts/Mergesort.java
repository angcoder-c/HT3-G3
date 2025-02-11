package com.api.sorts;

import com.api.IOApp;

import java.util.ArrayList;

public class Mergesort {

    public ArrayList<Number> sort(ArrayList<Number> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }
        mergesort(list, 0, list.size() - 1);
        return list;
    }

    private void mergesort(ArrayList<Number> list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergesort(list, left, middle); // mitad izquierda
            mergesort(list, middle + 1, right); // mitad derecha
            merge(list, left, middle, right); // fusionar
        }
    }

    private void merge(ArrayList<Number> list, int left, int middle, int right) {
        ArrayList<Number> leftTemp = new ArrayList<>(list.subList(left, middle + 1));
        ArrayList<Number> rightTemp = new ArrayList<>(list.subList(middle + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < leftTemp.size() && j < rightTemp.size()) {
            if (leftTemp.get(i).doubleValue() <= rightTemp.get(j).doubleValue()) {
                list.set(k++, leftTemp.get(i++));
            } else {
                list.set(k++, rightTemp.get(j++));
            }
        }

        // Copiar los elementos restantes si los hay
        while (i < leftTemp.size()) {
            list.set(k++, leftTemp.get(i++));
        }
        while (j < rightTemp.size()) {
            list.set(k++, rightTemp.get(j++));
        }
    }

    // para el profiler
    public static void main(String[] args) {
        IOApp app = new IOApp();
        Mergesort sort = new Mergesort();
        // Desordenado
        // sort.sort(app.randomNumbers(3000));
        // ordenado
        sort.sort(sort.sort(app.randomNumbers(3000)));
    }
}