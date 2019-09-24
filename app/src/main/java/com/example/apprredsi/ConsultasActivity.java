package com.example.apprredsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultasActivity extends AppCompatActivity {

    Button btnVolverToMain;
    Button btnConsultar;

    EditText evaluadorEditText;
    EditText institucionEditText;
    EditText autoresEditText;
    EditText areasconocimientoEditText;
    EditText nombrepropuestaEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        evaluadorEditText = findViewById(R.id.evaluadorEditText);
        institucionEditText= findViewById(R.id.institucionEditText);
        autoresEditText= findViewById(R.id.autoresEditText);
        areasconocimientoEditText= findViewById(R.id.areasconocimientoEditText);
        nombrepropuestaEditText = findViewById(R.id.nombrepropuestaEditText);

        btnConsultar = findViewById(R.id.btnConsultar);
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String evaluador = evaluadorEditText.getText().toString();
                String institucion= institucionEditText.getText().toString();
                String autores = autoresEditText.getText().toString();
                String areasconocimiento = areasconocimientoEditText.getText().toString();
                String nombrepropuesta = nombrepropuestaEditText.getText().toString();
                Bundle data = new Bundle();
                data.putString("evaluador",evaluador);
                data.putString("institucion",institucion);
                data.putString("autores", autores);
                data.putString("areasconocimiento",areasconocimiento);
                data.putString("nombrepropuesta",nombrepropuesta);

                Intent intent = new Intent (v.getContext(), RespuestaConsultasActivity.class);
                intent.putExtras(data);
                startActivity(intent);



            }
        });


        btnVolverToMain = findViewById(R.id.btnVolverToMain);
        btnVolverToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });







    }
}
