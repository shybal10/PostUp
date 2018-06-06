package com.example.mawaqaamobile.myapplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawaqaamobile.myapplication.R;

public class FavsListRecyclerViewAdapter extends RecyclerView.Adapter<FavsListRecyclerViewAdapter.ItemViewHolder> {
    final private ListItemClickListener mOnClickListener;

    private Context context;
    public FavsListRecyclerViewAdapter(ListItemClickListener listItemClickListener, Context parent) {
        mOnClickListener = listItemClickListener;
        this.context = parent;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourites_list_view,parent,false);
        return new ItemViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
