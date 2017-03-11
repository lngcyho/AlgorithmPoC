package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cyho on 15/01/2017.
 */
public class JumpSample implements SampleAction {


    private int minCounter;

    @Override
    public void action() {
        int[] list = {101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,1,0};
        Integer total = jump(list);

        Log.e(getClass().getName(), total.toString());
    }

    private int jump(int A[]) {
        return jump(A, A.length);
    }

    //Solution 2 start from the back?
    public int jump(int[] nums, int length) {
        Map<Integer, Integer> hashMap = new HashMap<>(); // Hashmap of index, value
        int lastIndex = nums.length - 1;
        for (int index = lastIndex - 1; index >= 0; index--) {
            if ((nums[index] + index) >= lastIndex) {
                hashMap.put(index, 1);
            } else {
                //get Min counter from index to index + nums[index]
                if (nums[index] != 0) {
                    Integer counter = getMinCounter(hashMap, index + 1, nums[index] + index);
                    if (counter != null) {
                        counter++;
                    }
                    hashMap.put(index, counter);
                }
            }
        }
        return hashMap.get(0);
    }

    public Integer getMinCounter(Map<Integer, Integer> map, int start, int end) {
        if (end > start) {
            //Implies there is a zero in the list somewhere
        }
        Integer min = map.get(start);
        for (int index = start; index <= end; index++) {
            Integer counter = map.get(index);
            if (min == null) {
                min = counter;
            }
            if (counter != null && counter < min) {
                min = counter;
            }
        }
        return min;
    }

//    public int jump (int[] nums, int length) {
//        //For a given value at index i, see how far it can go by checking child values
//
//        //nums[0] = 2, check num[1] & num[2] which highest value
//
//        int index = 0;
//        int count = 0;
//        int currentMax =0;
//        while (index < nums.length) {
//            count ++;
//
//            int maxSum = 0;
//            for (int childIndex = index; childIndex <= currentMax; childIndex++) {
//                maxSum = Math.max(maxSum, nums[childIndex] + childIndex);
//                index++;
//            }
//            if (maxSum >= length - 1) {
//                return count;
//            }
//            currentMax = maxSum;
//
//            if (currentMax < index) {
//                //Something went wrong
//                return 0;
//            }
//        }
//        return 0;
//    }
}
