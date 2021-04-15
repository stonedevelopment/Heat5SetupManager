package com.gmail.stonedevs.heatsetupmanager.ui.race;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.gmail.stonedevs.heatsetupmanager.databinding.RaceFragmentBinding;

import org.jetbrains.annotations.NotNull;

public class RaceFragment extends NavHostFragment {

    private RaceFragmentBinding binding;
    private RaceViewModel viewModel;

    public static RaceFragment newInstance() {
        return new RaceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setBinding(RaceFragmentBinding.inflate(inflater, container, false));
        setupViewModel();
        setupViews();
        observeViewModel();
        return getBinding().getRoot();
    }

    private RaceFragmentBinding getBinding() {
        return binding;
    }

    private void setBinding(@NotNull RaceFragmentBinding binding) {
        this.binding = binding;
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(requireActivity()).get(RaceViewModel.class);
    }

    private void setupViews() {

    }

    private void observeViewModel() {
        viewModel.raceStateMutableLiveData.observe(requireActivity(), state -> {
            switch (state) {
                case Init:
                    //  race setup pop up
                    //  if any card is pressed, show pop up
                    viewModel.init();
                    break;
                case PreRace:
                    //  only card enabled is start
                    break;
                case Start:
                    //  stage/race has started
                    //  disable this card
                    //  enable all other cards
                    break;
                case Caution:
                    //  caution called
                    //  user to input lap number
                    //  system to determine pit lap
                    break;
                case Pit:
                    //  user controlled state
                    //  pit state should hold which pit strategy user chose
                    //  system to determine restart lap (overridable)
                    break;
                case Restart:
                    //  race has restarted
                    //  lap number determined by pit lap
                    //  overridden by long pressing?
                    break;
                case End:
                    //  end of stage/race
                    //  displays last lap
                    //  should display confirmation pop up
                    break;
            }
        });
    }
}