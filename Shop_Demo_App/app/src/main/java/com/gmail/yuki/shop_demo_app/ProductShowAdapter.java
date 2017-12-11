package com.gmail.yuki.shop_demo_app;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yuki on 2017/12/08.
 */

public class ProductShowAdapter extends ArrayAdapter<ProductData> {

    private Activity activity;
    private List<ProductData> list;
    private int row;
    private ProductData productData;

    public ProductShowAdapter(Activity activity, int row, List<ProductData> list) {
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

        productData = list.get(i);

        holder.name = view.findViewById(R.id.name);
        holder.price = view.findViewById(R.id.price);
        holder.imageView = view.findViewById(R.id.image);

        if (holder.name != null && productData.getName() != null){
            holder.name.setText(Html.fromHtml(productData.getName()));
        }

        if (holder.price != null && productData.getPrice() !=null){
            holder.price.setText(Html.fromHtml(productData.getPrice()));
        }

        if (holder.imageView != null && productData.getImg() != null){
            Picasso.with(activity)
                    .load(productData.getImg())
                    .resize(200,150)
                    .into(holder.imageView);
        }
        return view;
    }


    //findViewById ってコストが高い。
    //これを回避するのが ViewHolder パターン。

    class ViewHolder{
        TextView price, name;
        ImageView imageView;
    }
}
