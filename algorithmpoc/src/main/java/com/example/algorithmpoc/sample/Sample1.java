package com.example.algorithmpoc.sample;

/**
 * Created by Cyho on 07/01/2017.
 */
public class Sample1 extends Sample implements SampleAction{
    private int sample = 0;

    public Sample1() {
        this(0);
    }

    public Sample1(int sample) {
        this.sample = sample;
    }

    public int getSample() {
        return 0;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }

    @Override
    public void action () {
        //Do your stuff here :)


    }
}
