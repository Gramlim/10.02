package com.example.myapplication;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Interface {
    @POST("api/signup")
    Call<User> basicAuth (@Body User user);
}
