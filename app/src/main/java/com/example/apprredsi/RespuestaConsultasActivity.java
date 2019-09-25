package com.example.apprredsi;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.ArrayList;

public class RespuestaConsultasActivity extends AppCompatActivity {

    Button btnVolverToMain;
    /*
    TextView textViewPrueba;
    TextView textViewPrueba2;
    TextView textViewPrueba3;
    TextView textViewPrueba4;
    TextView textViewPrueba5;
    TextView sal;
    */

    ListView listaProyectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta_consultas);
        /*
        textViewPrueba =  findViewById(R.id.textViewPrueba);
        textViewPrueba2 = findViewById(R.id.textViewPrueba2);
        textViewPrueba3 = findViewById(R.id.textViewPrueba3);
        textViewPrueba4 = findViewById(R.id.textViewPrueba4);
        textViewPrueba5 = findViewById(R.id.textViewPrueba5);
        sal  = (TextView) findViewById(R.id.textViewSalidaApi);
        */
        listaProyectos = findViewById(R.id.listViewProyectos);

        Bundle delivery = getIntent().getExtras();
        String evaluador = delivery.getString("evaluador");
        String institucion = delivery.getString("institucion");
        String autores = delivery.getString("autores");
        String areasconocimiento = delivery.getString("areasconocimiento");
        String nombrepropuesta = delivery.getString("nombrepropuesta");
        /*
        textViewPrueba.setText(evaluador);
        textViewPrueba2.setText(institucion);
        textViewPrueba3.setText(autores);
        textViewPrueba4.setText(areasconocimiento);
        textViewPrueba5.setText(nombrepropuesta); */



        btnVolverToMain = findViewById(R.id.btnVolverToMain);
        btnVolverToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConsultasActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        String proyectos[] = getData(evaluador,institucion,autores,areasconocimiento,nombrepropuesta);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, proyectos);
        listaProyectos.setAdapter(arrayAdapter);

    }

    public String[] getData(String evaluador,String institucion,String autores,String areasconocimiento,String nombrepropuesta){
       // String sql = "http://www.mocky.io/v2/5d6addff3100006000d2077c"; // de prueba del profe
        String sql = "http://www.mocky.io/v2/5d8a38273000008cc2b9a81d";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpURLConnection conn;
        ArrayList<String> arrayProyectos = new ArrayList<>();
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

            JSONObject object = new JSONObject(json);
            JSONArray json_array = object.optJSONArray("agenda");

            //String mensaje = "";

            for(int i=0; i < json_array.length(); i++){
                JSONObject unObject = json_array.getJSONObject(i);
                //JSONArray json_array_Trabajo =  unObject.optJSONArray("trabajo");
                //JSONObject ObjectTrabajo = json_array_Trabajo.getJSONObject(i);
                //Log.d("mensaje",unObject.get("id_agenda") .toString());
                //arrayProyectos.add(unObject.get("id_agenda").toString());
                //mensaje += json_array.getJSONObject(i).toString();
                JSONObject objectTitulo = (JSONObject) unObject.get("trabajo");
                arrayProyectos.add(objectTitulo.get("titulo").toString());
            }
            //sal.setText(mensaje);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayProyectos.toArray(new String[0]);
    }



}

