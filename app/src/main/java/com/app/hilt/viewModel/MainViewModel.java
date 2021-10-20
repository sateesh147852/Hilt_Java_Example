package com.app.hilt.viewModel;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.hilt.android.lifecycle.HiltViewModel;
import timber.log.Timber;

@HiltViewModel
public class MainViewModel extends ViewModel {

    @Inject
    MainViewModel(@Named("firstName") String fName,@Named("lastName") String lName){
        Timber.i("MainViewModel "+ fName+ " "+lName);
    }

}
