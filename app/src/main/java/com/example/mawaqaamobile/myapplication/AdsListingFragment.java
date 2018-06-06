package com.example.mawaqaamobile.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.mawaqaamobile.myapplication.Adapters.AdsListRecyclerViewAdapter;
import com.example.mawaqaamobile.myapplication.Adapters.AdsListingGridView;

public class AdsListingFragment extends Fragment implements AdsListRecyclerViewAdapter.ListItemClickListener {
    AdsListRecyclerViewAdapter adsListRecyclerViewAdapter;
    RecyclerView adsListRecyclerView;
    AdsListingGridView adsListingGridView;
    GridView gridView;
    ImageButton listImageButton, gridImageButton;
    DetailsFragment detailsFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ads_listing_listview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        detailsFragment = new DetailsFragment();

        listImageButton = view.findViewById(R.id.list_view_image_button);
        gridImageButton = view.findViewById(R.id.grid_view_image_button);
        adsListRecyclerView = (RecyclerView) view.findViewById(R.id.ads_list_recycler_view);
        gridView =  view.findViewById(R.id.gridview_categories);
        adsListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adsListRecyclerView.setHasFixedSize(true);
        adsListRecyclerViewAdapter = new AdsListRecyclerViewAdapter(this, getActivity());
        adsListRecyclerView.setAdapter(adsListRecyclerViewAdapter);
        changeButton(R.id.list_view_image_button);

        listImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButton(R.id.list_view_image_button);
                adsListRecyclerView.setVisibility(View.VISIBLE);
                gridView.setVisibility(View.GONE);
                adsListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                adsListRecyclerView.setHasFixedSize(true);
                adsListRecyclerView.setAdapter(adsListRecyclerViewAdapter);
            }
        });

        gridImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButton(R.id.grid_view_image_button);
                adsListRecyclerView.setVisibility(View.GONE);
                gridView.setVisibility(View.VISIBLE);

                adsListingGridView = new AdsListingGridView(getActivity());
                gridView.setAdapter(adsListingGridView);
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer, detailsFragment).commit();
            }
        });

    }

    private void changeButton(int id) {
        if (id == R.id.list_view_image_button) {
            listImageButton.setImageDrawable(getResources().getDrawable(R.drawable.categorygray));
            gridImageButton.setImageDrawable(getResources().getDrawable(R.drawable.grid));
        } else if (id == R.id.grid_view_image_button) {
            listImageButton.setImageDrawable(getResources().getDrawable(R.drawable.category));
            gridImageButton.setImageDrawable(getResources().getDrawable(R.drawable.gridgray));
        }
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_continer, detailsFragment).commit();

    }
}
