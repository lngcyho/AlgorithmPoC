package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Cyho on 08/01/2017.
 */
public class QuickSort extends Sample implements SampleAction {
    @Override
    public void action() {
        //Given a list of unsorted numbers
        List<Integer> list = Arrays.asList(5, 3, 4, 2, 6, 5, 7, 8, 1);

        quickSort(list);
        Log.e(getClass().toString(), Arrays.toString(list.toArray()));
    }

    private void quickSort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<Integer> list, int beginning, int end) {
        //get an index
        //apply index to partition, along with list
        //cut list into 2, left and right and repeat the process

        if (beginning < end) {
            int pivot = getPivot(beginning, end);
            int partitionIndex = partition(list, pivot, beginning, end);
            quickSort(list, beginning, partitionIndex - 1);

            quickSort(list, partitionIndex + 1, end);
        }
    }

    private int partition(List<Integer> list, int pivot, int beginning, int end) {
        //check if pivot is last item, if not, swap current pivot with last item
        if (pivot != end) {
            Collections.swap(list, pivot, end);
            pivot = end;
        }

        int pIndex = beginning;
        Integer pivotElement = list.get(end);
        for (int i = beginning; i < end; i++) {
            //Generate 2 index, one for loop, the other for tracking where to swap
            Integer value = list.get(i);
            if (value < pivotElement) {
                Collections.swap(list, i, pIndex);
                pIndex++;
            }
        }
        Collections.swap(list, pIndex, pivot);
        return pIndex;
    }

    private int getPivot(int beginning, int end) {
        return (end + beginning) / 2; //arguement stake, return last index
    }

}
