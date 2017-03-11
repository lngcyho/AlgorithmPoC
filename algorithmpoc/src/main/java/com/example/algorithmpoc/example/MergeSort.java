package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cyho on 08/01/2017.
 */
public class MergeSort extends Sample implements SampleAction {
    @Override
    public void action() {
        //Given a list of unsorted numbers
        List<Integer> list = Arrays.asList(5, 3, 4, 2, 6, 5, 7, 8, 1);

        List<Integer> sortedList = mergeSort (list);
        Log.e(getClass().toString(), Arrays.toString(sortedList.toArray()));
    }

    private List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int middle = list.size()/2;
        List<Integer>leftList = list.subList(0, middle);
        List<Integer>rightList = list.subList(middle, list.size());

        List<Integer> sortedLeftList = mergeSort(leftList);

        List<Integer> sortedRightList =  mergeSort(rightList);

        return merge (sortedLeftList, sortedRightList);
    }

    public List<Integer> merge (List<Integer> leftList, List<Integer> rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        int leftListIndex = 0;
        int rightListIndex =0;

        List<Integer> mergedList = new ArrayList<>();
        while(leftListIndex < leftList.size() || rightListIndex < rightList.size()) {
            if (leftListIndex >= leftList.size()) {
                Integer right = rightList.get(rightListIndex);
                mergedList.add(right);
                rightListIndex ++;
            } else if (rightListIndex >= rightList.size()) {
                Integer left = leftList.get(leftListIndex);
                mergedList.add(left);
                leftListIndex ++;
            } else {
                Integer left = leftList.get(leftListIndex);
                Integer right = rightList.get(rightListIndex);

                if (left <= right) {
                    mergedList.add(left);
                    leftListIndex ++;
                } else {
                    mergedList.add(right);
                    rightListIndex ++;
                }
            }
        }
        return mergedList;
    }
}
