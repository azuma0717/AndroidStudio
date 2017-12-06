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

                ////startActivityForResult と返ってくるリクエストコードを設定。ここでは、Camera_Request = 1
                //リザルトの時にif文とかでリクエストコードとリザルトコードを照合させたりして、使い分ける。
                //返ってきたときに受け取りは、onActivityResult で受け取る
                startActivityForResult(camera_intent, Camera_Request);

                //startActivity(camera_intent);を使うと、リクエストが返ってこないので、
                //ただカメラが起動して、写真とるだけになる。撮った写真をどうするかどうかは、Resultを返してもらう必要あり。

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


        //////パプブリックなフォルダを作成する。DIRECTORY_PICTURES、はPICTURESフォルダを意味する。その配下にHelloフォルダができる。
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Hello");

        if (!folder.exists()) {


            folder.mkdir();

        }

        //////現在の時間を取得する。フォーマットも決める。Locale.getDefaultでOSの言語を設定する。最後にフォーマットを指定。
        //////イメージファイルの名前の付け方をここで決める。File.separatorは、区切りの「/」を表す。
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File image_file = new File(folder + File.separator + "IMG_" + time + ".jpg");
        img_name = "IMG_" + time + ".jpg";
        return image_file;


    }


    //startActivityForResultの結果の受け取り
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());

        iv1.setImageBitmap(bitmap);


        ///Bitmapオブジェクトをbyte配列に変換する。
        //まずは、オブジェクトを生成する
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //stream には、圧縮したビットストリームを流し込む先を指定
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imgArr = stream.toByteArray();
        //サーバーに画像のデータを送る場合にBASE64エンコードしてStringとして送る
        encodedString = Base64.encodeToString(imgArr, 0);

    }

    ///////////////////////////////////////////////////////////////////////////////////

}
