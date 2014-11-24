package com.example.cursos;

import com.example.controlalumnos.R;
import com.example.controlalumnos.R.id;
import com.example.controlalumnos.R.layout;
import com.example.controlalumnos.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class EliminarCurso extends ActionBarActivity
{
	static EditText idCurso;
	
	private Activity actividad;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eliminar_curso);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
		actividad = this;
	}
	
	public void confirmarEliminacionCurso(View v)
	{
		Toast.makeText(actividad, "Eliminado exitosamente", Toast.LENGTH_LONG).show();
		idCurso.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eliminar_curso, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public static class PlaceholderFragment extends Fragment 
	{

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_eliminar_curso,container, false);
			
			idCurso = (EditText) rootView.findViewById(R.id.txtCodigoCurso);
			
			return rootView;
		}
	}
}
