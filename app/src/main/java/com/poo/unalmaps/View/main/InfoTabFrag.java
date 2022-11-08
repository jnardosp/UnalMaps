package com.poo.unalmaps.View.main;

import android.location.Location;
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

import com.google.android.material.snackbar.Snackbar;
import com.poo.unalmaps.Model.sqlDB;

import com.poo.unalmaps.R;
import com.poo.unalmaps.ViewModel.*;

import java.util.*;


public class InfoTabFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from infotab.xml
        View view = inflater.inflate(R.layout.infotab, container, false);
        sqlDB.connectToDB();
        List<String> apodCYT = new Vector<String>();
        apodCYT.add("Ciencia y Tecnología (CyT)");
        Point pCYT = new Point(4.638033628705625, -74.08465295571293);
        Place edificioCYT = new Place("Ciencia y Tecnología (CyT)", apodCYT, "Uno de los edificios más concurridos por estudiantes de varías" +
                                     " carreras, en particular de ingeniería. Dispone de varias zonas, la biblioteca, aulas de clase, zona de comidas y" +
                                     " auditorio. Suele estar abierto en el horario de 6 AM a 8 PM y al frente hay veces que se suelen realizar eventos",
                                     pCYT, "454", "Facultad de Ingenieria");

        /*Place edificioEArtPl = new Place("Escuela de Artes Plásticas", );
        Place edificio1 = new Place();
        Place edificio1 = new Place();
        Place edificio1 = new Place();*/
        return view;
    }
}
