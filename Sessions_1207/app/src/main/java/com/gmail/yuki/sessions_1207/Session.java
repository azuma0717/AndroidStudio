package com.gmail.yuki.sessions_1207;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yuki on 2017/12/07.
 */

public class Session {

//    SharedPreferencesはアプリの設定データをデバイス内に保存するための仕組み。XML形式で保存される。
//    Acitivityが破棄されてもCommitさえされていれば保存されている
//    キー・バリュー形式で保存され、主にテキストや数値の保存を得意とする

//    今回の処理を上から順に説明します。
//            ・インスタンスの取得をまず行う。（今回はContext.MODE_PRIVATEです。）
//            ・SharedPreferences.Editorオブジェクトを取得。
//            　これらのオブジェクトには
//　　・PutInt
//　　・PutString
//　　　　　...etc
//　などのメソッドを使ってデータの保存をすることができます。
//            　今回は"LevelSave"に１を保存しています。もちろん変数も使えます。
//            ・そしてapply()します。これでデータを反映させています。

    SharedPreferences sharedPreferences;
    Context context;
    String session_name;
    SharedPreferences.Editor editor;

    Session(Context context, String session_name){
        this.session_name = session_name;
        this.context = context;
//        　　　　　　　　　　　　　　　　　　　　　　　　　（"設定データの名前",ファイル操作のモード)
        sharedPreferences= context.getSharedPreferences(session_name,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        ///「Context.MODE_PRIVATE」はそのアプリでのみアクセス可能なデータの生成、「Context.MODE_MULTI_PROCESS」は複数のプロセスが作ったデータに対してアクセスが可能な状態なデータを作る。

    }

    public String getName(String key) {

        return sharedPreferences.getString(key,null);
    }

    public void setName(String key, String value) {

        editor.putString(key,value);
//        editor.apply();　保存

//      コミットも保存かな？setter getter使ってたら、いらないかも。。
        editor.commit();
    }

}
