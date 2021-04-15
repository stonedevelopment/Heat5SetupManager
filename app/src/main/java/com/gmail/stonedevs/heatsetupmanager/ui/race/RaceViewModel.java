package com.gmail.stonedevs.heatsetupmanager.ui.race;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class RaceViewModel extends AndroidViewModel {
    MutableLiveData<RaceState> raceStateMutableLiveData = new MutableLiveData<>(RaceState.Init);
    Race race;

    public RaceViewModel(@NonNull Application application) {
        super(application);
    }

    void init() {
        race = new Race();
        raceStateMutableLiveData.setValue(RaceState.PreRace);
    }

    void preRace() {

    }

    void start() {

    }
}