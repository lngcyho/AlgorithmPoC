package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Cyho on 28/01/2017.
 */

//Note Overflow - use LONG instead of INT
//If subString start with 0, forget about adding it to list. otherwise make 105 to 1,5
/* Trick to do multiplier. Pass in as param in previous call either as
    +number, -number, number*multiplier as multiplier
    currenSum - multiplier + multiplier * number (subtract previous because we realize it's a mistake than do bedmax instead)

 */
public class ExpressionAddSubtractMultipleOperator implements SampleAction {
    HashSet<String> listOfOperation = new HashSet<>();

    @Override
    public void action() {
//        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3);
//        Integer target = 6;
//        List<Integer> listOfNumbers =Arrays.asList(2,3,2);
//        Integer target = 8;

//        String valueString = "105"; // return {1,0,5} {10,5}. {1,05}
//        List<List<Integer>> listOfListOfNumbers = convertValueStringToListOfListOfNumber(valueString);
//        for (List numbers : listOfListOfNumbers) {
//            Log.e(getClass().getName(), Arrays.toString(numbers.toArray()));
//        }
//        List<Integer> listOfNumbers = Arrays.asList(1,0,5);
        Integer target = -2147483648;

//        listOfListOfNumbers.add(Arrays.asList(1,0,5));
//        listOfListOfNumbers.add(Arrays.asList(10,5));

        String valueString = "2147483648"; // return {1,0,5} {10,5}. {1,05}
        List<List<Long>> listOfListOfNumbers = convertValueStringToListOfListOfNumber(valueString);
        for (List<Long> listOfNumbers : listOfListOfNumbers) {
            expressionAddSubtractMultipleOperator(listOfNumbers, target);
        }

        for (String operation : listOfOperation) {
            Log.e(getClass().getName(), operation);
        }
    }

    private List<List<Long>> convertValueStringToListOfListOfNumber(String value) {
        HashSet<List<Long>> listOfListOfNumbers = new HashSet<>();
        convertValueStringToListOfListOfNumber(value, 0, new ArrayList<Long>(), listOfListOfNumbers);
        return new ArrayList<>(listOfListOfNumbers);
    }

    private void convertValueStringToListOfListOfNumber(String stringValue, int position, List<Long> listOfNumber, HashSet<List<Long>> listOfListOfNumbers) {
        if (position == stringValue.length()) {
            listOfListOfNumbers.add(listOfNumber);
        }
        for (int index = position; index < stringValue.length(); index++) {
            List<Long> listOfValue = new ArrayList<>(listOfNumber);
            String subString = stringValue.substring(position, index + 1);
            if (subString.length() > 1 && subString.charAt(0) == '0') {
                continue;
            }
            Long value = Long.parseLong(subString);
            listOfValue.add(value);
            convertValueStringToListOfListOfNumber(stringValue, index + 1, listOfValue, listOfListOfNumbers);
        }
    }

    private void expressionAddSubtractMultipleOperator(List<Long> listOfNumbers, int target) {
        expressionAddSubtractMultipleOperator(listOfNumbers, 0, 0, 0, target, "");
    }

    private void expressionAddSubtractMultipleOperator(List<Long> listOfNumbers, Integer index, long currentSum, long multiplier, long target, String operation) {
        if (listOfNumbers.size() == index) {
            //You can't store currentSum now due to BEDMAX, much store a series of operators and value instead.
            if (currentSum == target) {
                listOfOperation.add(operation);

            }
            return;
        }
        Long number = listOfNumbers.get(index);

        if (index == 0) {
            expressionAddSubtractMultipleOperator(listOfNumbers, index + 1, currentSum + number, number, target, number.toString());
        } else {
            //Addition
            expressionAddSubtractMultipleOperator(listOfNumbers, index + 1, currentSum + number, number, target, operation + "+" + number);
            //Subtraction
            expressionAddSubtractMultipleOperator(listOfNumbers, index + 1, currentSum - number, -number, target, operation + "-" + number);

            //Multiplication
            //Only set this to 1 initially for multiplicatio purposes
            expressionAddSubtractMultipleOperator(listOfNumbers, index + 1, currentSum - multiplier + multiplier * number, multiplier * number, target, operation + "*" + number);
        }
    }
}
