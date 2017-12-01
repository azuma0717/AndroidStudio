package com.gmail.yuki.user_profile_1130;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yuki on 2017/12/01.
 */

public class Database_Helper extends AsyncTask<String, Void, String> {


    Context cotext;
    String show;

    Database_Helper(Context context) {
        this.cotext = context;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://10.0.1.52:8888/Androidims/MySQL_User_Profile.php";

        String method = params[0];
        if (method.equals("yukicheck")) {

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                InputStream is = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine())!= null){
                    sb.append(line+"\n");
                }



                String reslut = sb.toString();
                bufferedReader.close();
                is.close();

                httpURLConnection.disconnect();

                return reslut;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "99";
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    //バックグラウンドでの非同期処理が終了後メインスレッドに結果を返す
    @Override
    protected void onPostExecute(String result) {

        show = result;

        Intent intent = new Intent(cotext,MainActivity.class);
        intent.putExtra("idnumber",result);
        cotext.startActivity(intent);


    }
}

