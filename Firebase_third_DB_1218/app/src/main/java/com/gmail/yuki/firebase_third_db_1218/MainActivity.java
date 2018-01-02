package com.gmail.yuki.firebase_third_db_1218;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed1, ed2, ed3, ed4;
    Button bt1, bt2;
    ImageView iv1;
    FirebaseAuth mAuth;
    final private int CHOOSE_IMAGE = 101;
    Uri uriProfileImage;
    String profileImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.email);
        ed4 = findViewById(R.id.pass);
        bt1 = findViewById(R.id.register);
        bt2 = findViewById(R.id.login);
        iv1 = findViewById(R.id.image);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        iv1.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.register:

                registerUser();

                break;


            case R.id.login:

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

                break;

            case R.id.image:

                showImageChooeser();

        }
    }


    private void registerUser() {

        final String name = ed1.getText().toString();
        final String phone = ed2.getText().toString();
        final String email = ed3.getText().toString();
        final String pass = ed4.getText().toString();

        //バリデーションチェック/////////////
        if (name.isEmpty()) {
            ed1.setError("name required");
            ed1.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            ed2.setError("phone required");
            ed2.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            ed3.setError("phone required");
            ed3.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            ed4.setError("pass required");
            ed4.requestFocus();
            return;
        }
        ///////////////////////////////////


        //↓で　Authenticationsにアドレスとパスワードを登録する
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //↑の結果がサクセスなら、カレントユーザーを取得して、名前と電話とアドレスとパスワードをDBに登録する。
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();

                            String userId = mAuth.getCurrentUser().getUid();

                            DatabaseReference currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("name");
                            currentUserDb.setValue(name);

                            currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("phone");
                            currentUserDb.setValue(phone);

                            currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("email");
                            currentUserDb.setValue(email);

                            currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("pass");
                            currentUserDb.setValue(pass);

                            currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("photo");
                            currentUserDb.setValue(profileImageUrl);

                            //まずはインスタンス作って、Authenticationにセットする。DBとは別で登録しておく。これはおまけ。
                            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(name)
                                    .setPhotoUri(Uri.parse(profileImageUrl))
                                    .build();

                            //こっちでアップデート
                            user.updateProfile(profile);


                            Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();


                            //既に登録済みのメールアドレスは、ここで検知してはじく
                        } else if (task.getException() instanceof FirebaseAuthUserCollisionException) {

                            Toast.makeText(getApplicationContext(), "Already Registered...", Toast.LENGTH_SHORT).show();

                        } else {

                            //それ以外の例外をここで検知して弾く。（アドレスとパスワードのルール）
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });

    }

    ////////////////////画像が押された時に発動////////////////////

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


                //ここでFirebaseに格納している。
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


            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    /////////////////////////////////////////////////////////////////////


}
