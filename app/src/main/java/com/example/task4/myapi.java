package com.example.task4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myapi {
@GET("api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true")
    Call<List<model>> getmodels();
}

