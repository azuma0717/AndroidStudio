package com.gmail.yuki.user_profile_1130;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by yuki on 2017/12/01.
 */

public class Database_Helper extends AsyncTask<String, Void, String> {


    Context cotext;
    public static String show;

    Database_Helper(Context context) {
        this.cotext = context;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {

//        String reg_url = "http://10.0.1.52:8888/Androidims/MySQL_User_Profile.php";
        String reg_url = "http://192.168.0.100:8888/Androidims/MySQL_User_Profile.php";

        String method = params[0];
        if (method.equals("yukicheck")) {

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
//                httpURLConnection.setDoOutput(true);
                InputStream is = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


                String reslut = sb.toString();
                show = reslut;
                bufferedReader.close();
                is.close();

                httpURLConnection.disconnect();

                return reslut;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (method.equals("insert")) {

            reg_url = "http://192.168.0.100:8888/Androidims/MySQL_User_Insert.php";


            String name = params[1];
            String phone = params[2];
            String email = params[3];
            String city = params[4];
            String dob = params[5];
            String photo = params[6];


            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(city, "UTF-8") + "&" +
                        URLEncoder.encode("dob", "UTF-8") + "=" + URLEncoder.encode(dob, "UTF-8") + "&" +
                        URLEncoder.encode("photo", "UTF-8") + "=" + URLEncoder.encode(photo, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                is.close();

                return "Insert Success....";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (method.equals("idcheck")) {

//            reg_url = "http://192.168.0.100:8888/Androidims/MySQL_Id_Check.php";
          reg_url = "http://10.0.1.42:8888/Androidims/MySQL_Id_Check.php";

            String id = params[1];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


                String reslut = sb.toString();
//                show = reslut;
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
    protected void onPostExecute(String reslut) {

//        if (reslut.equals("Insert Success....")) {
//
//            Toast.makeText(cotext, reslut, Toast.LENGTH_LONG).show();
//
//        } else {

//            Toast.makeText(cotext, reslut, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(cotext, ShowId.class);
            intent.putExtra("name","tokokokiok");
            cotext.startActivity(intent);
//            Toast.makeText(cotext,reslut,Toast.LENGTH_SHORT).show();

        }
// else {
//
//            Intent intent = new Intent(cotext, MainActivity.class);
//            intent.putExtra("idnumber", reslut);
//            cotext.startActivity(intent);
//        }


//    }
}

