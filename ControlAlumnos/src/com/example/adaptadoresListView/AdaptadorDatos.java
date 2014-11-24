package com.example.adaptadoresListView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.controlalumnos.R;

public class AdaptadorDatos extends BaseAdapter 
{
	static Activity contexto;
	Items[] items;
	
	public AdaptadorDatos(Activity contexto, Items[] listaItems)
	{
		super();
		this.contexto = contexto;
		this.items = listaItems;
	}
	
	 @SuppressLint("ViewHolder")
	 @Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		//Crea objetos en Java a partir de XML (usando abstraccion)
		LayoutInflater inflater = contexto.getLayoutInflater();
		View view = inflater.inflate(R.layout.activity_adaptador_items_lv, null, true);
		
	    TextView txtNombre = (TextView) view.findViewById(R.id.txtNombre);
		txtNombre.setText(items[position].getNombre());
		
		TextView txtNumero = (TextView) view.findViewById(R.id.txtNumero);
		txtNumero.setText(items[position].getNumero());
		
		TextView txtExtra = (TextView) view.findViewById(R.id.txtExtras);
		txtExtra.setText(items[position].getExtra());
		
		ImageView imgFoto = (ImageView) view.findViewById(R.id.imgFoto);
		imgFoto.setImageResource(items[position].getImagen());
		
		return view;
	}
	
	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		return items.length;
	}

	@Override
	public Object getItem(int position) 
	{
		// TODO Auto-generated method stub
		return items[position].getNombre();
	}

	@Override
	public long getItemId(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}
}
