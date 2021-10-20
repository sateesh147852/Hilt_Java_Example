package com.app.hilt.utilites;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;

public class Utility {

    public boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo !=null && networkInfo.isConnected();
    }


    public ArrayList<String> getNames(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Dhoni");
        names.add("Ruturaj");
        names.add("faf");
        names.add("Robbin");
        names.add("Ali");
        names.add("Raidu");
        names.add("Raina");
        names.add("Jadeja");
        names.add("Bravo");
        names.add("Curun");
        names.add("Chahar");
        names.add("Thakur");
        names.add("Josh");
        names.add("asif");
        return names;
    }

}
