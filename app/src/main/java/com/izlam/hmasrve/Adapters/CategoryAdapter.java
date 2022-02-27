package com.izlam.hmasrve.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.izlam.hmasrve.R;
import com.izlam.taskhamserv.Models.ModelCategory;
import com.izlam.taskhamserv.Models.live_streamsModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private ArrayList<ModelCategory> model;

    public CategoryAdapter(ArrayList<ModelCategory> model){
        this.model=model;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_catogory, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.name.setText(model.get(position).getCategory_name());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView name, id;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.category_name);
            id=itemView.findViewById(R.id.category_id);
        }
    }
}
