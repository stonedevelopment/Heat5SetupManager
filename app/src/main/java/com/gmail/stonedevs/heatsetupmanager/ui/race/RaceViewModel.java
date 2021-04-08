package com.gmail.stonedevs.heatsetupmanager.ui.race;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RaceViewModel extends ViewModel {
    MutableLiveData<RaceState> raceStateMutableLiveData = new MutableLiveData<>(RaceState.Init);
}