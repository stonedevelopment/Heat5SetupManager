package com.gmail.stonedevs.heatsetupmanager.ui.list_temp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.stonedevs.heatsetupmanager.databinding.TireTempFragmentBinding;

import org.jetbrains.annotations.NotNull;

public class TireTempFragment extends Fragment {
    public static final String TAG = TireTempFragment.class.getCanonicalName();

    private TireTempViewModel viewModel;
    private TireTempFragmentBinding binding;

    public static TireTempFragment newInstance() {
        return new TireTempFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setBinding(TireTempFragmentBinding.inflate(inflater, container, false));
        setupViewModel();
        setupViews();
        observeViewModel();
        return getBinding().getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private TireTempFragmentBinding getBinding() {
        return binding;
    }

    private void setBinding(@NotNull TireTempFragmentBinding binding) {
        this.binding = binding;
    }

    private RecyclerView getRecyclerView() {
        return binding.singleTireRecyclerView;
    }

    protected void setupViewModel() {
        viewModel = new ViewModelProvider(requireActivity()).get(TireTempViewModel.class);
    }

    protected void setupViews() {
        getRecyclerView().setAdapter(new SingleTireAdapter(viewModel));
    }

    protected void observeViewModel() {
        viewModel.leftFrontClicks.observe(getViewLifecycleOwner(), clicks -> binding.leftFrontClicks.setText(String.valueOf(clicks)));
        viewModel.rightFrontClicks.observe(getViewLifecycleOwner(), clicks -> binding.rightFrontClicks.setText(String.valueOf(clicks)));
        viewModel.leftRearClicks.observe(getViewLifecycleOwner(), clicks -> binding.leftRearClicks.setText(String.valueOf(clicks)));
        viewModel.rightRearClicks.observe(getViewLifecycleOwner(), clicks -> binding.rightRearClicks.setText(String.valueOf(clicks)));
    }
}