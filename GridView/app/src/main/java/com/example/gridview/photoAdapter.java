package com.example.gridview;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class photoAdapter extends RecyclerView.Adapter<photoAdapter.PhotoViewHolder> {
    private List<photo> mlist = new ArrayList<>();

    public PhotoAdapter (List<photo> mlist)
        this.mlist= mlist;
    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PhotoViewHolder extends  RecyclerView.ViewHolder{

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
