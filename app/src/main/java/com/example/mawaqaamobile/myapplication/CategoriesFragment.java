package com.example.mawaqaamobile.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mawaqaamobile.myapplication.Adapters.CategoriesAdapter;

public class CategoriesFragment extends Fragment {
    CategoriesAdapter categoriesAdapter;
    GridView gridView;

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

    }
}
