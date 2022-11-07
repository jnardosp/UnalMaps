package com.poo.unalmaps.ViewModel;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.poo.unalmaps.databinding.ActivityMainBinding;
import com.poo.unalmaps.View.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public static final int DEFAULT_UPD_INTERVAL = 30;
    public static final int FASTEST_UPD_INTERVAL = 5;
    private static final int PERMISSION_FINE_LOCATION = 77;
    private ActivityMainBinding binding;

    //Location Request is a config file for the settings of FusedLocationProviderClient.
    LocationRequest locationRequest;

    //Google API for location services.
    FusedLocationProviderClient fusedLocationProviderClient;

    //when running the app!!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton locateButton = binding.locateButton;

        locateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ubicándote...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                updateGPS(view);
            }
        });

        //set properties of LocationRequest
        locationRequest = new LocationRequest();
        //Set timer for normal location
        locationRequest.setInterval(1000 * DEFAULT_UPD_INTERVAL);
        //Set timer for most frequent location
        locationRequest.setFastestInterval(1000 * FASTEST_UPD_INTERVAL);

        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

    }//End of onCreate();

    private void updateGPS(View view){
        //get permissions from user
        //get current location from user
        //Update UI
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            //User provided permissions
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    //Values of location, for the UI
                    showSnackLocation(location, view);
                }
            });
        }
        else{
            //No permissions yet.
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_FINE_LOCATION);
            }
        }
    }

    private void showSnackLocation(Location location, View view) {
        //show a SnackBar with user Location
        Snackbar.make(view, "Latitude:" + location.getLatitude() + " Longitude:" + location.getLongitude(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_FINE_LOCATION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //updateGPS(view);
                }
                else{
                    //Toast provides simple feedback in a popup
                    Toast.makeText(this, "Unal Maps requiere permiso de Ubicación para funcionar correctamente", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }
}