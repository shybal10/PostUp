package com.example.mawaqaamobile.myapplication.Adapters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mawaqaamobile.myapplication.R;

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] images = {R.drawable.vehicles,R.drawable.vehicles,R.drawable.vehicles};
    private Context context;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter(Context context) {
        this.context = context;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.slide_images);
        imageView.setImageResource(images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }
}
