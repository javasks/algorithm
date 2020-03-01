package com.java.sks.array;

import java.util.Arrays;

/**
 * @author sandeepsingh
 */

public class SmallestDifference {

    /**
     *
     * @param array1
     * @param array2
     * @return
     * Given Two array, find smallest difference
     */
    static int[] smallestDifference(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int indx1 = 0;
        int indx2 = 0;
        int smallest = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];
        while (indx1 < array1.length && indx2 < array2.length) {
            int firstNumber = array1[indx1];
            int secondNumber = array2[indx2];
            if (firstNumber < secondNumber) {
                current = secondNumber - firstNumber;
                indx1++;

            } else if (secondNumber < firstNumber) {
                current = firstNumber - secondNumber;
                indx2++;

            } else {
                return new int[]{firstNumber, secondNumber};
            }
            if (smallest > current) {
                smallest = current;
                smallestPair = new int[]{firstNumber, secondNumber};
            }


        }
        return smallestPair;
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 45, 6, 10, 8};
        int a2[]={10, 40, 45, 60, 100, 80};
        int [] result=smallestDifference(a,a2);
        Arrays.stream(result).forEach(temp-> System.out.println(temp));
    }
}
