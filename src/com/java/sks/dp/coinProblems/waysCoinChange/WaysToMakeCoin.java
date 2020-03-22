package com.java.sks.dp.coinProblems;

public class WaysToMakeCoin {

    public static int waysToMakeCoin(int target, int[] coins) {
        /**
         * Row=length of coin array+1,
         * Column=amount+1
         */
        int[][] ways = new int[coins.length + 1][target + 1];

        /**
         * Max ways to make change for 0 will be 1,
         * doing nothing.
         *
         */
        ways[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            /**
             * 0th column and ith row
             */

            ways[i][0] = 1;

            for (int j = 1; j <= target; j++) {

                int currentCoinValue = coins[i - 1];

                /*
                 * ways[i][j] will be the sum of the ways to make change not considering this coin
                 * (ways[i-1][j]) and the ways to make change considering this coin (ways[i][j] -
                 * currentCoinValue] ONLY if currentCoinValue <= j, otherwise this coin can not
                 * contribute to the total # of ways to make change at this sub problem target
                 * amount)
                 */
                /*
                table[row][col]=table[row-1][col]
                                   +
                                table[row][col-coins[row-1]]


                 */
                int withoutThisCoin = ways[i - 1][j];
                int withThisCoin = currentCoinValue <= j ? ways[i][j - currentCoinValue] : 0;

                ways[i][j] = withoutThisCoin + withThisCoin;
            }
        }


        return ways[coins.length][target];
    }

    public static void main(String[] args) {
        /**
         *
         */
        int arr[] = {1, 5, 10, 25};
        System.out.println(waysToMakeCoin(10, arr));
    }
}
