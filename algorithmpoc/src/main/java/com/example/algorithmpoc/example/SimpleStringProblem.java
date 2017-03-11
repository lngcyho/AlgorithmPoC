package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

/**
 * Created by Cyho on 07/01/2017.
 */
public class SimpleStringProblem extends Sample implements SampleAction {
    @Override
    public void action() {
        //Do stuff here
        String sampleString = "abcdefghi";

        Log.e("ReverseString", reverseString(sampleString));

//        sampleString.compareTo()
        sampleString.endsWith("ghi");
//        sampleString.indexOf("g");
    }

    private String reverseString(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}
