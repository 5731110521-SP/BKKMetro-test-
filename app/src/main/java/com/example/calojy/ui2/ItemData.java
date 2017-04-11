package com.example.calojy.ui2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItemData extends AppCompatActivity {

    String text;
    Integer imageId;
    public ItemData(String text, Integer imageId){
        this.text=text;
        this.imageId=imageId;
    }

    public String getText(){
        return text;
    }

    public Integer getImageId(){
        return imageId;
    }
}
