package com.example.mawaqaamobile.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mawaqaamobile.myapplication.Adapters.CategoriesAdapter;

public class CategoriesFragment extends Fragment {
    CategoriesAdapter categoriesAdapter;
    GridView gridView;
    RelativeLayout relativeLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.categories_layout, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoriesAdapter = new CategoriesAdapter(getActivity());
        gridView = view.findViewById(R.id.gridview_categories);
        gridView.setAdapter(categoriesAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                relativeLayout = (RelativeLayout) view.findViewById(R.id.image_bg);
                relativeLayout.setBackgroundResource(R.drawable.button_click);
            }
        });
    }
}
