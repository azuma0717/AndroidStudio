package com.gmail.yuki.mysql_getdata_1205;

/**
 * Created by yuki on 2017/12/05.
 */

public class ImageData {
    String id, img_name,img_path;

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }
}
