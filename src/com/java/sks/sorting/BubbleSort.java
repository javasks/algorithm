package com.java.sks.sorting;

import java.util.Arrays;

/**
 * @author sandeepsingh
 */
public class BubbleSort {
    /**
     *
     * @param array
     * Bubble sort, biggest element will be at last in each iteration.
     */

    public static void bubbleSort(int[] array) {
        if( array.length < 2 || array == null) {
            return;
        }
        int n = array.length;
        boolean flag = true;
        while(flag) {
            flag = false;
            for(int j = 1; j < n; j++) {
                if(array[j-1] > array[j]) {
                    swapFunction(array, j-1, j);
                    flag = true;
                }
            }
            n--;
        }
    }

    private static void swapFunction(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {145, 40, 54, 18, 19, 38, 47};
        bubbleSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
