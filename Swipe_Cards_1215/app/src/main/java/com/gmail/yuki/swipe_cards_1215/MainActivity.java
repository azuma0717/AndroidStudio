package com.gmail.yuki.swipe_cards_1215;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private cards cards_data[];

    //↓自作アダプター
    private arrayAdapter arrayAdapter;
    Button bt1;
    FirebaseAuth mAuth;

    private String userSex;
    private String oppositeUserSex;


    private String currentUID;
    private DatabaseReference usersDb;


    ListView listView;
    //List<objects> 変数名 = new ArrayList<型>( );
    List<cards> rowItems;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //↓ここはコピペしたら自分のアクティビティ名に変える。
        setContentView(R.layout.activity_main);

        usersDb = FirebaseDatabase.getInstance().getReference().child("Users");

        bt1 = findViewById(R.id.logout);
        mAuth = FirebaseAuth.getInstance();
        currentUID = mAuth.getCurrentUser().getUid();


        //サインアウトボタン///
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
                return;

            }
        });

        ///////////////

        checkUserSex();

        //////////////

        //大きさが決まってない配列
        rowItems = new ArrayList<cards>();

        //引数に、このアクティビティ、itemレイアウト、rouItemsの配列を渡している。(arrayAdapterは、自作のアダプター)
        arrayAdapter = new arrayAdapter(this, R.layout.item,rowItems);

        //idと紐付け。
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView)findViewById(R.id.frame);


        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                rowItems.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                //↓デフォルトのトーストの文が、最新バージョンじゃないので自分で直す。

                cards obj = (cards)dataObject;
                String userId = obj.getUserID();
                usersDb.child(oppositeUserSex).child(userId).child("connections").child("nope").child(currentUID).setValue(true);

                Toast.makeText(getApplicationContext(),"Like!!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {


                cards obj = (cards)dataObject;
                String userId = obj.getUserID();
                usersDb.child(oppositeUserSex).child(userId).child("connections").child("yep").child(currentUID).setValue(true);

                Toast.makeText(getApplicationContext(),"Dislike!!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(getApplicationContext(),"Clicked!!!",Toast.LENGTH_SHORT).show();

            }
        });

    }

    //////////////////////////////////////////////////////////////////////////////////

    public void checkUserSex(){

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseReference maleDb = FirebaseDatabase.getInstance().getReference().child("Users").child("male");
        maleDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals(user.getUid())){

                    userSex = "male";
                    oppositeUserSex = "female";
                    getOppositeSexUsers();

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
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        DatabaseReference femaleDb = FirebaseDatabase.getInstance().getReference().child("Users").child("female");
        femaleDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().equals(user.getUid())){

                    userSex = "female";
                    oppositeUserSex = "male";
                    getOppositeSexUsers();

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
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    public void getOppositeSexUsers(){

        DatabaseReference oppositeSexDb = FirebaseDatabase.getInstance().getReference().child("Users").child(oppositeUserSex);
        oppositeSexDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.exists() && !dataSnapshot.child("connections").child("yep").hasChild(currentUID) && !dataSnapshot.child("connections").child("nope").hasChild(currentUID)){

                    //ここで、DBから情報を引っ張ってきてる
                    cards item = new cards(dataSnapshot.getKey() , dataSnapshot.child("name").getValue().toString());

                    rowItems.add(item);
                    arrayAdapter.notifyDataSetChanged();
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
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }


}