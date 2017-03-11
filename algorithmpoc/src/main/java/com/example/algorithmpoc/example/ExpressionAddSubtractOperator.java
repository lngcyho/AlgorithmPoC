package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 28/01/2017.
 */

//TODO
public class ExpressionAddSubtractOperator implements SampleAction {
    @Override
    public void action() {
        //Take in a list of Number and a target
        //Ex: L = {1,2,3,4,5}   T = 3
        //Ex: Output 5 (5 way of expressing this)
        //1 + 1 + 1 + 1 - 1 = 3

        List<Integer> listOfNumbers = Arrays.asList(1, 1, 1, 1, 1);
//        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer target = 3;
//        List<Integer> listOfNumbers = Arrays.asList(1000);
//        Integer target = 1000;
        Integer count = expressionAddSubtractOperator(listOfNumbers, target);
        Log.e(getClass().getName(), "Count: " + count.toString());
    }

    private Integer expressionAddSubtractOperator(List<Integer> listOfNumbers, int target) {
        return expressionAddSubtractOperator(listOfNumbers, 0, 0, target);
    }

    private Integer expressionAddSubtractOperator(List<Integer> listOfNumbers, int index, int currentSum, int target) {
        if (index == listOfNumbers.size()) {
            //Reach the end
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        //Take current number
        Integer number = listOfNumbers.get(index);

        if (index == 0) {
            count +=expressionAddSubtractOperator(listOfNumbers, index + 1, currentSum + number, target);   // first number has to be positive
        } else {
            //flip as positive, pass it in Addition
            count += expressionAddSubtractOperator(listOfNumbers, index + 1, currentSum + number, target);

            //flip as negative it in Subtraction
            count += expressionAddSubtractOperator(listOfNumbers, index + 1, currentSum - number, target);
        }

        return count;
    }
}
