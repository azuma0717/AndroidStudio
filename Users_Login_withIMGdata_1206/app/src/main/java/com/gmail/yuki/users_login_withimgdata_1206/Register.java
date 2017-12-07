package com.gmail.yuki.users_login_withimgdata_1206;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class Register extends Activity implements SensorEventListener, View.OnClickListener {

    SensorManager sm;
    Button bt1, bt2;
    EditText ed1,ed2,ed3;
    ImageView iv1;
    Uri uri;
    String img_name;
    String encodeString;
    int response_code = 123;
    Database_Helper databese_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sm = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        Sensor accel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL);

        bt1 = findViewById(R.id.select);
        bt2 = findViewById(R.id.submit);
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.email);
        ed3 = findViewById(R.id.pass);
        iv1 = findViewById(R.id.img);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.select:

                ////写真を選択したタイミングで、インテントされる。
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, response_code);

                break;

            case R.id.submit:

                databese_helper = new Database_Helper(Register.this);
                String method = "userinfo_register";
                String name = ed1.getText().toString();
                String email = ed2.getText().toString();
                String pass = ed3.getText().toString();

                databese_helper.execute(method,name,email,pass,img_name,encodeString);


                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                iv1.setImageBitmap(null);





        }

    }

    /////////////sensor part///////////////////////////////////

    @Override
    public void onSensorChanged(SensorEvent event) {

        float value[] = event.values;
        float x = value[0];
        float y = value[1];
        float z = value[2];

        float asr = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        if (asr >= 2) {

            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }

    ///////////////////////////////////////////////////////////

    ////////////////get a pictures from storage////////////////

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == response_code && resultCode == RESULT_OK) {

            //インテントされて来た（写真を選んだタイミングで）写真データのURIを格納する

            uri = data.getData();
            //写真のデータ。名前とか、日付とかを配列に格納する。
            String[] file_path_colum = {MediaStore.Images.Media.DATA};

            //データのカーサーをセットする。URIと写真配列のデータをセット。他はNULL。
            Cursor cursor = getContentResolver().query(uri, file_path_colum, null, null, null);

            ////ストレージにある写真たちの中から、この写真の選択したときの、インデックスナンバーを入れる。
            int colum_index_num = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String image_path = cursor.getString(colum_index_num);
            Toast.makeText(getApplicationContext(), image_path, Toast.LENGTH_SHORT).show();
            Bitmap bitmap = BitmapFactory.decodeFile(image_path);
            iv1.setImageBitmap(bitmap);
            File f = new File(image_path);
            img_name = f.getName();

 //////////////Encoding to Base64/////////////////////////////////////////////

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] imgarr = stream.toByteArray();
            encodeString = Base64.encodeToString(imgarr, 0);

        }

        ////////////////////////////////////////////////////////////////

    }
}
