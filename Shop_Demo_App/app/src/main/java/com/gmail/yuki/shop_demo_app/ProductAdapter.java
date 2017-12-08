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

import java.util.List;

/**
 * Created by yuki on 2017/12/08.
 */

public class ProductAdapter extends ArrayAdapter<ProductData> {

    private Activity activity;
    private List<ProductData> list;
    private int row;
    private ProductData productData;

    public ProductAdapter(Activity activity, int row, List<ProductData> list) {
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

        holder.cname = view.findViewById(R.id.cname);



        if (holder.cname != null && productData.getCname() !=null){
            holder.cname.setText(Html.fromHtml(productData.getCname()));
        }

        return view;
    }


    //findViewById ってコストが高い。
    //これを回避するのが ViewHolder パターン。

    class ViewHolder{
        TextView cname;
    }
}
