package com.example.waymovies;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class FrescoInitializer extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
