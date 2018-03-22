package com.example.android.cricket;

/**
 * Created by AM on 16-11-2017.
 */

public class Innings {
    private int _id;
    private int rRuns;
    private int rWickets;
    private int rBalls;
    private int rFours;
    private int rSixes;

    public Innings() {
    }

    public Innings(int rRuns, int rWickets, int rBalls, int rFours, int rSixes) {
        this.rRuns = rRuns;
        this.rWickets = rWickets;
        this.rBalls = rBalls;
        this.rFours = rFours;
        this.rSixes = rSixes;
    }


    public void set_id(int _id) {
        this._id = _id;
    }

    public void setrRuns(int rRuns) {
        this.rRuns = rRuns;
    }

    public void setrWickets(int rWickets) {
        this.rWickets = rWickets;
    }

    public void setrBalls(int rBalls) {
        this.rBalls = rBalls;
    }

    public void setrFours(int rFours) {
        this.rFours = rFours;
    }

    public void setrSixes(int rSixes) {
        this.rSixes = rSixes;
    }


    public int get_id() {
        return _id;
    }

    public int getrRuns() {
        return rRuns;
    }

    public int getrWickets() {
        return rWickets;
    }

    public int getrBallss() {
        return rBalls;
    }

    public int getrFours() {

        return rFours;
    }

    public int getrSixes() {
        return rSixes;
    }

}
