package com.poo.unalmaps.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.mapbox.maps.MapView;
import com.poo.unalmaps.R;

public class GuideMeTabFrag extends Fragment {

    private MapView mapView;
    private static final String mainStyle = "mapbox://styles/jsotop/cl9ujaevy001l15s5feh9ph07";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from guidetab.xml
        View view = inflater.inflate(R.layout.guidetab, container, false);
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
