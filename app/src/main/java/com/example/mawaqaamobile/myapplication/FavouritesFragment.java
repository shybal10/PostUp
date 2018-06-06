package com.example.mawaqaamobile.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mawaqaamobile.myapplication.Adapters.FavsListGridViewAdapter;
import com.example.mawaqaamobile.myapplication.Adapters.FavsListRecyclerViewAdapter;

public class FavouritesFragment extends Fragment implements FavsListRecyclerViewAdapter.ListItemClickListener {
    FavsListRecyclerViewAdapter FavouritesListRecyclerViewAdapter;
    RecyclerView FavouritesRecyclerView;
    FavsListGridViewAdapter FavouritesGridView;
    GridView gridView;
    DetailsFragment detailsFragment;
    ImageButton listImageButton, gridImageButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favourites_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        detailsFragment = new DetailsFragment();
        listImageButton = view.findViewById(R.id.list_view_image_button);
        gridImageButton = view.findViewById(R.id.grid_view_image_button);
        FavouritesRecyclerView = (RecyclerView) view.findViewById(R.id.fav_list_recycler_view);
        gridView = view.findViewById(R.id.gridview_favs);
        FavouritesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FavouritesRecyclerView.setHasFixedSize(true);
        FavouritesListRecyclerViewAdapter = new FavsListRecyclerViewAdapter(this,getActivity());
        FavouritesRecyclerView.setAdapter(FavouritesListRecyclerViewAdapter);
        changeButton(R.id.list_view_image_button);

        listImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButton(R.id.list_view_image_button);
                FavouritesRecyclerView.setVisibility(View.VISIBLE);
                gridView.setVisibility(View.GONE);
                FavouritesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                FavouritesRecyclerView.setHasFixedSize(true);
                FavouritesRecyclerView.setAdapter(FavouritesListRecyclerViewAdapter);
            }
        });

        gridImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButton(R.id.grid_view_image_button);
                FavouritesRecyclerView.setVisibility(View.GONE);
                gridView.setVisibility(View.VISIBLE);

                FavouritesGridView = new FavsListGridViewAdapter(getActivity());
                gridView.setAdapter(FavouritesGridView);
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
