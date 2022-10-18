package com.poo.unalmaps;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.poo.unalmaps.ui.main.ScreenPagerAdapter;
import com.poo.unalmaps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ScreenPagerAdapter screenPagerAdapter = new ScreenPagerAdapter(this);
        ViewPager2 viewPager2 = binding.pager;
        viewPager2.setAdapter(screenPagerAdapter);
        TabLayout tabs = binding.tabLayout;
        tabs.setupWithViewPager(viewPager2);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ubicándote...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                onStart();
            }
        });
    }
}