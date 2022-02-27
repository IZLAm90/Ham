package com.izlam.hmasrve.ApiService;

import com.izlam.hmasrve.Adapters.CategoryAdapter;
import com.izlam.taskhamserv.Models.ModelCategory;
import com.izlam.taskhamserv.Models.live_streamsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SimpleApi {

    @GET("player_api.php")
    Call<ArrayList<ModelCategory>> getcategory(@Query("username" ) String username,@Query("password") String password,@Query("action") String action );

    @GET("player_api.php")
    Call<ArrayList<live_streamsModel>> getliveStream(@Query("username" ) String username,@Query("password") String password,@Query("action") String action );



}
