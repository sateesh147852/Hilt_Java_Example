package com.app.hilt.di;

import android.content.Context;

import com.app.hilt.R;
import com.app.hilt.adapter.NamesAdapter;
import com.app.hilt.utilites.Utility;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Named("firstName")
    String getFirstName() {
        return "Sateesh";
    }

    @Provides
    @Named("lastName")
    String getLastName() {
        return "Chikkalagi";
    }

    @Provides
    Utility provideUtility() {
        return new Utility();
    }

    @Provides
    NamesAdapter provideNamesAdapter() {
        return new NamesAdapter();
    }

    @Provides
    RequestOptions provideRequestOptions() {
        return RequestOptions.placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);
    }

    @Provides
    RequestManager provideRequestManager(@ApplicationContext Context context) {
        return Glide.with(context).applyDefaultRequestOptions(provideRequestOptions());
    }

}
