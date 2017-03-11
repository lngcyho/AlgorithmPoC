package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

/**
 * Created by Cyho on 07/01/2017.
 */
public class ExclusionSample extends Sample implements SampleAction {
    @Override
    public void action() {
        //Give  a string, find the permuation of the string
        String word ="abc";

        exclusion(word);
    }

    private void exclusion(String word) {
        exclusion("", word);
    }

    private void exclusion(String prefix, String rest) {
        //find the selected Character
        //find the remaining character
        //recursively call it
        if (rest.isEmpty()) {
            Log.e("Exclusion", prefix);
        } else {
            String selectCharacter = getSelectedCharacter(rest);
            String remainingCharacter = getRemainingCharacter(rest);
            //inclusion
            exclusion(prefix + selectCharacter,remainingCharacter);
            //exclusion
            exclusion(prefix,remainingCharacter);
        }
    }

    private String getSelectedCharacter(String rest) {
        StringBuilder sb= new StringBuilder();
        sb.append(rest.charAt(0));
        return sb.toString();
    }


    private String getRemainingCharacter(String rest) {
        return rest.substring(1,rest.length());
    }
}
