package com.gmail.yuki.fragment_second_1213;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */

//フラグメントに必要なのは、Fragmentの継承と、それに表示するレイアウト
//空のコンストラクターが必要
public class MyFragment1 extends Fragment {


    public MyFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        //ボタンのクリックリスナーがなければ、inflaterをreturnしてOK
        View view =  inflater.inflate(R.layout.fragment_my_fragment1, container, false);

        view.findViewById(R.id.Button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new MyFragment2();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.contents,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;

    }

}
