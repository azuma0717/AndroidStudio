package com.gmail.yuki.alarm_1201;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by yuki on 2017/12/01.
 */

public class AlarmReciver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Wake up Wake up",Toast.LENGTH_LONG).show();
        Uri alaramUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if(alaramUri == null){

            alaramUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        }

        Ringtone ringtone = RingtoneManager.getRingtone(context,alaramUri);
        ringtone.play();

    }
}
