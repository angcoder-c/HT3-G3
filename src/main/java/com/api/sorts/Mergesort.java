
package com.api.sorts;

import java.util.ArrayList;
import java.util.Comparator;

public class Mergesort {

    public static <T extends Number & Comparable<T>> ArrayList<T> sort(ArrayList<T> list)  {
        // identify if the list is null or has only one element
        if (list == null || list.size() <= 1) {
            return list;
        }
        // call the mergesort method
        mergesort(list);
        return list;
    }
    private static <T extends Number & Comparable<T>> void mergesort(ArrayList<T> initialArray) {
        // declare the length of the array
        int arrayLength = initialArray.size();
        // identify if the array has less than 2 elements if true don't do anything
        if (arrayLength < 2) {
            return;
        }
        // if false divide the array into two halves
        else {
            // declare the middle index of the array
            int middleIndexArray = arrayLength / 2;
            // create two arraylists to store the left and right halves of the array
            ArrayList<T> leftHalfArray = new ArrayList<>(initialArray.subList(0, middleIndexArray));
            ArrayList<T> rightHalfArray = new ArrayList<>(initialArray.subList(middleIndexArray, arrayLength));

            // call the mergesort method recursively
            mergesort(leftHalfArray);
            mergesort(rightHalfArray);

            // when the array is divided into the smallest possible parts (1) call the merging method
            merging(initialArray, leftHalfArray, rightHalfArray);
        }

    }

    private static <T extends Number & Comparable<T>> void merging(ArrayList<T> initialArray, ArrayList<T> leftHalfArray, ArrayList<T> rightHalfArray) {
        // declare the lengths of the left and right halves
        int lHALength = leftHalfArray.size(), rHALength = rightHalfArray.size();
        // declare the indexes for the left, right and general arrays
        int leftIndex = 0, rightIndex = 0, generalIndex = 0;

        // while the left and right indexes are less than the lengths of the left and right halves
        while (leftIndex < lHALength && rightIndex < rHALength) {
            // compare the elements of the left and right halves
            if (leftHalfArray.get(leftIndex).compareTo(rightHalfArray.get(rightIndex)) <= 0) {
                // if the element of the left half is less than the element of the right half set the element of the left half to the general array
                initialArray.set(generalIndex, leftHalfArray.get(leftIndex));
                // move the left index to the next element
                leftIndex++;
            } else {
                // if the element of the right half is less than the element of the left half set the element of the right half to the general array
                initialArray.set(generalIndex, rightHalfArray.get(rightIndex));
                // move the right index to the next element
                rightIndex++;
            }
            // move the general index to the next element
            generalIndex++;
        }

        // while the left index is less than the length of the left half set the element of the left half to the general array
        while (leftIndex < lHALength) {
            // set the element of the left half to the general array
            initialArray.set(generalIndex, leftHalfArray.get(leftIndex));
            leftIndex++;
            generalIndex++;
        }

        // while the right index is less than the length of the right half set the element of the right half to the general array
        while (rightIndex < rHALength) {
            // set the element of the right half to the general array
            initialArray.set(generalIndex, rightHalfArray.get(rightIndex));
            rightIndex++;
            generalIndex++;
        }

    }
}
