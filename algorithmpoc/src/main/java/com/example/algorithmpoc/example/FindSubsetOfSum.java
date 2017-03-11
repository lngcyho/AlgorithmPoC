package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 07/01/2017.
 */
public class FindSubsetOfSum extends Sample implements SampleAction {
    private Integer selectedValue;
    private List<Integer> remainingValue;

    @Override
    public void action() {
        // Outputs:
        // sum([3, 8, 4])=15
        // sum([3, 5, 7])=15
        // sum([8, 7])=15
        // sum([5, 10])=15

        //Given list of available values and a target, find all combinations
        List<Integer> listOfNumbers = Arrays.asList(3, 9, 8, 4, 5, 7, 10);
        Integer target = new Integer(15);

        findSubsetOfSums(listOfNumbers, target);
    }

    private void findSubsetOfSums(List<Integer> listOfNumbers, Integer target) {
        findSubsetOfSums(new ArrayList<Integer>(), listOfNumbers, target);
    }

    private void findSubsetOfSums(List<Integer> prefix, List<Integer> rest, Integer target) {
        // use permutation for list and sum them to check if equals to target
        // if sum > target, exit
        int sum = sumOfList(prefix);
        if (sum == target) {
            Log.e(getClass().toString(), Arrays.toString(prefix.toArray()));
        }
        if (sum > target) {
            // no point to keep checking because value is too big
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            Integer selected = getSelectedValue(rest, i);
            List<Integer> remaining = getRemainingValue(rest, i);

            //inject prefix
            List<Integer> prefixWithInjectedSelect = new ArrayList<>(prefix);
            prefixWithInjectedSelect.add(selected);

            //if i set remaining to rest, this turns into an integer partition problem
            findSubsetOfSums(prefixWithInjectedSelect, remaining, target);
        }
    }

    private int sumOfList(List<Integer> list) {
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        return sum;
    }

    public Integer getSelectedValue(List<Integer> list, int index) {
        return list.get(index);
    }

    public List<Integer> getRemainingValue(List<Integer> list, int index) {
        // removing one of these lines remove double counting
        // Ex: if we have value 3 as prefix , 4 5 6 7 8 9 10 as rest
        // once we look at 7, we  either ignore 4,5,6 or we ignore 7,8,9,10

        List<Integer> remainingList = new ArrayList<>();
//        remainingList.addAll(list.subList(0, index));
        remainingList.addAll(list.subList(index + 1, list.size()));
        return remainingList;
    }
}