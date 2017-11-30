package com.gmail.yuki.homework_sensor2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yuki on 2017/11/22.
 */

public class Broadcast_Receiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("RECEIVE", "action:" + intent.getAction());
    }
}
