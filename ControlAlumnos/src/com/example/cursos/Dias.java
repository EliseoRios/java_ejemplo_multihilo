package com.example.cursos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.adaptadoresListView.AdaptadorDatos;
import com.example.adaptadoresListView.Items;
import com.example.controlalumnos.R;

public class Dias extends ActionBarActivity 
{
	public static Activity actividadActual;
	ListView lvDias;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dias);
		
		if (savedInstanceState == null) 
		{
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		actividadActual = this;
	}
	
	public static class PlaceholderFragment extends Fragment 
	{
		ListView lvDias;
		
		public PlaceholderFragment() 
		{
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
		{
			View rootView = inflater.inflate(R.layout.fragment_dias, container,false);
			
			lvDias = (ListView) rootView.findViewById(R.id.lvDias);
			int cantidadCursos[]={2,4,1,0,5,7,0};
			
			Items[] misItems = {
					
					new Items("Lunes",cantidadCursos[0]+" cursos",R.drawable.ic_launcher),
					new Items("Martes",cantidadCursos[1]+" cursos",R.drawable.ic_launcher),
					new Items("Miércoles",cantidadCursos[2]+" cursos",R.drawable.ic_launcher),
					new Items("Jueves",cantidadCursos[3]+" cursos",R.drawable.ic_launcher),
					new Items("Viernes",cantidadCursos[4]+" cursos",R.drawable.ic_launcher),
					new Items("Sábado",cantidadCursos[5]+" cursos",R.drawable.ic_launcher),
					new Items("Domingo",cantidadCursos[6]+" cursos",R.drawable.ic_launcher)
			};
		  
			AdaptadorDatos adaptadorDatos = new AdaptadorDatos(actividadActual, misItems);
			lvDias.setAdapter(adaptadorDatos);
			
			return rootView;
		}
	}
}
