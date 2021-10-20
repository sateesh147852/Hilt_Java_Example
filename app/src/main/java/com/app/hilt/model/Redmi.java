package com.app.hilt.model;

import javax.inject.Inject;

import timber.log.Timber;

public class Redmi {

    @Inject
    Redmi(){
        Timber.i("Mobile","Redmi");
    }
}
