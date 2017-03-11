package com.example.algorithmpoc.example;

import com.example.algorithmpoc.sample.SampleAction;

/**
 * Created by Cyho on 05/02/2017.
 */

public class BestTimeToBuyAndSellStocksFindMaximumProfitMultipleBuySell implements SampleAction {
    @Override
    public void action() {
        //Given a series of numbers
        // 100,180,300,120,280 --> to get maximum profit, you buy at 100, 180, sell at 300, buy at 120, sell at 280
        // 100,180,260,120,280 --> to get maximum profit, you buy at 100, 180, 260, 120, sell at 280

        //hint start from the back (whenever max get bigger, sell all previous point with index of previous max
        //set max to new max
    }
}
