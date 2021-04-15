package com.gmail.stonedevs.heatsetupmanager.ui.setup;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.stonedevs.heatsetupmanager.R;

public class RaceSetupFragment extends Fragment {

    private RaceSetupViewModel mViewModel;

    public static RaceSetupFragment newInstance() {
        return new RaceSetupFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.race_setup_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RaceSetupViewModel.class);
        // TODO: Use the ViewModel
    }

}