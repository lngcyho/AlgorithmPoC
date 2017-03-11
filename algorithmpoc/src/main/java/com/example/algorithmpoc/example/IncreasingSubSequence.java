package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Cyho on 28/01/2017.
 */

public class IncreasingSubSequence implements SampleAction {
    @Override
    public void action() {
//        int[] nums = {4, 6, 7, 7};
//        int[] nums = {1,5,1}; // should return  {1,5}, {1,1}
//        int[] nums = {1,2,3,2}; // should return [[1,2],[2,2],[1,3],[2,3],[1,2,3],[1,2,2]]
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<List<Integer>> listOfOuputs = findSubsequences(nums);


        for (List<Integer> output :  listOfOuputs) {
            Log.e(getClass().getName(), Arrays.toString(output.toArray()));
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> listOfNumbers = getList(nums);

        HashSet<List<Integer>> listOfOutput = new HashSet<List<Integer>>();
        findSubsequences(new ArrayList<Integer>(), listOfNumbers, listOfOutput);

        return new ArrayList<>(listOfOutput);
    }

    private void findSubsequences(List<Integer> accountedFor, List<Integer> rest, HashSet<List<Integer>> listOfOutput) {
        if (rest.size() == 0 && accountedFor.size() > 1) {
            listOfOutput.add(accountedFor); //handles duplicates because this is a hashSet, lookup also O(1)
        }
        if (rest.size() == 0) {
            return;
        }

        Integer selectedInteger = rest.get(0);
        List<Integer> remainingIntegers = getRemainingInt(rest);

        if (accountedFor.size() == 0 || accountedFor.get(accountedFor.size() - 1) <= selectedInteger) {
            //inclusion
            List<Integer> inclusionList = new ArrayList<>(accountedFor);
            inclusionList.add(selectedInteger);
            findSubsequences(inclusionList, remainingIntegers, listOfOutput);
        }

        //exclusion
        findSubsequences(accountedFor, remainingIntegers, listOfOutput);
    }

    private List<Integer> getList(int[] nums) {
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int number : nums) {
            listOfNumbers.add(number);
        }
        return listOfNumbers;
    }

    private List<Integer> getRemainingInt(List<Integer> rest) {
        return new ArrayList<Integer>(rest.subList(1, rest.size()));
    }

}
