package com.noonight.pc.postretrofit2.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.noonight.pc.postretrofit2.R;
import com.noonight.pc.postretrofit2.network.retrofit.ApiUtils;
import com.noonight.pc.postretrofit2.network.retrofit.model.SomeT;
import com.noonight.pc.postretrofit2.network.retrofit.service.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ShowSomeActivity extends AppCompatActivity {

    private TextView tvSomeOut;

    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_some);
        mAPIService = ApiUtils.getAPIService();
        init();
    }

    private void init() {
        tvSomeOut = (TextView) findViewById(R.id.tvSomeOut);
        getSomeData();
    }

    private void getSomeData() {
        mAPIService.getSomeT().enqueue(new Callback<List<SomeT>>() {
            @Override
            public void onResponse(Call<List<SomeT>> call, Response<List<SomeT>> response) {
                List<SomeT> someData = response.body();
                String details = "";
                for (int i = 0; i < someData.size(); i++) {
                    int number = someData.get(i).getNumber();
                    String text = someData.get(i).getText();
                    details +=
                            "Number: " + number + "\n" +
                                    "Text: " + text + "\n\n";
                }
                tvSomeOut.setText(details);
            }

            @Override
            public void onFailure(Call<List<SomeT>> call, Throwable t) {

            }
        });
    }
}
