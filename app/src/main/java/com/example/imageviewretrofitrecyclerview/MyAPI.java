package com.example.imageviewretrofitrecyclerview;

import android.view.Display;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {

    @GET("photos")
    Call<List<Model>> getModel();
}
