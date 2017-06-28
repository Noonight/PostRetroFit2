package com.noonight.pc.postretrofit2.network.retrofit;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.noonight.pc.postretrofit2.network.retrofit.service.APIService;
import com.noonight.pc.postretrofit2.views.SettingActivity;


/**
 * Created by ayur on 26.06.2017.
 */

public class ApiUtils {
    //private static String BASE_URL = "http://192.168.3.66/";
    public static final String BASE_URL = "http://10.0.2.2/";

    private ApiUtils() {}

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
