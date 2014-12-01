package com.example.cursos;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.example.adaptadoresListView.AdaptadorDatos;
import com.example.adaptadoresListView.Items;
import com.example.controlalumnos.R;
import com.example.sqlite.administracionDb;

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
			administracionDb administracion = new administracionDb(this.getActivity());
			View rootView = inflater.inflate(R.layout.fragment_dias, container,false);
		
			final String miDia[] = {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
			final String diaAEnviar[] = {"lunes","martes","miercoles","jueves","viernes","sabado","domingo"};
			
			lvDias = (ListView) rootView.findViewById(R.id.lvDias);
			
			
			
			final Items[] misItems = {
					
					new Items(miDia[0],"",R.drawable.lunes,""),
					new Items(miDia[1],"",R.drawable.martes,""),
					new Items(miDia[2],"",R.drawable.miercoles,""),
					new Items(miDia[3],"",R.drawable.jueves,""),
					new Items(miDia[4],"",R.drawable.viernes,""),
					new Items(miDia[5],"",R.drawable.sabado,""),
					new Items(miDia[6],"",R.drawable.domingo,"")
			};
		   
			AdaptadorDatos adaptadorDatos = new AdaptadorDatos(actividadActual, misItems);
			lvDias.setAdapter(adaptadorDatos);
			
			lvDias.setOnItemClickListener(new OnItemClickListener()
			{
				public void onItemClick(AdapterView<?> parent, View view, int position, long id){
					//Toast.makeText(getApplicationContext(), "Reproduciendo canción " + position, Toast.LENGTH_SHORT).show();
					String dia = diaAEnviar[position];
					Toast.makeText(actividadActual, dia, Toast.LENGTH_SHORT).show();
					enviar(dia);
				}

				private void enviar(String dia) {
					// TODO Auto-generated method stub
					Intent i = new Intent(actividadActual, Cursos.class);
					i.putExtra("diaRecuperado", dia);
					startActivity(i);
				}
			});
			
			return rootView;
		}
	}
}
