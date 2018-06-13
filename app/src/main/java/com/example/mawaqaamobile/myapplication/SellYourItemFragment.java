package com.example.mawaqaamobile.myapplication;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mawaqaamobile.myapplication.UIUtils.RoundedCornersTransform;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import static android.app.Activity.RESULT_OK;

public class SellYourItemFragment extends Fragment{
    MapView mMapView;
    Button termsButton;
    private GoogleMap googleMap;
    private ImageButton addPhotosButton, addImagesButton;
    private static int RESULT_LOAD_IMAGE = 1;
    private int count = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sell_your_item_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        addImagesButton = view.findViewById(R.id.add_images_button);
        addPhotosButton = view.findViewById(R.id.add_photo_button);
        termsButton = view.findViewById(R.id.terms_button);
        termsButton.setPaintFlags(termsButton.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(-34, 151);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        addPhotosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        addImagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            count = count + 1;
            if (count == 1) {
                ImageView imageView = (ImageView) getView().findViewById(R.id.bigimage);
               // Picasso.get().load(data.getData()).into(imageView);
                Glide.with(this).load(data.getData()).into(imageView);
                imageView.setVisibility(View.VISIBLE);
            }
            if (count == 2) {
                ImageView imageView = (ImageView) getView().findViewById(R.id.photo1);
                Picasso.get().load(data.getData()).transform(new RoundedCornersTransform()).into(imageView);
                imageView.setVisibility(View.VISIBLE);
            }
            if (count == 3) {
                ImageView imageView = (ImageView) getView().findViewById(R.id.photo2);
                Picasso.get().load(data.getData()).transform(new RoundedCornersTransform()).into(imageView);
                //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                imageView.setVisibility(View.VISIBLE);
            }
            if (count == 4) {
                ImageView imageView = (ImageView) getView().findViewById(R.id.photo3);
                Picasso.get().load(data.getData()).transform(new RoundedCornersTransform()).into(imageView);
                //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                imageView.setVisibility(View.VISIBLE);
            }
            if (count == 5) {
                ImageView imageView = (ImageView) getView().findViewById(R.id.photo4);
                Picasso.get().load(data.getData()).transform(new RoundedCornersTransform()).into(imageView);
                //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                imageView.setVisibility(View.VISIBLE);
            }
            else if (count > 5) {
                Toast.makeText(getActivity(), "Sorry cannot add anymore pictures", Toast.LENGTH_LONG).show();
            }
        }

    }
}
