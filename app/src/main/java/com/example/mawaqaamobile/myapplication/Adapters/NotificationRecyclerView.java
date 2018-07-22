package com.example.mawaqaamobile.myapplication.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawaqaamobile.myapplication.R;

import java.util.zip.Inflater;

public class NotificationRecyclerView extends RecyclerView.Adapter<NotificationRecyclerView.ItemViewHolder> {
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item_list, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
