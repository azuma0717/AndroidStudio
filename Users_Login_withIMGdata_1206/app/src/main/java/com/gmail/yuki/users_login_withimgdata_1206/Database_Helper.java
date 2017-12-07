package com.gmail.yuki.users_login_withimgdata_1206;

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

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by yuki on 2017/12/06.
 */

public class Database_Helper extends AsyncTask<String, Void, String> {

    Context context;
    ProgressDialog dialog;
    int result_action= 0;

    public Database_Helper(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(context);
        dialog.setMessage("loading....");
        dialog.show();
    }


    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://10.0.1.42:8888/Androidims/MySQL_Upload_Userinfo.php";
//        String reg_url = "http://192.168.0.100:8888/Androidims/MySQL_Upload_Userinfo.php";
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
                                URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                                URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&" +
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


        } else if (method.equals("login")) {


            reg_url = "http://10.0.1.42:8888/Androidims/MySQL_Login.php";
//            reg_url = "http://192.168.0.100:8888/Androidims/MySQL_Login.php";

            String name = params[1];
            String pass = params[2];

            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data =

                        URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                                URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));


                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {

                    stringBuilder.append(line + "\n");

                }

                bufferedReader.close();
                is.close();
                httpURLConnection.disconnect();

                String result = stringBuilder.toString().trim();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (method.equals("Picture_Insert")) {

            //misao
            reg_url = "http://10.0.1.42:8888/Androidims/MySQL_Upload_Pictures.php";
            //misao g
//            reg_url = "http://192.168.0.100:8888/Androidims/MySQL_Upload_Pictures.php";


            String img_name = params[1];
            String encodedString = params[2];


            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data =
                        URLEncoder.encode("img_name", "UTF-8") + "=" + URLEncoder.encode(img_name, "UTF-8") + "&" +
                                URLEncoder.encode("img_path", "UTF-8") + "=" + URLEncoder.encode(encodedString, "UTF-8");


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

        } else if (method.equals("allimg")) {

            reg_url = "http://10.0.1.42:8888/Androidims/MySQL_All_Img.php";
//            reg_url = "http://192.168.0.100:8888/Androidims/MySQL_All_Img.php";

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                InputStream is = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {

                    stringBuilder.append(line + "\n");

                }

                bufferedReader.close();
                is.close();
                httpURLConnection.disconnect();

                String result = stringBuilder.toString().trim();
                result_action = 1;

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (method.equals("showall")) {

            reg_url = "http://10.0.1.42:8888/Androidims/MySQL_Show_All.php";
//            reg_url = "http://192.168.0.100:8888/Androidims/MySQL_Show_All.php";

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                InputStream is = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {

                    stringBuilder.append(line + "\n");

                }

                bufferedReader.close();
                is.close();
                httpURLConnection.disconnect();

                String result = stringBuilder.toString().trim();
                result_action = 2;
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (method.equals("edit")) {


            reg_url = "http://10.0.1.42:8888/Androidims/MySQL_Edit.php";
//            reg_url = "http://192.168.0.100:8888/Androidims/MySQL_Edit.php";


            String id = params[1];
            String name = params[2];
            String email = params[3];
            String pass = params[4];

            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data =
                                URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&" +
                                URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                                URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                                URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");



                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                is.close();

                return "edit compleated.";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return "fail";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String reslut) {

//        Toast.makeText(context, reslut, Toast.LENGTH_SHORT).show();

        if (reslut.equals("Uploading is completed.")) {

            Toast.makeText(context, reslut, Toast.LENGTH_SHORT).show();

        } else if (reslut.equals("login completed.")) {

            Intent intent = new Intent(context, Home.class);
            context.startActivity(intent);


        } else if (reslut.equals("login failed.")) {

            Toast.makeText(context, reslut, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, Login.class);
            context.startActivity(intent);

        } else if (reslut.equals("edit compleated.")) {

            Toast.makeText(context, reslut, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, Home.class);
            context.startActivity(intent);

        }else if (reslut.equals("fail")) {

            Toast.makeText(context, reslut, Toast.LENGTH_SHORT).show();

        } else {
            dialog.dismiss();
            if (result_action == 2){

                Intent intent = new Intent(context, ShowAll.class);
                intent.putExtra("showall", reslut);
                context.startActivity(intent);

            }else if(result_action == 1){

                Intent intent = new Intent(context, Allimg.class);
                intent.putExtra("allimg", reslut);
                context.startActivity(intent);
            }

        }


    }

}
