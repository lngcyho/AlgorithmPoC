package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

/**
 * Created by Cyho on 02/02/2017.
 */

public class NumberOfPath implements SampleAction {
    @Override
    public void action() {
        int X = 2;
        int Y = 2;
        Integer numberOfPath = findPath(X, Y);
        Log.e(getClass().getName(), numberOfPath.toString());

    }

    private int findPath(int x, int y) {
        if (x == 0 || y == 0) {
            //found
            return 1;
        }
        int leftCount = findPath(x - 1, y);  //move left
        int upCount = findPath(x, y - 1); // move up
        return leftCount + upCount;
    }
}
