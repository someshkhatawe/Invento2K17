package com.invento.somesh.invento2k17;

/**
 * Created by som on 21/03/2017.
 */

public class Blog {

    private String Title,Desc,image;
    public Blog(){}


    public Blog(String title, String Desc, String image) {
        this.Title = Title;
        this.Desc = Desc;
        this.image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {

        this.Title = Title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        this.Desc = Desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
