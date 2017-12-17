package com.gmail.yuki.firebase_second_userinfo_1217;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.net.URI;

public class UserInfo extends AppCompatActivity {

    ImageView iv1;
    EditText ed1;
    Button bt1,bt2;
    final private int CHOOSE_IMAGE = 101;
    Uri uriProfileImage;
    String profileImageUrl;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        iv1 = findViewById(R.id.image);
        ed1 = findViewById(R.id.name);
        bt1 = findViewById(R.id.button);
        bt2 = findViewById(R.id.signout);

        mAuth = FirebaseAuth.getInstance();


        //画像をクリックしたら、発動
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showImageChooeser();

            }
        });


        loadUserInfomation();


        //ユーザー情報をセーブするボタン
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveUserInfomation();

            }
        });


        //sign outボタン
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                Toast.makeText(getApplicationContext(),"See you again",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);


            }
        });


    }


    /////////ログインしているユーザーがいなかったら、強制的にログイン前の画面に戻す。//////////////////////////////////
    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() == null) {


            finish();
            startActivity(new Intent(getApplicationContext(), com.gmail.yuki.firebase_second_userinfo_1217.MainActivity.class));

        }
    }


    /////////////////Authenticationに登録されているユーザープロフィールをゲットする/////////////////////////////////
    /////////////////ユーザープロフィール写真と名前、あと電話番号とメールアドレスとかは引っ張れるっぽい。////////////////

    private void loadUserInfomation() {

        //現在ログインしているユーザーをゲットする//
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {


            //アップロードしている画像を引っ張って、ImageViewに貼る。
            //Glideを使うのでライブラリとかは予めgradleに入れておく。
            if (user.getPhotoUrl() != null) {

                Glide.with(this)
                        .load(user.getPhotoUrl().toString())
                        .into(iv1);


            }

            //dhisplayNameも取ってこれる。
            if (user.getDisplayName() != null) {
                ed1.setText(user.getDisplayName());

            }

        }

    }

    //////////////////ボタンが押された時に発動させる保存メソッド////////////////////////////////
    /////////////////ここではディスプレイネームと写真のURLを格納している////////////////////////

    private void saveUserInfomation() {

        String displayName = ed1.getText().toString();

        //バリデーションチェック
        if (displayName.isEmpty()) {

            ed1.setError("name required");
            ed1.requestFocus();
            return;

        }

        FirebaseUser user = mAuth.getCurrentUser();


        if (user != null && profileImageUrl != null) {

            //まずはインスタンス作って、セットする。ちなみに.setは名前と写真URLしかない。。まぁいいけど。
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)
                    .setPhotoUri(Uri.parse(profileImageUrl))
                    .build();

            //実際にアップデートしてるのはこっち。上で作ったインスタンスをupdateしてる。
            user.updateProfile(profile)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {

                                Toast.makeText(getApplicationContext(), "Profile Updated", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

        }

    }

    ////////////////////画像が押された時に発動/////////////////////////////////////////////////////////////
    ////////////////////ストレージアクセスへのパーミッションが無い。。////////////////////////////////////////
    ////////////////////


    private void showImageChooeser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Profile Image"), CHOOSE_IMAGE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            //渡されたデータ（Uri）を格納。
            uriProfileImage = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uriProfileImage);
                iv1.setImageBitmap(bitmap);

                //ここでFirebaseに格納している。メソッドの内容は下に書いてる。
                uploadImageToFirebasestorage();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////uriを格納して、その画像を読み込んで画像ごとアップロードしているようにみえる。////////////////////
    ////////////////お決まりの、サクセスの結果はトーストじゃなくて、ダウンロードURLを取得して、profileImageUrlに格納している。
    ////////////////profileImageUrlは、goボタンが押された時、displaynameと一緒に格納される。///////////////////////////


    private void uploadImageToFirebasestorage() {

        StorageReference profileImageRef = FirebaseStorage.getInstance().getReference("profilepics/" + System.currentTimeMillis() + ".jpg");

        if (uriProfileImage != null) {

            profileImageRef.putFile(uriProfileImage)

                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            profileImageUrl = taskSnapshot.getDownloadUrl().toString();

                        }
                    })

                    //////失敗したらエラーを吐くように設定。

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////



}
