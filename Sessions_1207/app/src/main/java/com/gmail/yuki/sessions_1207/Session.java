package com.gmail.yuki.sessions_1207;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yuki on 2017/12/07.
 */

public class Session {
    SharedPreferences sharedPreferences;
    Context context;
    String session_name;
    SharedPreferences.Editor editor;

    Session(Context context, String session_name){
        this.session_name = session_name;
        this.context = context;
        sharedPreferences= context.getSharedPreferences(session_name,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public String getName(String key) {

        return sharedPreferences.getString(key,null);
    }

    public void setName(String key, String value) {
        editor.putString(key,value);
    }

}
