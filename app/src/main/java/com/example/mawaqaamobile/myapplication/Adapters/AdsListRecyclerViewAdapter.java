package com.example.mawaqaamobile.myapplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawaqaamobile.myapplication.R;

public class AdsListRecyclerViewAdapter extends RecyclerView.Adapter<AdsListRecyclerViewAdapter.ItemVieholder> {
    final private ListItemClickListener mOnClickListener;
    private Context context;

    public AdsListRecyclerViewAdapter(ListItemClickListener listItemClickListener, Context parent) {
        mOnClickListener = listItemClickListener;
        this.context = parent;
    }
    @NonNull
    @Override
    public ItemVieholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_list_recycler_view_item,parent,false);
        return new ItemVieholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVieholder holder, int position) {

    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ItemVieholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ItemVieholder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }
}
