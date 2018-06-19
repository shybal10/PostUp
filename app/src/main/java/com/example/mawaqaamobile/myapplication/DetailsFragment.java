package com.example.mawaqaamobile.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mawaqaamobile.myapplication.Adapters.CustomSwipeAdapter;
import com.example.mawaqaamobile.myapplication.Adapters.SpecificationsGridViewAdapter;
import com.example.mawaqaamobile.myapplication.UIUtils.UIUtils;

public class DetailsFragment extends Fragment {
    CustomSwipeAdapter customSwipeAdapter;
    ViewPager viewPager;
    LinearLayout slideDots;
    SpecificationsGridViewAdapter specificationsGridViewAdapter;
    GridView specificationGridView;
    ImageView call;
    private int dotsCount;
    private ImageView[] dots;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vehicle_details_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        call = (ImageView) view.findViewById(R.id.call_image);
        specificationGridView = (GridView) view.findViewById(R.id.specifications_gridview);
        specificationsGridViewAdapter = new SpecificationsGridViewAdapter(getActivity());
        specificationGridView.setAdapter(specificationsGridViewAdapter);
        UIUtils.setListViewHeightBasedOnItems(specificationGridView);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        customSwipeAdapter = new CustomSwipeAdapter(getActivity());
        viewPager.setAdapter(customSwipeAdapter);
        slideDots = (LinearLayout) view.findViewById(R.id.slider_dots);
        dotsCount = customSwipeAdapter.getCount();
        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bannerbullet));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            //layoutParams.setMargins(8,0,8,0);
            slideDots.addView(dots[i], layoutParams);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bannerbulletselect));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bannerbullet));

                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bannerbulletselect));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+34666777888";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);            }
        });

    }
}
