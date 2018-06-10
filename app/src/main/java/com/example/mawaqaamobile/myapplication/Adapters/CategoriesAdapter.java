package com.example.mawaqaamobile.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mawaqaamobile.myapplication.R;

public class CategoriesAdapter extends BaseAdapter  {
    Context mcontext;

    public CategoriesAdapter(Context context) {
        super();
        mcontext = context;
    }

    @Override
    public int getCount() {
        return 12;
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
            imageView = inflater.inflate(R.layout.category_image_list, null);

/*
            final RelativeLayout relativeLayout = (RelativeLayout) imageView.findViewById(R.id.image_bg);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    relativeLayout.setBackgroundResource(R.drawable.button_click);
                }
            });
*/

            //ImageView image = (ImageView) imageView.findViewById(R.id.imageView1);
        }
        else {

            imageView = (View) convertView;
           /* final RelativeLayout relativeLayout = (RelativeLayout) imageView.findViewById(R.id.image_bg);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    relativeLayout.setBackgroundResource(R.drawable.button_click);
                }
            });
*/
        }
        return imageView;
    }
}
