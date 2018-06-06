package com.example.mawaqaamobile.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mawaqaamobile.myapplication.Adapters.MyAdsGridViewAdapter;

public class MyAdsFragment extends Fragment {
    MyAdsGridViewAdapter adsGridViewAdapter;
    GridView gridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_ads, container, false);
        adsGridViewAdapter = new MyAdsGridViewAdapter(getActivity());
        gridView = view.findViewById(R.id.gridview_categories);
        gridView.setAdapter(adsGridViewAdapter);
        return view;
    }
}
