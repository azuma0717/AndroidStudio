package com.example.toki.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by toki on 2017/12/11.
 */

public class Fragment3 extends Fragment implements View.OnClickListener {

    private Button btnNavFragment1,btnNavFragment2,btnNavFragment3,btnNavSecondActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment3_layout,container,false);
        btnNavFragment1 = view.findViewById(R.id.btnNavFragment1);
        btnNavFragment2 = view.findViewById(R.id.btnNavFragment2);
        btnNavFragment3 = view.findViewById(R.id.btnNavFragment3);
        btnNavSecondActivity = view.findViewById(R.id.btnNavSecondActivity);

        btnNavFragment1.setOnClickListener(this);
        btnNavFragment2.setOnClickListener(this);
        btnNavFragment3.setOnClickListener(this);
        btnNavSecondActivity.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNavFragment1:
                Toast.makeText(getActivity(), "going to fragment1", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(0);
                break;

            case R.id.btnNavFragment2:
                Toast.makeText(getActivity(), "going to fragment2", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(1);
                break;
            case R.id.btnNavFragment3:
                Toast.makeText(getActivity(), "going to fragment3", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(2);
                break;
            case R.id.btnNavSecondActivity:
                Toast.makeText(getActivity(), "going to Second Activity", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
