package com.gmail.stonedevs.heatsetupmanager.ui.list_temp;

import android.util.Log;

public class SingleTire {
    private final String title;
    private final double defaultPressure;
    private final int viewType;
    private double outsideTemp;
    private double middleTemp;
    private double insideTemp;

    public SingleTire(String title, int viewType, double defaultPressure) {
        this.title = title;
        this.viewType = viewType;
        this.outsideTemp = 0;
        this.middleTemp = 0;
        this.insideTemp = 0;
        this.defaultPressure = defaultPressure;
    }

    public String getTitle() {
        return title;
    }

    public int getOutsideTemp() {
        return (int) outsideTemp;
    }

    public void setOutsideTemp(int outsideTemp) {
        Log.d("setOutsideTemp", outsideTemp + " <> " + this.outsideTemp);
        this.outsideTemp = outsideTemp;
    }

    public int getMiddleTemp() {
        return (int) middleTemp;
    }

    public void setMiddleTemp(int middleTemp) {
        this.middleTemp = middleTemp;
    }

    public int getInsideTemp() {
        return (int) insideTemp;
    }

    public void setInsideTemp(int insideTemp) {
        this.insideTemp = insideTemp;
    }

    public int getViewType() {
        return viewType;
    }

    public double getDefaultPressure() {
        return defaultPressure;
    }

    private double calculateAverage() {
        return (insideTemp + middleTemp + outsideTemp) / 3.0;
    }

    private double calculateRawAdjustment() {
        return (calculateAverage() - middleTemp) / 4.0;
    }

    private double roundRawAdjustment() {
        return Math.round(calculateRawAdjustment() * 4.0) / 4.0;
    }

    public int calculateClicks() {
        return (int) (roundRawAdjustment() / 0.25);
    }

    public double calculateFromDefault() {
        return getDefaultPressure() + roundRawAdjustment();
    }

    @Override
    public String toString() {
        return "SingleTire{" +
                "title='" + title + '\'' +
                ", defaultPressure=" + defaultPressure +
                ", viewType=" + viewType +
                ", outsideTemp=" + outsideTemp +
                ", middleTemp=" + middleTemp +
                ", insideTemp=" + insideTemp +
                '}';
    }
}
