package com.example.platypie_darkboard.backend_communication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonDarkBoardAPI {

        @GET("location")
        Call<List<User>> getTestString();

}
