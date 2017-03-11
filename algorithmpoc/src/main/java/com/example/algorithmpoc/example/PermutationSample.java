package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.Sample;
import com.example.algorithmpoc.sample.SampleAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyho on 07/01/2017.
 */
public class PermutationSample extends Sample implements SampleAction {
    List<String> permutationList = new ArrayList<String>();

    @Override
    public void action() {
        //Give  a string, find the permuation of the string
        String word ="abc"; //abc, acb, bac, bca, cba, cab

        //Substring of itself return empty string
        Log.e("Substring", word.substring(0,0));
        permutate(word);
    }

    private void permutate(String word) {
        permutate("", word);
    }

    private void permutate (String prefix, String rest) {
        //generate 2 list, 1 selected word, the remaining list
        if (rest.isEmpty()) {
            Log.e("PermutationSample", prefix);
            permutationList.add(prefix);
        }

        for (int i=0; i< rest.length(); i++) {
            String selectedCharacter = getSelectedCharacter(rest, i);
            String remainingCharacter = getRemainingCharacter(rest, i);

            permutate(prefix + selectedCharacter, remainingCharacter);
        }
    }

    private String getSelectedCharacter(String rest, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(rest.charAt(i));
        return sb.toString();
    }

    private String getRemainingCharacter(String rest, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(rest.substring(0,i));
        sb.append(rest.substring(i + 1, rest.length()));
        return sb.toString();
    }
}
