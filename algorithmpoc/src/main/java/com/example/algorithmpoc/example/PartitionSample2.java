package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;

/**
 * Created by Cyho on 10/01/2017.
 */
public class PartitionSample2 implements SampleAction {
    int sum = 5;
    int largestNumber = 5;
    String [][] table = new String [sum + 1][largestNumber + 1];

    @Override
    public void action() {

        int i;

        for (String [] row : table) {
            Arrays.fill(row, null);
        }

        partition(sum, largestNumber, "");
//        Log.e(getClass().getName(), partition(sum, largestNumber, ""));

        for (String [] row : table) {
            StringBuilder sb = new StringBuilder();
            for (String  value : row) {
                sb = new StringBuilder();
                sb.append(value);
//                sb.append(" ");
                Log.e(getClass().getName(), sb.toString());
            }
            //Log.e(getClass().getName(), sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(table[1][4]);
        Log.e(getClass().getName(), sb.toString());
    }

    public String partition(int sum, int largestNumber, String suffix) {
        if (largestNumber == 0) {
//            Log.e( "LargestNumber", suffix);
            return "";
        }
        if (sum == 0) {
            Log.e("sum", suffix);
            table[sum][largestNumber] = largestNumber + "\n";
            return table[sum][largestNumber];
        }
        if (sum < 0) {
            return "";
        }
//        if(table[sum][largestNumber] != null && !table[sum][largestNumber].isEmpty()) {
//            return table[sum][largestNumber];
//        }
        table[sum][largestNumber] = partition(sum, largestNumber - 1, suffix)
                + partition(sum - largestNumber, largestNumber, largestNumber + " " + suffix);
        return table[sum][largestNumber];
    }

//    public int partition(int sum, int largestNumber, String suffix) {
//        if (largestNumber == 0) {
////            Log.e( "LargestNumber", suffix);
//            return 0;
//        }
//        if (sum == 0) {
//            Log.e("sum", suffix);
//            return 1;
//        }
//        if (sum < 0) {
//            return 0;
//        }
//        if(table[sum - 1][largestNumber - 1] != 0) {
//            return table[sum - 1][largestNumber - 1];
//        }
//        table[sum - 1][largestNumber - 1] = partition(sum, largestNumber - 1, suffix)
//                + partition(sum - largestNumber, largestNumber, largestNumber + " " + suffix);
//        return table[sum - 1][largestNumber - 1];
//    }
}
