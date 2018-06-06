package com.example.mawaqaamobile.myapplication.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mawaqaamobile.myapplication.R;

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter<MessageRecyclerViewAdapter.ItemViewHolder> {


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_list,parent,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView senderName,dateSent,message;
        ImageView imageView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            senderName = (TextView) itemView.findViewById(R.id.sender_name_text);
            dateSent = (TextView) itemView.findViewById(R.id.date_sent_text);
            message = (TextView) itemView.findViewById(R.id.sender_message_text);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
