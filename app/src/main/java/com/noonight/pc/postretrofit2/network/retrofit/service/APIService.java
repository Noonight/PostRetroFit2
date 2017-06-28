package com.noonight.pc.postretrofit2.network.retrofit.service;

import com.noonight.pc.postretrofit2.database.tables.SomeTableContract;
import com.noonight.pc.postretrofit2.network.retrofit.model.SomeT;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ayur on 26.06.2017.
 */

public interface APIService {

    @GET("/someT")
    Call<List<SomeT>> getSomeT();

    @POST("/someT/insertSomeT.php")
    @FormUrlEncoded
    Call<SomeT> insertSomeT(
            @Field(SomeTableContract.SomeTable.COLUMN_NAME_NUMBER) Integer number,
            @Field(SomeTableContract.SomeTable.COLUMN_NAME_TEXT) String text
    );
}
