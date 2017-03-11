package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Cyho on 08/01/2017.
 */
public class ComparatorSample extends Sample implements SampleAction{
    @Override
    public void action() {
        //NOTE: comparator/ compareTo
        //ascending is -1
        //descending is 1
        String firstString = "abc";
        String secondString = "bcd";

        String compare = Integer.toString(secondString.compareTo(firstString));
        Log.e(getClass().toString(), compare);

        List<String> stringList = Arrays.asList("abc", "bcd", "asdf");
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                //lhs.compareTo(rhs) is ascending order by default
                //If  -1 is returned, keep order, If 1 is returned, swap
                return lhs.compareTo(rhs) * -1;
            }
        };

        Collections.sort(stringList, comparator);
        Log.e(getClass().toString(), Arrays.toString(stringList.toArray()));
    }
}
