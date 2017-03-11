package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 05/02/2017.
 */

public class BestTimeToBuyAndSellStocks implements SampleAction {
    @Override
    public void action() {
        List<Integer> listOfStockData = Arrays.asList(100,180,260,40,535,695);
        Integer value = findHighestDiffToBuyAndSellStocks(listOfStockData);
        Log.e(getClass().getName(), value.toString());
    }

    private int findHighestDiffToBuyAndSellStocks(List<Integer> listOfStockData) {
        if (listOfStockData ==  null || listOfStockData.size() == 0) {
            return 0;
        }
        int globalMin = listOfStockData.get(0);

        int result =0;
        for (int index= 1; index < listOfStockData.size(); index++) {
            Integer stockValue = listOfStockData.get(index);
            result = Math.max(result, stockValue - globalMin);

            if (stockValue < globalMin) {
                globalMin = stockValue;
            }
        }

        return result;
    }
}
