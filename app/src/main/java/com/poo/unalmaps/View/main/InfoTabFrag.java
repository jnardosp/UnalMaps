package com.poo.unalmaps.View.main;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.appcompat.widget.*;

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


public class InfoTabFrag extends Fragment implements SearchView.OnQueryTextListener {
    String[] buildNameList;
    ListView list;
    SearchView editSV;
    ArrayList<String> arrayList = new ArrayList<String>();
    ListViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from infotab.xml
        View view = inflater.inflate(R.layout.infotab, container, false);
        sqlDB.connectToDB();

        //Make of 2 buildings
        List<String> apodCYT = new Vector<String>();
        apodCYT.add("Ciencia y Tecnología (CyT)");
        Point pCYT = new Point(4.638033628705625, -74.08465295571293);
        Place edificioCYT = new Place("Edificio Ciencia y Tecnología (CyT)", apodCYT, "Uno de los edificios más concurridos por estudiantes de varías" +
                                      " carreras, en particular de ingeniería. Dispone de varias zonas, la biblioteca, aulas de clase, zona de comidas y" +
                                      " auditorio. Suele estar abierto en el horario de 6 AM a 8 PM y al frente hay veces que se suelen realizar eventos",
                                      pCYT, "454", "Facultad de Ingenieria");
        List<String> apodEArtPl = new Vector<String>();
        apodEArtPl.add("Escuela de Artes Plásticas");
        Point pEArtPl = new Point(4.636301233022915, -74.08219740623474);
        Place edificioEArtPl = new Place("Escuela de Artes Plásticas", apodEArtPl, "Es una reconstrucción que respeta el edificio original de " +
                                         "bellas artes. Tiene iluminación inteligente y grandes salones que benefician el estudio de la pintura.", pEArtPl,
                                          "301", "Facultad de Artes");
        /*Place edificio1 = new Place();
        Place edificio1 = new Place();
        Place edificio1 = new Place();*/

        buildNameList = new String[]{edificioCYT.getName(), edificioEArtPl.getName()};
        list = (ListView) view.findViewById(R.id.listSVInfoTab);
        for(int i=0; i < buildNameList.length; i++){
            String buildName = buildNameList[i];
            arrayList.add(buildName);
        }

        adapter = new ListViewAdapter(this.getActivity(), arrayList);

        list.setAdapter(adapter);

        editSV = (SearchView) view.findViewById(R.id.searchViewInfoTab);
        editSV.setOnQueryTextListener(this);

        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}
