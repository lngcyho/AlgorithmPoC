package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyho on 18/01/2017.
 */
public class KnapsackProblem2 implements SampleAction {

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
            3) convert it to a DP problem
         */

        Integer totalWeight = 10;
        List<Integer> listOfValueOfItems = Arrays.asList(1,30);
        List<Integer> listOfWeightOfItems = Arrays.asList(1,30);



//        Integer totalWeight = 8;
//        List<Integer> listOfValueOfItems = Arrays.asList(10, 40, 50, 70);
//        List<Integer> listOfWeightOfItems = Arrays.asList(1, 3, 4, 5);


        totalValueOfKnapSack = determineMaxValue(totalWeight, listOfWeightOfItems, listOfValueOfItems);

        Log.e(getClass().getName(), totalValueOfKnapSack.toString());

    }

    private Integer determineMaxValue(Integer totalWeight, List<Integer> listOfWeightOfItems, List<Integer> listOfValueOfItems) {
        Map<String, Integer> cacheMap = new HashMap<String, Integer>();
        Integer result = determineMaxValue(totalWeight, listOfWeightOfItems, listOfValueOfItems, 0, cacheMap);
        for (String key : cacheMap.keySet()) {
            Log.e(getClass().getName(), "Key: " + key + ", Value: " + cacheMap.get(key));
        }
        return result;
    }

    private Integer determineMaxValue(int totalWeight, List<Integer> listOfWeightOfItems, List<Integer> listOfValueOfItems, int totalValueOfKnapSack, Map<String, Integer> dpMap) {
        //If you make the key totalweight + listOfWeightItems, looks like it'll be unique
        if (dpMap.get(generateDpKey(totalWeight, listOfWeightOfItems)) != null) {
            return dpMap.get(generateDpKey(totalWeight, listOfWeightOfItems));
        }
        if (totalWeight < 0) {
            //Should ignore result
            return 0;
        }
        if (totalWeight == 0) {
            return totalValueOfKnapSack;
        }

        int maxValue = 0;
        for (int index = 0; index < listOfWeightOfItems.size(); index++) {
            int weight = listOfWeightOfItems.get(index);
            int value = listOfValueOfItems.get(index);
            Integer totalValue = determineMaxValue(totalWeight - weight, new ArrayList<Integer>(listOfWeightOfItems.subList(index, listOfWeightOfItems.size())), new ArrayList<Integer>(listOfValueOfItems.subList(index, listOfValueOfItems.size())), totalValueOfKnapSack + value, dpMap);
            maxValue = Math.max(maxValue, totalValue);
        }

        dpMap.put (generateDpKey(totalWeight, listOfWeightOfItems), new Integer(maxValue));
//        Log.e(getClass().getName(), "totalWeight: " + totalWeight + ", maxValue: " + maxValue + ", listOfWeightOfItems: " + Arrays.toString(listOfWeightOfItems.toArray()) +  ", listOfValueOfItems: " +  Arrays.toString(listOfValueOfItems.toArray()));
        return maxValue;
    }

    private String generateDpKey(int totalWeight, List<Integer> listOfWeightOfItems) {
        StringBuilder sb = new StringBuilder();
        sb.append(totalWeight);
        sb.append('-');
        sb.append(Arrays.toString((listOfWeightOfItems.toArray())));
        return sb.toString();

    }
}

