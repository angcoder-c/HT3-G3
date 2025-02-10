package com.api.sorts;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    // Método principal para ejecutar Bucket Sort
    public static <T extends Number & Comparable<T>> ArrayList<T> sort(ArrayList<T> list) {
        // Verificar si la lista es nula o tiene solo un elemento
        if (list == null || list.size() <= 1) {
            return list;
        }

        // Determinar el valor mínimo y máximo de la lista para definir el rango de los cubos
        T minValue = Collections.min(list);
        T maxValue = Collections.max(list);

        // Crear los cubos
        int bucketCount = list.size();  // El número de cubos es igual al número de elementos
        ArrayList<ArrayList<T>> buckets = new ArrayList<>(bucketCount);

        // Inicializar los cubos
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribuir los elementos en los cubos
        for (T item : list) {
            // Normalizar el valor y asignarlo al cubo correspondiente
            int bucketIndex = (int) ((item.doubleValue() - minValue.doubleValue()) /
                    (maxValue.doubleValue() - minValue.doubleValue()) * (bucketCount - 1));
            buckets.get(bucketIndex).add(item);
        }

        // Ordenar los cubos individualmente
        for (ArrayList<T> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenar los cubos ordenados en la lista original
        list.clear();
        for (ArrayList<T> bucket : buckets) {
            list.addAll(bucket);
        }

        return list;
    }