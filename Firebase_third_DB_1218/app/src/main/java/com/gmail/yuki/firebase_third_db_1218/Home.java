package com.gmail.yuki.firebase_third_db_1218;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class Home extends AppCompatActivity implements ValueEventListener,ChildEventListener {

    TextView tv1,tv2,tv3,tv4;
    ImageView iv1;
    FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mRootReference = firebaseDatabase.getReference();
    DatabaseReference mUser = mRootReference.child("name");
    DatabaseReference Users;
    final private int CHOOSE_IMAGE = 101;
    Uri uriProfileImage;
    String profileImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv1 = findViewById(R.id.text1);
        tv2 = findViewById(R.id.text2);
        tv3 = findViewById(R.id.text3);
        tv4 = findViewById(R.id.text4);
        iv1 = findViewById(R.id.image);


        mAuth = FirebaseAuth.getInstance();


        //↓ログイン状態のユーザーをゲット
        user = mAuth.getCurrentUser();
        //↓Users配下のUidをゲットする。
        Users = mRootReference.child("Users").child(user.getUid());

        //↓ここは、Authenticationから取ってきてる。///
        tv1.append(user.getDisplayName());


    }


    ///onStart()の中に入れなくても動く。
    @Override
    protected void onStart() {
        super.onStart();

        //親直下のデータを取得する
        mUser.addValueEventListener(this);

        //子のデータを取得する。
        Users.addChildEventListener(this);

    }


    ////////////ValueEventListenerのオーバーライド2つ//////////////

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        String key = dataSnapshot.getKey();

        if(key.equals("name")){

            String name = dataSnapshot.getValue(String.class);
            tv2.setText(name);

        }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }


    ////////////ChildEventListenerのオーバーライド4つ////////////////

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

        String key = dataSnapshot.getKey();

        if (key.equals("email")) {
            String email = dataSnapshot.getValue(String.class);
            tv3.setText(email);
        }
        if (key.equals("phone")) {
            String phone = dataSnapshot.getValue(String.class);
            tv4.setText(phone);
        }
        if (key.equals("photo")) {
            String photo = dataSnapshot.getValue(String.class);

            Glide.with(this)
                    .load(Uri.parse(photo.toString()))
                    .into(iv1);
        }


    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    ////////////////////////////////////////////////////////////






}
