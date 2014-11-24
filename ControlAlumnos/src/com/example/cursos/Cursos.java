package com.example.cursos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adaptadoresListView.AdaptadorDatos;
import com.example.adaptadoresListView.Items;
import com.example.controlalumnos.R;

public class Cursos extends ActionBarActivity 
{
	String dia="";
	Bundle bundle;
	static Activity actividadActual;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cursos);
		
		if (savedInstanceState == null) 
		{
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		bundle = this.getIntent().getExtras();
		dia = bundle.getString("diaRecuperado");
		actividadActual = this;
	}
	
	public void irEliminacionActivity(View v)
	{
		Intent intencion = new Intent(actividadActual, EliminarCurso.class);
		startActivity(intencion);
	}
	
	public static class PlaceholderFragment extends Fragment 
	{
		ListView lvCursos;
		Button btnEliminar;
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
		{
			View rootView = inflater.inflate(R.layout.fragment_cursos,container, false);
			
			String miDia[] = {"ICCO","Historia del arte","Estudios liberale","Gerontología","Medicina","Nanotecnología","Electrónica"};

			lvCursos = (ListView) rootView.findViewById(R.id.lvCurso);
			
			final Items[] misItems = {
					
					new Items(miDia[0],"",R.drawable.icono_cursos,""),
					new Items(miDia[1],"",R.drawable.icono_cursos,""),
					new Items(miDia[2],"",R.drawable.icono_cursos,""),
					new Items(miDia[3],"",R.drawable.icono_cursos,""),
					new Items(miDia[4],"",R.drawable.icono_cursos,""),
					new Items(miDia[5],"",R.drawable.icono_cursos,""),
					new Items(miDia[6],"",R.drawable.icono_cursos,"")
			};
			
			AdaptadorDatos adaptadorDatos = new AdaptadorDatos(actividadActual, misItems);
			lvCursos.setAdapter(adaptadorDatos);
			
			return rootView;
		}
	}
}
