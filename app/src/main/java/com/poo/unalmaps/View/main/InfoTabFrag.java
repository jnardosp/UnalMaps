package com.poo.unalmaps.View.main;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.appcompat.widget.*;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.*;

import com.poo.unalmaps.Model.Db;
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
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        //Make of 2 buildings
        Point pCYT = new Point(4.638033628705625, -74.08465295571293);
        Place edificioCYT = new Place("Edificio Ciencia y Tecnología (CyT)", "Ciencia y Tecnología (CyT)", "Uno de los edificios más concurridos por estudiantes de varías" +
                                      " carreras, en particular de ingeniería. Dispone de varias zonas, la biblioteca, aulas de clase, zona de comidas y" +
                                      " auditorio. Suele estar abierto en el horario de 6 AM a 8 PM y al frente hay veces que se suelen realizar eventos",
                                      pCYT, "454", "Facultad de Ingenieria");
        Point pEArtPl = new Point(4.636301233022915, -74.08219740623474);
        Place edificioEArtPl = new Place("Escuela de Artes Plásticas", "Escuela de Artes Plásticas", "Es una reconstrucción que respeta el edificio original de " +
                                         "bellas artes. Tiene iluminación inteligente y grandes salones que benefician el estudio de la pintura.", pEArtPl,
                                          "301", "Facultad de Artes");

        DatabaseReference ediDB = importFirebase();

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

    public DatabaseReference importFirebase(){
        //Firebase
        // Write a message to the database
        DatabaseReference ediDB = FirebaseDatabase.getInstance("https://unalmaps-6356c-default-rtdb.firebaseio.com/").getReference("Actualizado");

        // Read from the database
        ediDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<HashMap> edificios = new ArrayList<>();
                List<String> names = new ArrayList<>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    HashMap edi = (HashMap<String, Object>) ds.getValue();

                    edificios.add(edi);

                    names.add(extractEdiNames(edi));

                    Log.d("TAG", names + String.valueOf(edificios));
                }
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        return ediDB;
    }

    public String extractEdiNames(HashMap edi){
        String name = (String) edi.get("Nombre de Edificio");

        return name;
    }
}
