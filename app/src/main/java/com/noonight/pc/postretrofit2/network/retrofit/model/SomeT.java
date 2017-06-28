package com.noonight.pc.postretrofit2.network.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ayur on 26.06.2017.
 */

public class SomeT {

    @SerializedName("number")
    @Expose
    private Integer number;

    @SerializedName("text")
    @Expose
    private String text;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
