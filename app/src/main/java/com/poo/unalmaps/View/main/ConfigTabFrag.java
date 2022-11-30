package com.poo.unalmaps.View.main;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.fragment.app.Fragment;

import com.poo.unalmaps.R;

public class ConfigTabFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from configtab.xml
        View view = inflater.inflate(R.layout.configtab, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Button bttnDev = view.findViewById(R.id.infoDevsButton);
        bttnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoDV(view);
            }
        });
        Button bttnTB = view.findViewById(R.id.accessButton);
        bttnTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTBInstructions(view);
            }
        });
    }

    public void showTBInstructions(View view){
        // inflate the layout of the popup window
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.popuptb, null);

        // create the popup window
        PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);


        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    public void showInfoDV(View view){
        // inflate the layout of the popup window
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.popupdev, null);

        // create the popup window
        PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);


        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}
