package com.izlam.hmasrve.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.izlam.hmasrve.R;
import com.izlam.taskhamserv.Models.live_streamsModel;

import java.util.ArrayList;

public class LiveStreamAdapter extends RecyclerView.Adapter<LiveStreamAdapter.LiveViewHolder>{

    private ArrayList<live_streamsModel> model;
    private Context context;

    public LiveStreamAdapter(ArrayList<live_streamsModel> model,Context context){
        this.model=model;
        this.context=context;
    }
    @NonNull
    @Override
    public LiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_livestream, parent, false);
        return new LiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveViewHolder holder, int position) {
        Glide.with(context).load(model.get(position).getStream_icon()).into(holder.Icon);
        holder.id.setText(model.get(position).getCategory_id());
        holder.name.setText(model.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class LiveViewHolder extends RecyclerView.ViewHolder {
        ImageView Icon;
        TextView name, id;

        public LiveViewHolder(@NonNull View itemView) {
            super(itemView);

            Icon=itemView.findViewById(R.id.ic_stream);
            name=itemView.findViewById(R.id.title);
            id=itemView.findViewById(R.id.category_id);
        }
    }
}
