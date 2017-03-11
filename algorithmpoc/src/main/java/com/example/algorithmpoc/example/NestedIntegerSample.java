package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyho on 12/01/2017.
 */
public class NestedIntegerSample implements SampleAction{
    @Override
    public void action() {

        List<NestedInteger> list = new ArrayList<NestedInteger>();

        NestedInteger integer5 = new NestedInteger();
        integer5.value = 5;

        NestedInteger integer2 = new NestedInteger();
        integer2.value = 2;

        NestedInteger integer3 = new NestedInteger();
        integer3.value = 3;

        NestedInteger nestedInteger = new NestedInteger();
        List<NestedInteger> nestedIntegers =  new ArrayList<>();
        nestedIntegers.add(integer2);
        nestedIntegers.add(integer3);
        nestedInteger.nestedIntegers =  nestedIntegers;

        list.add(integer5);
        list.add(nestedInteger);
        Integer sum = sumOfNested(list);
        Log.e(getClass().getName(), sum.toString());
    }

    private int sumOfNested(List<NestedInteger> list) {

        return sumOfNested(list, 1);
    }

    private int sumOfNested(List<NestedInteger> list, int level) {
        if (list == null) {
            return 0;
        }

        int sum = 0;
//        level ++;
        for (NestedInteger value : list) {
            if (value.isInteger()) {
                sum += value.value * level;
            }
            sum += sumOfNested (value.nestedIntegers, level);
        }
        return sum;
    }

    private class NestedInteger {
        int value;
        List<NestedInteger> nestedIntegers;

        public boolean isInteger() {
            return (nestedIntegers == null);
        }
    }
}
