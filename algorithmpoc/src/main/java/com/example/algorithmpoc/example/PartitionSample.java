package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 10/01/2017.
 */
public class PartitionSample implements SampleAction {
    List<Integer> listOfValues = Arrays.asList(1, 2, 5);
    int[][] table = new int [50][50];
    @Override
    public void action() {
        int sum = 5;
        int largestNumber = 5;

        for (int [] row : table) {
            Arrays.fill(row, 0);
        }

//        partition(5, 5);

//        for (int [] row : table) {
//            StringBuilder sb = new StringBuilder();
//            for (int value : row) {
//                sb.append (value);
//                sb.append(" ");
//            }
//            Log.e(getClass().getName(), sb.toString());
//        }

        partitionWithList(sum, listOfValues);

    }

    private void partition(int sum, int largestNumber) {
        partition(sum, largestNumber, "");
    }

    private void  partition(int target, int maxValue, String suffix) {
        if (target < 0 || maxValue == 0) {
            return ;
        }
        if (target == 0) {
            Log.e(getClass().getName(), suffix);
        }

        for (int i = 0; i <= maxValue; i++) {
            //Store result in hashmap
            partition(target - i, i, i + " " + suffix);
        }
    }

    void partitionWithList(int target, List<Integer> listOfNumbers) {
        partitionWithList(target, listOfNumbers, "");
    }

    void partitionWithList(int target, List<Integer> listOfNumbers, String suffix) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            Log.e(getClass().getName(), suffix);
            return;
        }

        for (int i = 0; i < listOfNumbers.size(); i++) {
            Integer value = listOfNumbers.get(i);
            partitionWithList(target - value, new ArrayList<Integer>(listOfNumbers.subList(i, listOfNumbers.size())), value + " " + suffix);
        }
    }

//    void partition(int target, int maxValue, String suffix) {
//        if (target == 0)
//            Log.e(getClass().getName(), suffix);
//        else {
//            if (maxValue > 1)
//                partition(target, maxValue - 1, suffix);
//            if (maxValue <= target)
//                partition(target - maxValue, maxValue, maxValue + " " + suffix);
//        }
//    }
}
