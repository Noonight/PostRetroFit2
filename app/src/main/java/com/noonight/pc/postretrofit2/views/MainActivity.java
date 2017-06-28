package com.noonight.pc.postretrofit2.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.noonight.pc.postretrofit2.R;
import com.noonight.pc.postretrofit2.network.retrofit.ApiUtils;
import com.noonight.pc.postretrofit2.network.retrofit.model.SomeT;
import com.noonight.pc.postretrofit2.network.retrofit.service.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private EditText etText;
    private Button btnSend;

    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        etNumber = (EditText) findViewById(R.id.etNumber);
        etText = (EditText) findViewById(R.id.etText);
        btnSend = (Button) findViewById(R.id.btnSend);

        mAPIService = ApiUtils.getAPIService();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(Integer.parseInt(etNumber.getText().toString().trim()), etText.getText().toString().trim());
            }
        });
    }

    private void insert(int number, String text) {
        mAPIService.insertSomeT(number, text).enqueue(new Callback<SomeT>() {

            @Override
            public void onResponse(Call<SomeT> call, Response<SomeT> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this,
                            etNumber.getText().toString() + " " + etText.getText().toString(),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }

            @Override
            public void onFailure(Call<SomeT> call, Throwable t) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        /*MenuItem menuItem = menu.add(0, 1, 0, "Setting");
        menuItem.setIntent(new Intent(this, SettingFragment.class));*/
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menuShowSomeActivity:
                intent = new Intent(this, ShowSomeActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuShowSetting:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //return super.onOptionsItemSelected(item);
    }
}
