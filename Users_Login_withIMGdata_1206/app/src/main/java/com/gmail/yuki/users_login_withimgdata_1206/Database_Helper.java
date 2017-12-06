package com.gmail.yuki.users_login_withimgdata_1206;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by yuki on 2017/12/06.
 */

public class Database_Helper extends AsyncTask<String, Void, String> {

    Context context;

    public Database_Helper(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://10.0.1.42:8888/Androidims/MySQL_Upload_image2.php";
        String method = params[0];

        if (method.equals("userinfo_register")) {

            String name = params[1];
            String email = params[2];
            String pass = params[3];
            String img_name = params[4];
            String encodedstring = params[5];

            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data =

                                URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                                URLEncoder.encode("img_name", "UTF-8") + "=" + URLEncoder.encode(img_name, "UTF-8") + "&" +
                                URLEncoder.encode("img_name", "UTF-8") + "=" + URLEncoder.encode(img_name, "UTF-8") + "&" +
                                URLEncoder.encode("img_name", "UTF-8") + "=" + URLEncoder.encode(img_name, "UTF-8") + "&" +
                                URLEncoder.encode("img_path", "UTF-8") + "=" + URLEncoder.encode(encodedstring, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                is.close();

                return "Uploading is completed.";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String reslut) {
        Toast.makeText(context, reslut, Toast.LENGTH_SHORT).show();

    }

}
