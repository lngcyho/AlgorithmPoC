package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 18/01/2017.
 */
public class KnapsackProblem implements SampleAction{

    Integer totalValueOfKnapSack = 0;
    @Override
    public void action() {
       /*   Given a knapsack weight W and a set of n items with certain value vali and weight wti,
            we need to calculate minimum amount that could make up this quantity exactly. This is
            different from classical Knapsack problem,here we are allowed to use unlimited number of instances of an item.
        */

        /* Sample Input :   W = 100
                            val[]  = {1, 30}
                            wt[] = {1, 50}
            Sample Output: 100
        */

        /*  Essentially this problem is about
            1) finding all combination of W given a list and can repeat.
            2) Taken into acount of V and find the value with the max V
         */

//        Integer totalWeight = 100;
//        List<Integer> listOfValueOfItems = Arrays.asList(1,30);
//        List<Integer> listOfWeightOfItems = Arrays.asList(1,30);

        Integer totalWeight = 8;
        List<Integer> listOfValueOfItems = Arrays.asList(10,40,50,70);
        List<Integer> listOfWeightOfItems = Arrays.asList(1,3,4,5);
        determineMaxValue(totalWeight, listOfWeightOfItems, listOfValueOfItems);

        Log.e(getClass().getName(), totalValueOfKnapSack.toString());
    }

    private void determineMaxValue(Integer totalWeight, List<Integer> listOfWeightOfItems, List<Integer> listOfValueOfItems) {
        determineMaxValue(totalWeight, listOfWeightOfItems, listOfValueOfItems, 0);
    }

    private void determineMaxValue(int totalWeight, List<Integer> listOfWeightOfItems, List<Integer> listOfValueOfItems, int totalValue) {
        if (totalWeight < 0) {
            //Should ignore result
            return ;
        }
        if (totalWeight == 0) {
            totalValueOfKnapSack = Math.max(totalValueOfKnapSack, totalValue);
        }
        for (int index = 0; index < listOfWeightOfItems.size(); index++) {
            int weight = listOfWeightOfItems.get(index);
            int value = listOfValueOfItems.get(index);
            determineMaxValue(totalWeight - weight, new ArrayList<Integer>(listOfWeightOfItems.subList(index, listOfWeightOfItems.size())), new ArrayList<Integer>(listOfValueOfItems.subList(index, listOfValueOfItems.size())), totalValue + value);
        }
    }
}
