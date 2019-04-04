package com.example.opti.lab_01;

import android.graphics.Color;

public class Item {
    String str;
    int img;
    int color;

    public Item(String str, int img){
        this.img = img;
        this.str = str;
        this.color = Color.WHITE;
    }
    public Item(String str, int img, int color){
        this.img = img;
        this.str = str;
        this.color = color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
