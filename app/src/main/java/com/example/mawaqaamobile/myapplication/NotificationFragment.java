package com.example.mawaqaamobile.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawaqaamobile.myapplication.Adapters.NotificationRecyclerView;

public class NotificationFragment extends Fragment {
    RecyclerView notificationRecyclerView;
    NotificationRecyclerView adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notifications_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        notificationRecyclerView = (RecyclerView) view.findViewById(R.id.notification_recycler_view);
        notificationRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        notificationRecyclerView.setHasFixedSize(true);
        adapter = new NotificationRecyclerView();
        notificationRecyclerView.setAdapter(adapter);
    }
}
