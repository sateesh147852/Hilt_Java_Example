package com.app.hilt.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.app.hilt.R;
import com.app.hilt.databinding.FragmentProfileBinding;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProfileFragment extends Fragment {

    @Inject
    @Named("firstName")
    String firstName;

    @Inject
    @Named("lastName")
    String lastName;

    private static ProfileFragment profileFragment;

    public static ProfileFragment newInstance() {
        if (profileFragment == null)
            profileFragment = new ProfileFragment();
        return profileFragment;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentProfileBinding binding = FragmentProfileBinding.inflate(inflater,container,false);
        binding.tvName.setText(firstName + " "+lastName);
        return binding.getRoot();
    }
}