package com.poo.unalmaps.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.poo.unalmaps.R;

public class GuideMeTabFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from guidetab.xml
        View view = inflater.inflate(R.layout.guidetab, container, false);
        return view;
    }
}
