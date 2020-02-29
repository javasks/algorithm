package com.java.sks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author - Sandeep Singh
 */

public class TwoNumberSum {

    public static int[] twoNumberSumON2(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }

            }
        }
        return new int[0];
    }

    public static int[] twoNumberSumONON(int[] array, int targetSum) {
        Map<Integer,Boolean> hashMap=new HashMap<>();
        for(int localNumber: array){
            int potentialSum=targetSum-localNumber;
            if(hashMap.containsKey(potentialSum)){
                return new int[] {potentialSum,localNumber};
            }
            hashMap.put(localNumber,true);
        }


        return new int[0];
    }

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, -8};
        int[] array = twoNumberSumONON(A, 16);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
