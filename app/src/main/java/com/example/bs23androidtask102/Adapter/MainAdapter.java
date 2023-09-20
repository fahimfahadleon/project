package com.example.bs23androidtask102.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bs23androidtask102.Listener.MainAdapterItemClickListener;
import com.example.bs23androidtask102.Models.GithubItemModel;
import com.example.bs23androidtask102.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    ArrayList<MainAdapterItemClickListener> listeners = new ArrayList<>();

    List<GithubItemModel> models = new ArrayList<>();
    public void setItemClickListener(MainAdapterItemClickListener listener){
        listeners.add(listener);
    }

    void broadCastItemClickListener(GithubItemModel model){
        for(MainAdapterItemClickListener listener:listeners){
            listener.onItemClick(model);
        }
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_github_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        GithubItemModel model = models.get(position);

        holder.itemView.setOnClickListener(view -> broadCastItemClickListener(model));

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder{

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
