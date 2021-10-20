package com.app.hilt.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.hilt.adapter.NamesAdapter;
import com.app.hilt.databinding.ActivitySecondBinding;
import com.app.hilt.utilites.Utility;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Inject
    Utility utility;

    @Inject
    NamesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRecyclerViewData();
    }

    private void setRecyclerViewData() {
        binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItems.setAdapter(adapter);
        adapter.setNames(utility.getNames());
        adapter.notifyDataSetChanged();
    }
}