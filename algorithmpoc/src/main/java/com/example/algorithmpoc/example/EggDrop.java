package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.sql.Array;

/**
 * Created by Cyho on 02/02/2017.
 */

public class EggDrop implements SampleAction {
    @Override
    public void action() {
        int floor = 100;
        int eggs = 2;
        int[][] dp = new int[eggs + 1][floor + 1];
        Integer minDropRequired = findMinDropsRequired(eggs, floor, dp);
        Log.e(getClass().getName(), minDropRequired.toString());
    }

    private int findMinDropsRequired(int eggs, int maxFloor, int[][] dp) {
        //2 scenarios
        //break - 1 --> 49
        //no break --> 51 --> 100
        if (eggs == 1) {
            dp[eggs][maxFloor] = maxFloor;
            return maxFloor;
        }
        if (maxFloor == 0 || maxFloor == 1) {
            dp[eggs][maxFloor] = 1;
            return 1;
        }
        if (dp[eggs][maxFloor] != 0) {
            return dp[eggs][maxFloor];
        }
        //Take the min of the loop
        int maxMin = maxFloor;
        dp[eggs][maxFloor] = maxFloor;
        int localMin;
        for (int floor = 1; floor <= maxFloor; floor++) {
            //worst case of 2 so take the max of the 2
            int numberOfDropsRequiredOnEggBroke = findMinDropsRequired(eggs - 1, floor - 1, dp);
            int numberOfDropsRequiredOnEggSurvive = findMinDropsRequired(eggs, maxFloor - floor, dp);
            localMin = Math.max(numberOfDropsRequiredOnEggBroke, numberOfDropsRequiredOnEggSurvive);
            if (localMin < maxMin) {
                maxMin = localMin;
            }
        }

        dp[eggs][maxFloor] = maxMin + 1;
        return maxMin + 1;  //+1 because current iteration count as 1 drop
    }
}
