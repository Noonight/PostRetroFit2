package com.noonight.pc.postretrofit2.views.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import com.noonight.pc.postretrofit2.R;


/**
 * Created by ayur on 26.06.2017.
 */

public class SettingFragmanet extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
    }
}
