package com.example.dijonkariz.washme;

public class PackageItem {
    private String item_name;
//    private int item_pic;

    public PackageItem(){}

    public PackageItem(String name)
    {
        this.item_name = name;
//        this.item_pic = pic;
    }

    public String getName(){ return item_name;}
    public void setName(String name){ this.item_name = name;}

//    public int getPic(){ return item_pic;}
//    public void setPic(int pic){ this.item_pic = pic;}
}
