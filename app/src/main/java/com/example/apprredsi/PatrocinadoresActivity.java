package com.example.apprredsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PatrocinadoresActivity extends AppCompatActivity {

    Button btnVolverToMain;
    ListView listaPatrocinadores;
    ListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patrocinadores);

        btnVolverToMain = findViewById(R.id.btnVolverToMain);
        btnVolverToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        //String countryList[] = {"Universidad del Valle", "Universidad Libre", "Unidad Central Del valle", "Escuela de Policía", "Universidad Del Quindio", "Universidad Católica de Pereira","JUANTU","PROGRAMA2","Software Manager ERP","Webcoster S.A.S","","",""};
        String patrocinadoresList[] = {"JUANTU","PROGRAMA2","Software Manager ERP","Webcoster S.A.S"};
        int[] imagenes = {
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
        };
        listaPatrocinadores = (ListView)findViewById(R.id.listviewpatrocinadores);
        adapter = new ListViewAdapter(this, patrocinadoresList, imagenes);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, patrocinadoresList);
        listaPatrocinadores.setAdapter(adapter);


    }
}
