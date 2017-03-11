package com.example.algorithmpoc.example;

import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

/**
 * Created by Cyho on 05/02/2017.
 */

public class FindSubsetArrayThatLeadsToMaxSum implements SampleAction {
    @Override
    public void action() {
        // given 1, -3, 2, 1, -1
        // subset of sum is (2, 1)

        //idea is you want to know when it starts being positive
        //do you keep adding? or do you ditch it and start from beginning
        //-3 or 1 -3? --> -2
        //2 or -2 + 2? --> 2
        //1 or 2 + 1 --> 3
        //get max of this

        //default subsetSum as first index (1)
    }
}
