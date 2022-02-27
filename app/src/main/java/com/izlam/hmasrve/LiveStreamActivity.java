package com.izlam.hmasrve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.izlam.hmasrve.Adapters.LiveStreamAdapter;
import com.izlam.hmasrve.ApiService.RetrofitInstance;
import com.izlam.hmasrve.ApiService.SimpleApi;
import com.izlam.taskhamserv.Models.ModelCategory;
import com.izlam.taskhamserv.Models.live_streamsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveStreamActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LiveStreamAdapter liveStreamAdapter;
    private SimpleApi ApiInterface ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream);
        ApiInterface= RetrofitInstance.getRetrofitInstance().create(SimpleApi.class);
        Call<ArrayList<live_streamsModel>> call=ApiInterface.getliveStream("hmaser","hmaserv1987","get_live_streams");
        call.enqueue(new Callback<ArrayList<live_streamsModel>>() {
            @Override
            public void onResponse(Call<ArrayList<live_streamsModel>> call, Response<ArrayList<live_streamsModel>> response) {
            setRecyclerData(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<live_streamsModel>> call, Throwable t) {

            }
        });

    }




    private void setRecyclerData(ArrayList<live_streamsModel> productsList) {
        recyclerView = findViewById(R.id.recyclerLivestream);
        liveStreamAdapter = new LiveStreamAdapter(productsList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(liveStreamAdapter);
        liveStreamAdapter.notifyDataSetChanged();

    }
}