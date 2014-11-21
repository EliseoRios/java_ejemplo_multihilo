package com.example.controlalumnos;

import com.example.cursos.Cursos;
import com.example.cursos.Dias;
import com.example.sqlite.administracionDb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Inicio extends ActionBarActivity 
{
	administracionDb administracion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        
        if (savedInstanceState == null) 
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        administracion = new administracionDb(this);
        Intent intent = new Intent(Inicio.this, Dias.class);
        startActivity(intent);
    }

    
    public static class PlaceholderFragment extends Fragment 
    {

        public PlaceholderFragment() 
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
        {
            View rootView = inflater.inflate(R.layout.fragment_inicio, container, false);
            return rootView;
        }
    }
}
