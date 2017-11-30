package com.gmail.yuki.test_boot3;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by yuki on 2017/11/22.
 */

public class BootStrap_2 extends Application{

    @Override
    public void onCreate() {

        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
    }


}
