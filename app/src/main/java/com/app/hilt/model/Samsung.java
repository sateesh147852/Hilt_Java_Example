package com.app.hilt.model;

import javax.inject.Inject;

import timber.log.Timber;

public class Samsung {

    @Inject
    Samsung(){
        Timber.i("Mobile","Samsung");
    }
}
