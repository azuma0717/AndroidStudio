package com.gmail.yuki.shop_demo_app;

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

/**
 * Created by yuki on 2017/12/08.
 */

public class Database_Helper extends AsyncTask<String, Void, String> {

    Context context;
    //    ProgressDialog dialog;
    int result_action = 0;


    public Database_Helper(Context context) {

        this.context = context;
    }

    @Override
    protected void onPreExecute() {
//        dialog = new ProgressDialog(context);
//        dialog.setMessage("loading....");
//        dialog.show();
    }


    @Override
    protected String doInBackground(String... params) {


//        String reg_url = "http://10.0.1.42:8888/Androidims/ShopDemoApp_Add.php";
        String reg_url = "http://192.171.144.40:8888/Androidims/ShopDemoApp_Add.php";
        String method = params[0];

        if (method.equals("add")) {

            String cname = params[1];

            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("cname", "UTF-8") + "=" + URLEncoder.encode(cname, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                is.close();

                return "adding is completed.";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (method.equals("category")) {

//            reg_url = "http://10.0.1.42:8888/Androidims/ShopDemoApp_GetCategory.php";
            reg_url = "http://192.171.144.40:8888/Androidims/ShopDemoApp_GetCategory.php";

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

        } else if (method.equals("CreateProduct")) {

//            reg_url = "http://10.0.1.42:8888/Androidims/ShopDemoApp_Product.php";
            reg_url = "http://192.171.144.40:8888/Androidims/ShopDemoApp_Product.php";

            String cid = params[1];
            String name = params[2];
            String price = params[3];
            String img = params[4];

            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("cid", "UTF-8") + "=" + URLEncoder.encode(cid, "UTF-8") + "&" +
                        URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8") + "&" +
                        URLEncoder.encode("img", "UTF-8") + "=" + URLEncoder.encode(img, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                is.close();

                return "adding is completed.";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (method.equals("productshow")) {

//            reg_url = "http://10.0.1.42:8888/Androidims/ShopDemoApp_ProductShow.php";
            reg_url = "http://192.171.144.40:8888/Androidims/ShopDemoApp_ProductShow.php";

            String pid = params[1];

            try {
                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("pid", "UTF-8") + "=" + URLEncoder.encode(pid, "UTF-8");


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

                result_action = 2;

                return result;

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

        if (reslut.equals("adding is completed.")) {

            Toast.makeText(context, reslut, Toast.LENGTH_SHORT).show();

        } else if(result_action == 2) {

//            Toast.makeText(context, reslut, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context,ProductShow.class);
            intent.putExtra("productshow",reslut);
            context.startActivity(intent);

        }
    }
}
