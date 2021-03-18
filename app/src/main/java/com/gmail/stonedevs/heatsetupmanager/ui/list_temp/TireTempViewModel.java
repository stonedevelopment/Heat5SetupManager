package com.gmail.stonedevs.heatsetupmanager.ui.list_temp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gmail.stonedevs.heatsetupmanager.ui.list_temp.model.LeftFrontSingleTire;
import com.gmail.stonedevs.heatsetupmanager.ui.list_temp.model.LeftRearSingleTire;
import com.gmail.stonedevs.heatsetupmanager.ui.list_temp.model.RightFrontSingleTire;
import com.gmail.stonedevs.heatsetupmanager.ui.list_temp.model.RightRearSingleTire;

public class TireTempViewModel extends ViewModel {
    MutableLiveData<Integer> leftFrontClicks = new MutableLiveData<>();
    MutableLiveData<Integer> rightFrontClicks = new MutableLiveData<>();
    MutableLiveData<Integer> leftRearClicks = new MutableLiveData<>();
    MutableLiveData<Integer> rightRearClicks = new MutableLiveData<>();

    LeftFrontSingleTire leftFrontSingleTire = new LeftFrontSingleTire();
    RightFrontSingleTire rightFrontSingleTire = new RightFrontSingleTire();
    LeftRearSingleTire leftRearSingleTire = new LeftRearSingleTire();
    RightRearSingleTire rightRearSingleTire = new RightRearSingleTire();

    public SingleTire getSingleTireFromPosition(int position) {
        switch (position) {
            case 0:
                return leftFrontSingleTire;
            case 1:
                return rightFrontSingleTire;
            case 2:
                return leftRearSingleTire;
            case 3:
                return rightRearSingleTire;
            default:
                return null;
        }
    }

    public void setInsideTempForPosition(int position, int temp) {
        switch (position) {
            case 0:
                leftFrontSingleTire.setInsideTemp(temp);
                break;
            case 1:
                rightFrontSingleTire.setInsideTemp(temp);
                break;
            case 2:
                leftRearSingleTire.setInsideTemp(temp);
                break;
            case 3:
                rightRearSingleTire.setInsideTemp(temp);
                break;
        }
        calculateForPosition(position);
    }

    public void setMiddleTempForPosition(int position, int temp) {
        switch (position) {
            case 0:
                leftFrontSingleTire.setMiddleTemp(temp);
                break;
            case 1:
                rightFrontSingleTire.setMiddleTemp(temp);
                break;
            case 2:
                leftRearSingleTire.setMiddleTemp(temp);
                break;
            case 3:
                rightRearSingleTire.setMiddleTemp(temp);
                break;
        }
        calculateForPosition(position);

    }

    public void setOutsideTempForPosition(int position, int temp) {
        switch (position) {
            case 0:
                leftFrontSingleTire.setOutsideTemp(temp);
                break;
            case 1:
                rightFrontSingleTire.setOutsideTemp(temp);
                break;
            case 2:
                leftRearSingleTire.setOutsideTemp(temp);
                break;
            case 3:
                rightRearSingleTire.setOutsideTemp(temp);
                break;
        }
        calculateForPosition(position);
    }

    private void calculateForPosition(int position) {
        switch (position) {
            case 0:
                leftFrontClicks.setValue(leftFrontSingleTire.calculateClicks());
                break;
            case 1:
                rightFrontClicks.setValue(rightFrontSingleTire.calculateClicks());
                break;
            case 2:
                leftRearClicks.setValue(leftRearSingleTire.calculateClicks());
                break;
            case 3:
                rightRearClicks.setValue(rightRearSingleTire.calculateClicks());
                break;
        }
    }
}