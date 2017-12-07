package com.gmail.yuki.users_login_withimgdata_1206;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button bt1,bt2,bt3,bt4,bt5;
    ImageView iv1;

    Uri uri;
    static final int Camera_Request = 1;
    String img_name;
    String encodedString;
    Bitmap bitmap;

    int response_code = 123;

    Database_Helper database_helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iv1 = findViewById(R.id.image);

        bt1 = findViewById(R.id.showall);
        bt2 = findViewById(R.id.allimg);
        bt3 = findViewById(R.id.camera);
        bt4 = findViewById(R.id.gallary);
        bt5 = findViewById(R.id.submit);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.showall:

                String method = "showall";
                database_helper = new Database_Helper(this);
                database_helper.execute(method);

                break;

            case R.id.allimg:

                method = "allimg";
                database_helper = new Database_Helper(this);
                database_helper.execute(method);

                break;

            case R.id.camera:

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getfile();
                uri = Uri.fromFile(file);
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startActivityForResult(camera_intent,Camera_Request);

                break;

            case R.id.gallary:

                ////写真を選択したタイミングで、インテントされる。
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, response_code);

                break;

            case R.id.submit:

                database_helper = new Database_Helper(Home.this);
                method = "Picture_Insert";

                database_helper.execute(method,img_name,encodedString);


                break;


        }

    }

//    ///////////////camera parat/////////////////////////////////

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
            bitmap = BitmapFactory.decodeFile(image_path);
            File f = new File(image_path);
            img_name = f.getName();

        }else {

             bitmap = BitmapFactory.decodeFile(uri.getPath());

        }

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

    ///////////////////




}
