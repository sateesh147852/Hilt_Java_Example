package com.app.hilt.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.app.hilt.databinding.ActivityMainBinding;
import com.app.hilt.model.Mobile;
import com.app.hilt.utilites.Utility;
import com.app.hilt.viewModel.MainViewModel;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Inject
    @Named("firstName")
    String firstName;

    @Inject
    @Named("lastName")
    String lastName;

    @Inject
    RequestManager requestManager;

    @Inject
    Utility utility;

    @Inject
    Mobile mobile;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        printNames();
        loadImage();
        loadFragment();
        setOnClickListener();
        initializeViewModel();

        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().replace(binding.flContainer.getId(), ProfileFragment.newInstance(), "Profile").commit();
    }

    private void initializeViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Timber.i(mainViewModel.toString());
    }

    private void setOnClickListener() {
        binding.btClick.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });
    }

    private void loadFragment() {
        //getSupportFragmentManager().beginTransaction().replace(binding.flContainer.getId(), ProfileFragment.newInstance(), "Profile").commit();
    }

    private void loadImage() {
        requestManager.load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfU-D8wCubuzDiHFO51U-0km3pUztmPQd09Q&usqp=CAU")
                .into(binding.ivProfile);
    }

    private void printNames() {
        Timber.i(firstName + " " + lastName);
        mobile.display();

        if (utility.isNetworkAvailable(this))
            Toast.makeText(this, "Connection is available", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Connection is not available", Toast.LENGTH_SHORT).show();
    }
}