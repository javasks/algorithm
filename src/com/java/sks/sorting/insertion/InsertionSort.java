package com.java.sks.sorting.insertion;

import java.util.Arrays;

/**
 * @author sandeepsingh
 */

public class InsertionSort {
    public static void insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length;
        for (int i = 1; i < n; i++) {   //outer for loop to traverse
            int key = array[i];
            int j = i - 1;   //initialise j to previous index of i, so that we can traverse till i=0
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {145, 40, 54, 18, 19, 38, 47};
        insertionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
