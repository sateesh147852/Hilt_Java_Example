package com.app.hilt.model;

import javax.inject.Inject;

import timber.log.Timber;

public class Mobile {

    @Inject
    Mobile(Redmi redmi,Samsung samsung){
        Timber.i("Mobile Redmi samsung");
    }

    public void display(){
        Timber.i("Mobile Display method is called");
    }

}
