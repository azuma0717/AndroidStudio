package com.gmail.yuki.camera_1124;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1;
    ImageView iv1;
    static final int Camera_Request = 1;
    int b = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.button);
        iv1 = (ImageView)findViewById(R.id.image);

        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = getfile();
        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        startActivityForResult(camera_intent, Camera_Request);

    }



    private File getfile() {


        File folder = new File("sdcard/camera_app");

        if (!folder.exists()) {

            folder.mkdir();

        }

        File image_file = new File(folder, b + "camera_image.jpg");

        return image_file;


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        String path = "sdcard/camera_app/" + b + "camera_image.jpg";
        iv1.setImageDrawable(Drawable.createFromPath(path));
        b++;
    }


}


