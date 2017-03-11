package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 04/02/2017.
 */

public class BinarySearch implements SampleAction {
    @Override
    public void action() {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10, 100);
        int number = 50;

        Boolean found = binarySearch(listOfNumbers, number);
        Log.e(getClass().getName(), "FOUND? " + found.toString());
        Log.e(getClass().getName(), "FOUND? " + binarySearch(listOfNumbers, 10));

        Log.e(getClass().getName(), "ReturnNextValueInList");
        Log.e(getClass().getName(), returnNextValueInList(listOfNumbers, number).toString());
        Log.e(getClass().getName(), returnNextValueInList(listOfNumbers, 1).toString());
        Log.e(getClass().getName(), returnNextValueInList(listOfNumbers, 9).toString());
        Log.e(getClass().getName(), returnNextValueInList(listOfNumbers, 10).toString());
        Log.e(getClass().getName(), returnNextValueInList(listOfNumbers, 11).toString());
        Log.e(getClass().getName(), returnNextValueInList(listOfNumbers, 100).toString());

        Log.e(getClass().getName(), "ReturnLastValueInList");
        Log.e(getClass().getName(), returnLastValueInList(listOfNumbers, number).toString());
        Log.e(getClass().getName(), returnLastValueInList(listOfNumbers, 1).toString());
        Log.e(getClass().getName(), returnLastValueInList(listOfNumbers, 9).toString());
        Log.e(getClass().getName(), returnLastValueInList(listOfNumbers, 10).toString());
        Log.e(getClass().getName(), returnLastValueInList(listOfNumbers, 11).toString());
        Log.e(getClass().getName(), returnLastValueInList(listOfNumbers, 100).toString());
    }

    private Integer returnLastValueInList(List<Integer> listOfNumbers, int number) {
        if (listOfNumbers.get(0) == number) {
            return listOfNumbers.get(listOfNumbers.size() - 1);
        }
        return returnLastValueInList(listOfNumbers, number, 0, listOfNumbers.size() - 1);
    }

    private Integer returnLastValueInList(List<Integer> listOfNumbers, int number, int start, int end) {
        if (start >= end) {
            return listOfNumbers.get(start - 1);
        }

        int middle = (start + end) / 2;
        int midValue = listOfNumbers.get(middle);

        if (number == midValue) {
            return returnLastValueInList(listOfNumbers, number, middle, middle);
        }
        else if (number > midValue) {
            return returnLastValueInList(listOfNumbers, number, middle + 1, end);
        } else {
            return returnLastValueInList(listOfNumbers, number, start, middle - 1);
        }
    }

    private Integer returnNextValueInList(List<Integer> listOfNumbers, int number) {
        if (listOfNumbers.get(listOfNumbers.size() - 1) == number) {
            return listOfNumbers.get(0);
        }
        return returnNextValue(listOfNumbers, number, 0, listOfNumbers.size() - 1);
    }

    private Integer returnNextValue(List<Integer> listOfNumbers, int number, int start, int end) {
        if (start >= end) {
            return listOfNumbers.get(start);
        }

        int middle = (end + start) / 2;
        int middleNumber = listOfNumbers.get(middle);
        if (number == middleNumber) {
            return returnNextValue(listOfNumbers, number, middle + 1, middle + 1);
        } else if (number > middleNumber) {
            return returnNextValue(listOfNumbers, number, middle + 1, end);
        } else {
            return returnNextValue(listOfNumbers, number, start, middle);
        }
    }

    private boolean binarySearch(List<Integer> listOfNumbers, int number) {
        if (listOfNumbers.size() == 0) {
            return false;
        }

        int middle = listOfNumbers.size() / 2;
        int middleNumber = listOfNumbers.get(middle);

        boolean found = false;
        if (number == middleNumber) {
            return true;
        } else if (number > middleNumber) {
            List<Integer> biggerList = listOfNumbers.subList(middle + 1, listOfNumbers.size());
            found = binarySearch(biggerList, number);
        } else {
            List<Integer> smallerList = listOfNumbers.subList(0, middle);
            found = binarySearch(smallerList, number);
        }
        return found;
    }
}
