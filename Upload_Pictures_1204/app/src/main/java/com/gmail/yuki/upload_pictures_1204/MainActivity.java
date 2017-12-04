package com.gmail.yuki.upload_pictures_1204;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv1;
    Button bt1, bt2;
    static final int Camera_Request = 1;
    int b = 1;
    Uri uri;
    String encodedString;
    String img_name;

    Database_Helper database_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv1 = findViewById(R.id.image);
        bt1 = findViewById(R.id.camera);
        bt2 = findViewById(R.id.submit);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);



    }

    ////////////////////  click listener part /////////////////////////////////////////

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.camera:

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getfile();
                uri = Uri.fromFile(file);
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(camera_intent, Camera_Request);

                break;


            case R.id.submit:
                database_helper = new Database_Helper(MainActivity.this);
                String method = "image_upload";
                database_helper.execute(method,img_name,encodedString);


                break;


        }

    }

    ////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////camera function part////////////////////////////////

    private File getfile() {


        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Hello");

        if (!folder.exists()) {


            folder.mkdir();

        }

        String time = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File image_file = new File(folder + File.separator + "IMG_" + time + ".jpg");
        img_name = "IMG_" + time + ".jpg";
        return image_file;


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());

        iv1.setImageBitmap(bitmap);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imgArr = stream.toByteArray();
        encodedString = Base64.encodeToString(imgArr, 0);


    }

    ///////////////////////////////////////////////////////////////////////////////////

}
