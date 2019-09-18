package com.example.apprredsi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnInicioSesion;
    private Button btnConsultas;
    private Button btnMapas;
    private Button btnPatrocinio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInicioSesion = (Button) findViewById(R.id.btnInicioSesion);
        btnConsultas = (Button) findViewById(R.id.btnConsultas);
        btnMapas = (Button) findViewById(R.id.btnMapas);
        btnPatrocinio = (Button) findViewById(R.id.btnPatrocinio);

        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irToLogin = new Intent (v.getContext(), LoginActivity.class);
                startActivity(irToLogin);
            }
        });

        btnConsultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irToConsultas = new Intent (v.getContext(), ConsultasActivity.class);
                startActivity(irToConsultas);
            }
        });

        btnMapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irToMapas = new Intent (v.getContext(), MapasActivity.class);
                startActivity(irToMapas);
            }
        });

        btnPatrocinio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irToPatrocinio = new Intent (v.getContext(), PatrocinadoresActivity.class);
                startActivity(irToPatrocinio);
            }
        });

    }



}
