package com.gmail.yuki.mysql_getdata_1205;

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
 * Created by yuki on 2017/12/05.
 */

public class Database_Helper extends AsyncTask<Void,Void,String>
{
    Context context;

    Database_Helper(Context context){

        this.context = context;

    }


    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL("http://10.0.1.42:8888/Androidims/MySQL_getdata_1205.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            InputStream is = httpURLConnection.getInputStream();
//
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while((line = bufferedReader.readLine())!=null){

                stringBuilder.append(line + "\n");

            }

            bufferedReader.close();
            is.close();
            httpURLConnection.disconnect();

            String result = stringBuilder.toString().trim();

            return  result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }



    @Override
    protected void onPostExecute(String s) {
//        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context,ListDisplay.class);
        intent.putExtra("data_string",s);
        context.startActivity(intent);
    }
}
