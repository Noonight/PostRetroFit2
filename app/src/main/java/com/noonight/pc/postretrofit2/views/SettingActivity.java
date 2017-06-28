package com.noonight.pc.postretrofit2.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.noonight.pc.postretrofit2.views.fragments.SettingFragmanet;


public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_setting);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingFragmanet()).commit();
    }
}
