package com.gmail.yuki.homework_access_1121;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by yuki on 2017/11/21.
 */

public class BootStrap extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();

    }

}
