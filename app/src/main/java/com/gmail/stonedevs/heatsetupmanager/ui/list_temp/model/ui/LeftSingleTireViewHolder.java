package com.gmail.stonedevs.heatsetupmanager.ui.list_temp.model.ui;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.stonedevs.heatsetupmanager.databinding.TireLayoutSingleLeftBinding;
import com.gmail.stonedevs.heatsetupmanager.ui.list_temp.SingleTire;
import com.gmail.stonedevs.heatsetupmanager.ui.list_temp.TireTempViewModel;

import static com.gmail.stonedevs.heatsetupmanager.Utils.convertTempStringToInt;

public class LeftSingleTireViewHolder extends RecyclerView.ViewHolder {
    private final TireLayoutSingleLeftBinding binding;
    private TireTempViewModel viewModel;

    public LeftSingleTireViewHolder(@NonNull TireLayoutSingleLeftBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public SingleTire getSingleTire(int position) {
        return viewModel.getSingleTireFromPosition(position);
    }

    public void bind(TireTempViewModel viewModel, int position) {
        this.viewModel = viewModel;

        binding.title.setText(getSingleTire(position).getTitle());
        binding.outsideEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setOutsideTempForPosition(position, convertTempStringToInt(String.valueOf(s)));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.middleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setMiddleTempForPosition(position, convertTempStringToInt(String.valueOf(s)));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.insideEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setInsideTempForPosition(position, convertTempStringToInt(String.valueOf(s)));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}