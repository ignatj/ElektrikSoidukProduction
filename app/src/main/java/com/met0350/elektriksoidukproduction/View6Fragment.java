package com.met0350.elektriksoidukproduction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class View6Fragment extends Fragment implements OnMapReadyCallback {

    Integer count = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view6, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng taltech = new LatLng(59.395092, 24.671672);
        googleMap.addMarker(new MarkerOptions().position(taltech).title("Taltech"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(taltech, 13));
    }
}
