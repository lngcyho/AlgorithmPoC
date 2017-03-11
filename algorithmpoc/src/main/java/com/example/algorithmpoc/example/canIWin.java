package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cyho on 12/01/2017.
 */

//TODO
public class canIWin implements SampleAction {

    @Override
    public void action() {
        Boolean canIWin = canIWin(10, 40);
        Log.e(getClass().getName(), canIWin.toString());
    }

    public Map<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //What do we do when the maxChooseInteger or sum of maxChooseInteger < desireTotal?
        if (sum(maxChoosableInteger) < desiredTotal) {
            return false;
        }
        //What do we do when is maxChooseInteger > desireTotal?
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        //Keep track of list of states (index/ move taken), total
        return isItPossibleToWin(desiredTotal, new boolean[maxChoosableInteger]);
    }

    public boolean isItPossibleToWin(int desiredTotal, boolean[] state) {
//        if (hashMap.get(desiredTotal) != null) {
//            return hashMap.get(desiredTotal);
//        }
        for (int choosableInteger = 0; choosableInteger < state.length; choosableInteger++) {
            //when not chosen and is available
            if (isIntegerAvailable(choosableInteger, state)) {
                state[choosableInteger] = true;
                if (desiredTotal <= choosableInteger + 1 || !isItPossibleToWin(desiredTotal - (choosableInteger + 1), state)) {
                    //you win
                    state[choosableInteger] = false;
//                    hashMap.put(desiredTotal, true);
                    return true;
                }

            }
//            state[choosableInteger] = false;
        }
//        hashMap.put(desiredTotal, false);
//        return  hashMap.get(desiredTotal);
        return false;
    }

    private boolean isIntegerAvailable(int choosableInteger, boolean[] state) {
        return !state[choosableInteger];
    }

    private int sum(int maxChoosableInteger) {
        //return n (n+1) /2
        return maxChoosableInteger * (maxChoosableInteger + 1) / 2;
    }
}

