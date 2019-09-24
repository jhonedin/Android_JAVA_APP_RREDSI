package com.example.apprredsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class RespuestaConsultasActivity extends AppCompatActivity {

    Button btnVolverToMain;

    TextView textViewPrueba;
    TextView textViewPrueba2;
    TextView textViewPrueba3;
    TextView textViewPrueba4;
    TextView textViewPrueba5;

    TextView sal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_consultas);

        textViewPrueba =  findViewById(R.id.textViewPrueba);
        textViewPrueba2 = findViewById(R.id.textViewPrueba2);
        textViewPrueba3 = findViewById(R.id.textViewPrueba3);
        textViewPrueba4 = findViewById(R.id.textViewPrueba4);
        textViewPrueba5 = findViewById(R.id.textViewPrueba5);

        sal  = (TextView) findViewById(R.id.textViewSalidaApi);



        Bundle delivery = getIntent().getExtras();
        String evaluador = delivery.getString("evaluador");
        String institucion = delivery.getString("institucion");
        String autores = delivery.getString("autores");
        String areasconocimiento = delivery.getString("areasconocimiento");
        String nombrepropuesta = delivery.getString("nombrepropuesta");

        textViewPrueba.setText(evaluador);
        textViewPrueba2.setText(institucion);
        textViewPrueba3.setText(autores);
        textViewPrueba4.setText(areasconocimiento);
        textViewPrueba5.setText(nombrepropuesta);



        btnVolverToMain = findViewById(R.id.btnVolverToMain);
        btnVolverToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConsultasActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        getData();
    }

    public void getData(){
        String sql = "http://www.mocky.io/v2/5d6addff3100006000d2077c";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpURLConnection conn;

        try {
            URL url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();

            //JSONArray jsonArr = new JSONArray(json);
            //String mensaje = "";
            /*
            for(int i = 0;i<jsonArr.length();i++){
                JSONObject jsonObject = jsonArr.getJSONObject(i);

                Log.d("SALIDA",jsonObject.optString("agenda"));
                mensaje += ("DESCRIPCION " + i + " " + jsonObject.optString("espacio") + "\n");
            }

             */
            //sal.setText(mensaje);
            sal.setText(json);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }


}

