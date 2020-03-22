package com.java.sks.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quicksort(int arr[]) {
        quicksort(arr, 0, arr.length - 1);
    }


    /**
     * @param arr
     * @param lowerBound
     * @param upperBound Top level function that calls 'partition' and splits the data based on where
     *                   'partition' leaves the choosen pivot value
     */
    private static void quicksort(int arr[], int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {

            /**
             * Partition the array from left to right and find where the selected pivot
             * belongs
             */
            int pivotFinalRestingPosition = partition(arr, lowerBound, upperBound);


            /**
             * Call quicksort to the left and to the right of the pivot
             */
            quicksort(arr, lowerBound, pivotFinalRestingPosition - 1);
            quicksort(arr, pivotFinalRestingPosition + 1, upperBound);
        }
    }


    /**
     * The partition function that chooses a pivot, partitions the array around the
     * pivot, places the pivot value where it belongs, and then returns the index of
     * where the pivot finally lies
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int arr[], int left, int right) {

        /**
         * In this implementation of quicksort we pick the last item in the partition
         * space as the pivot everytime. This can turn out very good or very badly
         */
        int pivot = arr[right];


        /**
         * i will keep track of the "tail" of the section of items less than the pivot
         * so that at the end we can "sandwich" the pivot between the section less than
         * it and the section greater than it
         */
        int i = left - 1;

        /**
         * j will scan for us.
         */
        for (int j = left; j < right; j++) {

            /**
             * If this item is less than the pivot it needs to be moved to the section of
             * items less than the pivot
             */
            if (arr[j] <= pivot) {

                /**
                 * Move i forward so that we can swap the value at j into the tail of the items
                 * less than the pivot
                 */
                i++;

                /**
                 *  Execute the swap. We "throw" the item at j back into the section of items
                 *  less than the pivot
                 */
                swap(arr, i, j);
            }
        }


        /**
         * Swap the pivot value right after the section of items less than the pivot. i
         * keeps the tail of this section
         */
        swap(arr, i + 1, right);

        return i + 1; // Return the pivot's final resting position
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] array = {145, 40, 54, 18, 19, 38, 47};
        quicksort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}