package com.java.sks.dp;

/**
 * @author sandeepsingh
 */
public class MaxSubSetSumWithNoAdjacent {
    /**
     *
     * @param array
     * @return
     * This method will have o(n) time complexity and O(n) space Complexity we can make it better in terms
     * of space complexity since we are using only i-1 and i-2 positions.
     */
    static int maxSubsetSumWithNoAdjacent(int[] array) {

        if (array.length == 0)
            return 0;
        else if (array.length == 1) {
            return array[0];
        }
        int[] maxSumsArray = array.clone();
        maxSumsArray[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            /**
             * This is the formula which we derived based on the pattern
             */
            maxSumsArray[i] = Math.max(maxSumsArray[i - 1], maxSumsArray[i - 2] + maxSumsArray[i]);
        }
        return maxSumsArray[array.length - 1];
    }

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, -8};
        int maxSum = maxSubsetSumWithNoAdjacent(A);
        System.out.println(maxSum);
    }
}
