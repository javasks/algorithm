package com.java.sks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandeepsingh
 */
public class ThreeNumberSum {


    static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> integersList = new ArrayList<>();


        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    Integer[] temArray = {array[i], array[left], array[right]};
                    integersList.add(temArray);
                    left++;
                    right--;

                } else if (currentSum < targetSum) {
                    left++;
                } else if (currentSum > targetSum) {
                    right--;
                }

            }
        }

        return integersList;

    }

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;

        List<Integer[]> finalList = threeNumberSum(A, sum);
        Arrays.stream(finalList.iterator().next()).forEach(it -> System.out.println(it));
    }
}
