package com.gmail.yuki.mysql_insert;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
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
import java.sql.SQLException;


import javax.net.ssl.HttpsURLConnection;

/**
 * Created by yuki on 2017/11/27.
 */


//1.onPreExecute()
//2.doInBackground()
//3.onProgressUpdate() ※doInBackground()で、publishProgress()が呼ばれた場合に処理されます。
//4.onPostExecute()



//AndroidでHTTP通信をするには非同期処理である必要なので、AsyncTaskクラスを継承する。
//参照型の引数

public class Database_Helper extends AsyncTask<String, Void, String> {


    Context ctx;

    Database_Helper(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        loadingDialog = ProgressDialog.show(ctx,"Please Wait","loading...");
    }

    @Override
    protected String doInBackground(String... params) {

        //バックグラウンドでの非同期処理、何か重い処理を記述する
        //ここに渡されるパラメータの型は1つめのString
        //php file is defined///////////////////////////////////////////////

        String reg_url = "http://10.0.1.52:8888/Androidims/MySQL_Insert.php";


        /////引数は、arrayに格納されている/////////

        String method = params[0];
        if (method.equals("Register")) {
            String name = params[1];
            String email = params[2];
            String phone = params[3];


            ////////全ての条件がOKだったらReturnを返して、onPostExecuteに渡す///////
            try {

                //making URL////
                URL url = new URL(reg_url);

                //接続用。make HttpURLConnection object////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                ///request metohod /////
                httpURLConnection.setRequestMethod("POST");
                /// データを書き込む場合はtrue
                httpURLConnection.setDoOutput(true);

                //// 本文を書き込む////
                OutputStream os = httpURLConnection.getOutputStream();

                ///BufferedWriterクラスのコンストラクタに
                // 他のWriterクラスのサブクラスを渡すことで、そのクラスを「出力先」として出力する。
                // 今回は出力先をネットワーク(OutputStream)に設定

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8");


                //write()メソッドで出力を行う。出力先にはすぐさま出力せず、
                //渡された文字や文字列を「バッファ」というBufferedWriterクラス内のフィールドに格納しておく。

                bufferedWriter.write(data);

                //flush()メソッドが呼ばれた時や、バッファがいっぱいになった時、
                //close()メソッドが呼ばれた時にまとめてバッファの中身を出力先に出力する。

                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                is.close();

                return "Registration Success....";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (method.equals("yukifind")) {
            String id = params[1];
             reg_url = "http://10.0.1.52:8888/Androidims/Select.php";


            ////////全ての条件がOKだったらReturnを返して、onPostExecuteに渡す///////
            try {

                //making URL////
                URL url = new URL(reg_url);

                //接続用。make HttpURLConnection object////
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                ///request metohod /////
                httpURLConnection.setRequestMethod("POST");
                /// データを書き込む場合はtrue
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //// 本文を書き込む////
                OutputStream os = httpURLConnection.getOutputStream();

                ///BufferedWriterクラスのコンストラクタに
                // 他のWriterクラスのサブクラスを渡すことで、そのクラスを「出力先」として出力する。
                // 今回は出力先をネットワーク(OutputStream)に設定

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");


                //write()メソッドで出力を行う。出力先にはすぐさま出力せず、
                //渡された文字や文字列を「バッファ」というBufferedWriterクラス内のフィールドに格納しておく。

                bufferedWriter.write(data);

                //flush()メソッドが呼ばれた時や、バッファがいっぱいになった時、
                //close()メソッドが呼ばれた時にまとめてバッファの中身を出力先に出力する。

                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
                StringBuilder sb = new StringBuilder();
                String line = null;

                while((line = bufferedReader.readLine()) != null )
                {
                    sb.append(line+ "\n");
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


        return null;
    }

//     途中経過をメインスレッドで表示する場合
//     doInBackground内でpublishProgressを設定するとメインスレッドから呼ばれる。パラメータの型は2つめのvoid

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    //バックグラウンドでの非同期処理が終了後メインスレッドに結果を返す
    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Registration Success....")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else{

            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();


        }

    }
}