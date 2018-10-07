package com.example.android.cricket.model;

/**
 * Created by AM on 16-11-2017.
 */

public class Innings {
    private int rRuns;
    private int rWickets;
    private int rBalls;
    private int rFours;
    private int rSixes;

    public Innings(int rRuns, int rWickets, int rBalls, int rFours, int rSixes) {
        this.rRuns = rRuns;
        this.rWickets = rWickets;
        this.rBalls = rBalls;
        this.rFours = rFours;
        this.rSixes = rSixes;
    }

    public int getRuns() {
        return rRuns;
    }

    public int getWickets() {
        return rWickets;
    }

    public int getBalls() {
        return rBalls;
    }

    public int getFours() { return rFours; }

    public int getSixes() {
        return rSixes;
    }

}
