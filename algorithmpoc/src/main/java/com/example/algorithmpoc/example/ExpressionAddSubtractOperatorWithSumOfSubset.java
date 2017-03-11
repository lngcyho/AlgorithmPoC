package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 28/01/2017.
 */

public class ExpressionAddSubtractOperatorWithSumOfSubset implements SampleAction {
    @Override
    public void action() {
        //Take in a list of Number and a target
        //Ex: L = {1,2,3,4,5}   T = 3
        //Ex: Output 5 (5 way of expressing this)
        //1 + 1 + 1 + 1 - 1 = 3
        // Sum (P) = 4
        // Sum (N) = 1
        //Sum(target) = 3
        //Output 0 if 0 ways

        //Prove
        //Sum(P) - Sum(N) = target
        //Sum(P) + Sum(P)  = target + Sum(N) + Sum(N)
        //Sum(P) = (target + Sum(L)) / 2

//        List<Integer> listOfNumbers = Arrays.asList(1, 1, 1, 1, 1);
//        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
//        Integer target = 3;
//        List<Integer> listOfNumbers = Arrays.asList(1, 0);
//        Integer target = 1;
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 1);
        Integer target = 0;
        int count = expressionAddSubtractOperator(listOfNumbers, target);
        Log.e(getClass().getName(), "Count: " + count);
    }

    private Integer expressionAddSubtractOperator(List<Integer> listOfNumbers, Integer target) {
        //Get target + Sum(L) / 2 && target + Sum(L) % 2
        Integer sumOfListAndTarget = target + sum(listOfNumbers);

        if (sumOfListAndTarget % 2 != 0) {
            //Case where it is not possible to construct target
            return 0;
        }
        return subSetOfSum(listOfNumbers, sumOfListAndTarget / 2);
    }

    private Integer subSetOfSum(List<Integer> listOfNumbers, int sum) {
        return subSetOfSum(new ArrayList<Integer>(), listOfNumbers, sum);

    }

    private Integer subSetOfSum(List<Integer> soFar, List<Integer> rest, int sum) {
        int count = 0;
        if (sum(soFar) == sum) {
            count++;
        }

        if (rest.size() == 0) {
            return count;
        }

        for (int index = 0; index < rest.size(); index++) {
            Integer selectInt = rest.get(index);
            List<Integer> remainingInts = getRemainingInts(rest, index);

            List<Integer> selectedInts = new ArrayList<>(soFar);
            selectedInts.add(selectInt);
            count += subSetOfSum(selectedInts, remainingInts, sum);
        }
        return count;
    }

    private List<Integer> getRemainingInts(List<Integer> rest, int index) {
        List<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.addAll(rest.subList(index + 1, rest.size()));
        return listOfNumbers;
    }

    private Integer sum(List<Integer> listOfNumbers) {
        Integer sum = 0;
        for (Integer value : listOfNumbers) {
            sum += value;
        }
        return sum;
    }
}
