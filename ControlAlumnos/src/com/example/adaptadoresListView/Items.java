package com.example.adaptadoresListView;

public class Items 
{
	private String nombre;
	private String numeroExtra;
	private int imagen;
	private String extra;
	
	public Items(String nombre, String numero, int imagen, String extra)
	{
		this.nombre = nombre;
		this.numeroExtra = numero;
		this.imagen = imagen;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setNumero(String numero)
	{
		this.numeroExtra = numero;
	}
	
	public void setImagen(int imagen)
	{
		this.imagen = imagen;
	}
	
	public void setExtra(String extra)
	{
		this.extra = extra;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getNumero()
	{
		return this.numeroExtra;
	}
	
	public int getImagen()
	{
		return this.imagen;
	}
	
	public String getExtra()
	{
		return this.extra;
	}
}
