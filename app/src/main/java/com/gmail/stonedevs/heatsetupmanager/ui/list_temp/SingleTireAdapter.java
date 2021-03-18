package com.gmail.stonedevs.heatsetupmanager.ui.list_temp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.stonedevs.heatsetupmanager.databinding.TireLayoutSingleLeftBinding;
import com.gmail.stonedevs.heatsetupmanager.databinding.TireLayoutSingleRightBinding;
import com.gmail.stonedevs.heatsetupmanager.ui.list_temp.model.ui.LeftSingleTireViewHolder;
import com.gmail.stonedevs.heatsetupmanager.ui.list_temp.model.ui.RightSingleTireViewHolder;

public class SingleTireAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = SingleTireAdapter.class.getCanonicalName();
    private final TireTempViewModel viewModel;

    public SingleTireAdapter(TireTempViewModel viewModel) {
        super();
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new LeftSingleTireViewHolder(TireLayoutSingleLeftBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false));
        } else {
            return new RightSingleTireViewHolder(TireLayoutSingleRightBinding.inflate(
                    LayoutInflater.from(parent.getContext()), parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ((LeftSingleTireViewHolder) holder).bind(viewModel, position);
        } else {
            ((RightSingleTireViewHolder) holder).bind(viewModel, position);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public SingleTire getItem(int position) {
        return viewModel.getSingleTireFromPosition(position);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }
}