package com.java.sks.dp.eggDrop;


/**
 * @Author : Sandeep Singh
 */


/**
 * Problem Statement
 *
 * Suppose you have x eggs and you want to determine from which floors in a building you can drop an
 * egg such that is doesn't break. You are to determine the minimum number of attempts
 * you need in order to find the critical floor in the worst case while using the best strategy.
 *
 * If the egg doesn't break at a certain floor, it will not break at any floor below.
 * If the eggs break at a certain floor, it will break at any floor above.
 * The egg may break at the first floor.
 * The egg may not break at the last floor.
 */

class TopDownEggDrop {

    /**
     * @param totalEggs
     * @param totalFloors
     * @return
     */

    public static int eggDrop(int totalEggs, int totalFloors) {
        int[][] eggsAndFloorsMemory = new int[totalEggs + 1][totalFloors + 1];
        initializeMemory(totalEggs, totalFloors, eggsAndFloorsMemory);

        return eggDrop(totalEggs, totalFloors, eggsAndFloorsMemory);
    }

    /**
     * @param totalEggs
     * @param totalFloors
     * @param eggsAndFloorsMemory
     * @return
     */
    private static int eggDrop(int totalEggs, int totalFloors, int[][] eggsAndFloorsMemory) {
        /**
         *
         * Base Case 1:
         * If we have 0 floors we need 0 trials, no matter the egg amount given
         * If we have 1 floor we need 1 trial, no matter the egg amount given
         *
         */
        if (totalFloors == 1 || totalFloors == 0) {
            return totalFloors;
        }

        /**
         * If we have 1 egg. We will have to be try every floor
         * 1 by 1 starting from floor 1 all the way up to totalFloors
         * This entails 'totalFloors' drops as the BEST we can do to guarantee
         * we find the pivotal floor
         */
        if (totalEggs == 1) {
            return totalFloors;
        }

        /**
         * Do we already know the answer to this subproblem?
         */
        if (eggsAndFloorsMemory[totalEggs][totalFloors] != Integer.MAX_VALUE) {
            return eggsAndFloorsMemory[totalEggs][totalFloors];
        }


        /**
         *  Try all floors up to the floor we are working on. See the bottom explanation
         *  below for how the situations break down
         */
        for (int floor = 1; floor <= totalFloors; floor++) {

            int costOfWorstOutcome = Math.max(eggDrop(totalEggs - 1, floor - 1, eggsAndFloorsMemory),
                    eggDrop(totalEggs, totalFloors - floor, eggsAndFloorsMemory));

            int accountingForDroppingAtThisSubproblem = 1 + costOfWorstOutcome;
            eggsAndFloorsMemory[totalEggs][totalFloors] = Math.min(eggsAndFloorsMemory[totalEggs][totalFloors],
                    accountingForDroppingAtThisSubproblem);
        }

        return eggsAndFloorsMemory[totalEggs][totalFloors];
    }

    /**
     *
     * @param totalEggs
     * @param totalFloors
     * @param cache
     * Initialize all subproblems that need to be solved. This does not change asymptotic
     * complexity of the solution since the work stays within our upper bound.
     *  Not sure if we really need to do this...eh...whatever you get the point
     */


    private static void initializeMemory(int totalEggs, int totalFloors, int[][] cache) {
        for (int eggs = 2; eggs <= totalEggs; eggs++) {
            for (int floor = 2; floor <= totalFloors; floor++) {
                cache[eggs][floor] = Integer.MAX_VALUE;
            }
        }
    }


    public static void main(String[] args) {
        // TopDownEggDrop topDownEggDrop = new TopDownEggDrop();
        System.out.println(eggDrop(2, 100));
    }
}
