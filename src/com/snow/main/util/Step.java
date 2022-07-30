package com.snow.main.util;

public class Step {
    public  String id;
    public int step;

    public Step(int i, String id) {
        this.step = i;
        this.id = id;
    }

    public int getStep() {
        return step;
    }

    public int setStep(int step) {
        this.step = step;
        return step;
    }

}
