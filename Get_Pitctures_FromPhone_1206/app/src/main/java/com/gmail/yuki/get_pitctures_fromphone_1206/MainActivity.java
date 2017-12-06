package com.gmail.yuki.get_pitctures_fromphone_1206;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

import android.util.Base64;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView iv1;
    Button bt1,bt2;
    int response_code = 123;
    Uri uri;
    String encodeString;
    String img_name;
    Database_Helper database_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.image);
        bt1 = findViewById(R.id.select);
        bt2 = findViewById(R.id.submit);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.select:


                //写真を選択したタイミングで、インテントされる。
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,response_code);

                break;


            case R.id.submit:

                database_helper = new Database_Helper(MainActivity.this);
                String method = "image_upload";
                database_helper.execute(method,img_name,encodeString);

                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode == response_code && resultCode == RESULT_OK){

            //インテントされて来た（写真を選んだタイミングで）写真データのURIを格納する

            uri = data.getData();
            //写真のデータ。名前とか、日付とかを配列に格納する。
            String[] filepathcolum = {MediaStore.Images.Media.DATA};

            //データのカーサーをセットする。URIと写真配列のデータをセット。他はNULL。
            Cursor cursor = getContentResolver().query(uri,filepathcolum,null,null,null);

            ////ストレージにある写真たちの中から、この写真の選択したときの、インデックスナンバーを入れる。
            int colum_index_num = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String image_path = cursor.getString(colum_index_num);
            Toast.makeText(getApplicationContext(),image_path,Toast.LENGTH_SHORT).show();
            Bitmap bitmap = BitmapFactory.decodeFile(image_path);
            iv1.setImageBitmap(bitmap);
            File f = new File(image_path);
            img_name = f.getName();
            Toast.makeText(getApplicationContext(),img_name,Toast.LENGTH_SHORT).show();
            ///encoding//

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
            byte[] imgarr = stream.toByteArray();
            encodeString = Base64.encodeToString(imgarr,0);



        }

    }





}
