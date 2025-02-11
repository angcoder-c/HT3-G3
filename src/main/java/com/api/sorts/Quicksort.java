package com.api.sorts;
import com.api.IOApp;

import java.util.ArrayList;

public class Quicksort {
    /**
     * Método público para ordenar una lista
     *
     * @param list La lista de números a ordenar.
     * @return La lista ordenada.
     */
    public static ArrayList<Number> sort(ArrayList<Number> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }
        quicksort(list, 0, list.size() - 1);
        return list;
    }

    /**
     * Método recursivo que aplica el algoritmo QuickSort sobre la lista
     * @param list La lista de números a ordenar.
     * @param low El índice de inicio de la sublista a ordenar.
     * @param high El índice final de la sublista a ordenar.
     */
    private static void quicksort(ArrayList<Number> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quicksort(list, low, pivotIndex - 1);
            quicksort(list, pivotIndex + 1, high);
        }
    }

    /**
     * particiona la lista en dos sublistas en torno a un pivote
     * @param list La lista de números a ordenar.
     * @param low El índice de inicio de la sublista.
     * @param high El índice final de la sublista.
     * @return El índice del pivote después de la partición.
     */
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

    /**
     * Intercambia dos elementos en la lista
     * @param list La lista de números donde se realizarán los intercambios.
     * @param i El índice del primer elemento a intercambiar.
     * @param j El índice del segundo elemento a intercambiar.
     */
    private static void swap(ArrayList<Number> list, int i, int j) {
        Number temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    // para el profiler
    public static void main(String[] args) {
        IOApp app = new IOApp();
        // Desordenado
        // sort(app.randomNumbers(3000));
        // ordenado
        sort(sort(app.randomNumbers(3000)));
    }
}