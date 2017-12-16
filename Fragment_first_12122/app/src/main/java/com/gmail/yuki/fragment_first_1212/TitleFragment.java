package com.gmail.yuki.fragment_first_1212;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by yuki on 2017/12/12.
 */


//好きなクラスの名前をつけて、フラグメントを継承させる。
//今回は、リストフラグメントを継承させる。リストビュー使いたいので。

public class TitleFragment extends ListFragment {

//    空のコンストラクタを作成するのがルール。

    public TitleFragment() {
    }

    public final static String EXTRA_POSITION = "com.gmail.yuki.fragment_first_1212.POSITION";

    private OnTitleSelectedListener listener;

    private boolean isDualPane;
    private int savedPosition;


    public interface OnTitleSelectedListener {

        public void onTitleSelected(int position);
    }

    //FragmentがActivityと関連づけられた時に、呼び出される。（ここにActivityが渡される。）
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

            listener = (OnTitleSelectedListener) activity;

        } catch (ClassCastException e) {

            throw new ClassCastException(activity.toString()
                    + "must impiment OnTitleSelected");
        }
    }


//    FragmentがActivityからの関連を覗かれた時に呼び出される
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

//    MainActivityが作られたら、処理が実行されるメソッド。
//    onCreateメソッドからリターンされた時に呼び出される。
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        デフォルトのアダプターを使って、配列をリストアダプターにセットする。
//        このフラグメントのアクティビティに表示させたいので、
// 　　　　１個目はgetActivityを使う、２個目は、使うレイアウト。（今回はデフォルトで用意されたやつ）、３個目は使う配列。

        setListAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                News.Titles
        ));

        View detailFrame = getActivity().findViewById(R.id.detailFrame);
        isDualPane = detailFrame != null && detailFrame.getVisibility() == View.VISIBLE;

        if(isDualPane){

            if(savedInstanceState != null){

                savedPosition = savedInstanceState.getInt("saved_position");

            }else{

                savedPosition = 0;

            }

            listener.onTitleSelected(savedPosition);


        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("saved_position",savedPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        savedPosition = position;

        //横画面なら、リスナーにポジションをセットして表示、
        //たて画面なら、インテントしてサブアクティビティに飛ばす。タップされたポジションも渡してやる。

        if (isDualPane) {

            listener.onTitleSelected(position);


        } else {
            Intent intent = new Intent(getActivity(), SubActivity.class);
            intent.putExtra(EXTRA_POSITION, position);
            startActivity(intent);

        }
    }
}

