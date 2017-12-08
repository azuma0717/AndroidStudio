package com.gmail.yuki.shop_demo_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class CreateProducts extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener {


    EditText ed1, ed2;
    Button bt1, bt2,bt3;
    Spinner sp1;
    ImageView iv1;
    int x;
    int response_code = 123;
    Uri uri;
    String img_name;
    String encodeString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_products);

        ed1 = findViewById(R.id.pname);
        ed2 = findViewById(R.id.price);
        sp1 = findViewById(R.id.spinner);
        bt1 = findViewById(R.id.submit);
        bt2 = findViewById(R.id.back);
        bt3 = findViewById(R.id.select);
        iv1 = findViewById(R.id.image);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        Intent intent = getIntent();
        String[] products = intent.getExtras().getStringArray("categorydata");

        ArrayAdapter<?> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, products);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(this);



    }

    /////////////////////////Method of Spinner/////////////////////////////////////


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        x = i+1;


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    ////////////////////////click part ////////////////////////////////////////////

    @Override
    public void onClick(View v ) {

        switch (v.getId()){

            case R.id.submit:

                String name = ed1.getText().toString();
                String price = ed2.getText().toString();
                String cid = String.valueOf(x);
                String img = encodeString;

                break;


            case R.id.back:

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                break;

            case R.id.select:

                ////写真を選択したタイミングで、インテントされる。
                intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, response_code);

                break;

        }
    }

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
//            File f = new File(image_path);
//            img_name = f.getName();

            //////////////Encoding to Base64/////////////////////////////////////////////

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] imgarr = stream.toByteArray();
            encodeString = Base64.encodeToString(imgarr, 0);

        }

    }
    ////////////////////////////////////////////////////////////////
}
