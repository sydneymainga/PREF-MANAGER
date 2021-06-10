package com.example.sydneyuser;

import com.example.sydneyuser.Request.LoginRequest;
import com.example.sydneyuser.Request.RegisterRequest;
import com.example.sydneyuser.Response.LoginResponse;
import com.example.sydneyuser.Response.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("authenticate/")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);


    @POST("users/")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);
}
