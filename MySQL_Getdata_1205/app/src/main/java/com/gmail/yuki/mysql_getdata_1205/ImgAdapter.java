package com.gmail.yuki.mysql_getdata_1205;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by yuki on 2017/12/05.
 */

public class ImgAdapter extends ArrayAdapter<ImageData>{

    private Activity activity;
    private List<ImageData> list;
    private int row;
    private ImageData imageData;

    public ImgAdapter(Activity activity, int row, List<ImageData> list) {
        super(activity,row,list);
        this.activity = activity;
        this.row = row;
        this.list = list;
    }


    //ArrayAdapter#getView(int position, View convertView, ViewGroup parent)はカセットを表示する度に呼ばれ、
    //第２引数 convertView は一回生成したカセットのレイアウトを返却してくれる。
    //なのであらかじめ return する View にオブジェクトをタグ付けしておいて、再利用できるようにする。


    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        ViewHolder holder;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row,null);
            holder = new ViewHolder();
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        if ((list == null) || ((i+1)>list.size())){
            return view;
        }

        imageData = list.get(i);

        holder.id = view.findViewById(R.id.id);
        holder.name = view.findViewById(R.id.name);
        holder.imageView = view.findViewById(R.id.i);

        if (holder.id != null && imageData.getId() !=null){
            holder.id.setText(Html.fromHtml(imageData.getId()));
        }

        if (holder.name != null && imageData.getImg_name() != null){
            holder.name.setText(Html.fromHtml(imageData.getImg_name()));
        }

        if (holder.imageView != null && imageData.getImg_path() != null){
            Picasso.with(activity)
                    .load(imageData.getImg_path())
                    .resize(200,150)
                    .into(holder.imageView);
        }
        return view;
    }


    //findViewById ってコストが高い。
    //これを回避するのが ViewHolder パターン。

    class ViewHolder{
        TextView id, name;
        ImageView imageView;
    }
}
