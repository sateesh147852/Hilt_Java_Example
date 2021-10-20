package com.app.hilt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.hilt.databinding.NamesItemBinding;

import java.util.ArrayList;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NamesViewHolder> {

    private ArrayList<String> names = new ArrayList<>();

    @NonNull
    @Override
    public NamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NamesItemBinding binding = NamesItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new NamesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NamesViewHolder holder, int position) {
        holder.binding.tvName.setText(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names == null ? 0 : names.size();
    }

    public void setNames(ArrayList<String> names){
        this.names = names;
    }

    public class NamesViewHolder extends RecyclerView.ViewHolder{

        private final NamesItemBinding binding;

        public NamesViewHolder(@NonNull NamesItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
