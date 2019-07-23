package com.pablomonteserin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pablomonteserin.XML_JSON_y_AsyncTask.LeerFicheroXML;
import com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.peticionPost.GetRequestSimplificada;
import com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.subirimagen.SubirImagen;
import com.pablomonteserin.XML_JSON_y_AsyncTask.json.MainParsearJSON;
import com.pablomonteserin.XML_JSON_y_AsyncTask.retrofit.peticionPost.PostRequest;
import com.pablomonteserin.XML_JSON_y_AsyncTask.xml.MainParsearXML;
import com.pablomonteserin.XML_JSON_y_AsyncTask.AsynTaskPorGET;
import com.pablomonteserin.ejercicios.R;

public class XMLJSON extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_json);
    }
    public void irALeerXML(View v){
        startActivity(new Intent(this, LeerFicheroXML.class));
    }
    public void irAParsearXML(View v){
        startActivity(new Intent(this, MainParsearXML.class));
    }
    public void irAParsearJSON(View v){
        startActivity(new Intent(this, MainParsearJSON.class));
    }

    public void irAPeticionBasica(View v){
        startActivity(new Intent(this, AsynTaskPorGET.class));
    }
    public void irAAsyncTaskPorPOST(View v){
        startActivity(new Intent(this, AsynTaskPorGET.class));
    }
    public void irAHacerGetRequest(View v){
        startActivity(new Intent(this, GetRequestSimplificada.class));
    }

    public void irAHacerPostRequest(View v){
        startActivity(new Intent(this, PostRequest.class));
    }

    public void irASubirImagen(View v){
        startActivity(new Intent(this, SubirImagen.class));
    }

}
