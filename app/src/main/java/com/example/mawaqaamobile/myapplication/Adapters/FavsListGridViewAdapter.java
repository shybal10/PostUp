package com.example.mawaqaamobile.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mawaqaamobile.myapplication.R;

public class FavsListGridViewAdapter extends BaseAdapter {
    Context mcontext;
    public FavsListGridViewAdapter(Context context) {

        super();
        mcontext = context;
    }
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View imageView;
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            // if it's not recycled, initialize some attributes
            imageView = new View(mcontext);
            imageView = inflater.inflate(R.layout.favourites_grid_view, null);
            //ImageView image = (ImageView) imageView.findViewById(R.id.imageView1);


        }
        else {

            imageView = (View) convertView;

        }
        return imageView;    }
}
