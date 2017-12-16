package com.gmail.yuki.fragment_first_1212;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yuki on 2017/12/12.
 */

public class DetailFragment extends Fragment {

    public DetailFragment(){}


///////タップされた Title に応じて Fragment のインスタンスを動的に作っていく。
///////コンストラクタに引数を渡してはいけないというルールがあるため、
///////動的にインスタンスを作るための静的なメソッドを作っていく必要ある。
///////newInstance() というメソッドを作って、何番目がタップされたかということが position で渡ってくるようにする。
///////パラメータを渡したい場合は、 Bundle型で渡すルール。
///////ここらへんは、ほぼ決まり文句。

    public static DetailFragment newInstance(int position){

        // detailFragment を引数なしのコンストラクタでインスタンスを作る
        DetailFragment detailFragment = new DetailFragment();
        //渡ってきたデータをdetailFragmentに当てはめるには、Bundle型をつかわないといけない。
        Bundle args = new Bundle();
        //キーと、渡す値を入れる。今回はint型。
        args.putInt("position",position);
        //detailFragmentにargをセットしてやる。そいで、リターンで返す。
        detailFragment.setArguments(args);
        return  detailFragment;

    }


    //  フラグメントを継承した場合、ほぼこれを使う。xmlファイルをviewに変換する。
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View detailView = inflater.inflate(R.layout.view_detail,container,false);
        ((TextView)detailView.findViewById(R.id.detailText)).setText(News.Details[getArguments().getInt("position")]);

        return  detailView;



    }
}
