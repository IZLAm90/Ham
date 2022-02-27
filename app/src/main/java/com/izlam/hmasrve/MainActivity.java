package com.izlam.hmasrve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.izlam.hmasrve.Adapters.CategoryAdapter;
import com.izlam.hmasrve.Adapters.LiveStreamAdapter;
import com.izlam.hmasrve.ApiService.RetrofitInstance;
import com.izlam.hmasrve.ApiService.SimpleApi;
import com.izlam.taskhamserv.Models.ModelCategory;
import com.izlam.taskhamserv.Models.live_streamsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private SimpleApi ApiInterface ;
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface= RetrofitInstance.getRetrofitInstance().create(SimpleApi.class);
        Call<ArrayList<ModelCategory>> call=ApiInterface.getcategory("hmaser","hmaserv1987","get_live_categories");
        call.enqueue(new Callback<ArrayList<ModelCategory>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelCategory>> call, Response<ArrayList<ModelCategory>> response) {
                Log.d("Call",response.body().toString());
                setRecyclerData(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<ModelCategory>> call, Throwable t) {
                Log.d("Faill",t.getMessage());
            }
        });

        FloatingActionButton btnn=findViewById(R.id.move);
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LiveStreamActivity.class));
            }
        });
    }



    private void setRecyclerData(ArrayList<ModelCategory> productsList) {
        recyclerView = findViewById(R.id.recyclerCategory);
        categoryAdapter = new CategoryAdapter(productsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

    }
}