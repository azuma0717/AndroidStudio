package com.gmail.yuki.myecsite;

import android.app.Application;
import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by yuki on 2017/11/20.
 */

public class Test_Android extends Application{


    @Override
    public void onCreate() {

        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
    }


}


