package com.poo.unalmaps.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mapbox.maps.MapView;
import com.mapbox.maps.Style;

import com.poo.unalmaps.R;

public class LocateMeTabFrag extends Fragment{
    private MapView mapView;
    private static final String mainStyle = "mapbox://styles/jsotop/cl9ujaevy001l15s5feh9ph07";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from locatetab.xml
        View view = inflater.inflate(R.layout.locatetab, container, false);
        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.getMapboxMap().loadStyleUri(mainStyle);
        return view;
    }

    //Methods of mapView
    public void onStart(){
        super.onStart();
        mapView.onStart();
    }

    public void onStop(){
        super.onStop();
        mapView.onStop();
    }

    public void onLowMemory(){
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
    }

}
