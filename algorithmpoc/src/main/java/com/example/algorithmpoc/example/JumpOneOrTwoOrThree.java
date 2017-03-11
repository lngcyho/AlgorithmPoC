package com.example.algorithmpoc.example;

import android.util.Log;

import com.example.algorithmpoc.sample.SampleAction;

/**
 * Created by Cyho on 02/02/2017.
 */

public class JumpOneOrTwoOrThree implements SampleAction {

    @Override
    public void action() {
        int steps = 3;
        Integer numberOfTotalPaths = findTotalNumberOfPath(steps);
        Integer numberOfTotalStepsTaken = findTotalNumberOfStepTaken(steps, 0);

        partition(steps, 3);

        Log.e(getClass().getName(), numberOfPath.toString());
        Log.e(getClass().getName(), numberOfTotalPaths.toString());
        Log.e(getClass().getName(), numberOfTotalStepsTaken.toString());
    }

    private int findTotalNumberOfPath(int steps) {
        if (steps == 0) {
            return 1;
        }
        if (steps < 0) {
            return 0;
        }

        int numberOfPathForOneStep = findTotalNumberOfPath(steps - 1);
        int numberOfPathForTwoStep = findTotalNumberOfPath(steps - 2);
        int numberOfPathForThreeStep = findTotalNumberOfPath(steps - 3);

        return numberOfPathForOneStep + numberOfPathForTwoStep + numberOfPathForThreeStep;
    }

    private Integer numberOfPath = 0;

    private void partition(int steps, int maxValue) {
        if (steps < 0 || maxValue == 0) {
            return;
        }
        if (steps == 0) {
            numberOfPath++;
        }

        for (int i = 1; i <= maxValue; i++) {
            //Store result in hashmap
            partition(steps - i, i); //Ex: this ignore scenario such as 1,2 because initial pass through is i=1
        }
    }

    Integer numberOfTotalStepsTaken = 0;
    private int findTotalNumberOfStepTaken(int steps, int numberOfTotalStepsTaken) {
        if (steps == 0) {
            return numberOfTotalStepsTaken;
        }
        if (steps < 0) {
            return 0;
        }
        int numberOfTotalStepsTakenByOne = findTotalNumberOfStepTaken(steps - 1, numberOfTotalStepsTaken + 1);
        int numberOfTotalStepsTakenByTwo = findTotalNumberOfStepTaken(steps - 2, numberOfTotalStepsTaken + 1);
        int numberOfTotalStepsTakenByThree = findTotalNumberOfStepTaken(steps - 3, numberOfTotalStepsTaken + 1);
        return numberOfTotalStepsTakenByOne + numberOfTotalStepsTakenByTwo + numberOfTotalStepsTakenByThree;
    }
}
