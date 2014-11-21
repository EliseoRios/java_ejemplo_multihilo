package com.example.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper
{
	private static final String nombreDb = "control_alumnos.sqlite";
	private static final int versionEsquemaDb = 1;

	public dbHelper(Context contexto) 
	{
	   //Creación DB
		super(contexto, nombreDb, null, versionEsquemaDb);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		//Inicializar db DB
		db.execSQL(administracionDb.tablaAlumnos);
		db.execSQL(administracionDb.tablaProfesores);
		db.execSQL(administracionDb.tablaCursos);
		
		db.execSQL(administracionDb.tablaTareas);
		db.execSQL(administracionDb.tablaExamenes);
		db.execSQL(administracionDb.tablaPracticas);
		db.execSQL(administracionDb.tablaAsistencias);
		
		db.execSQL(administracionDb.tablaRegistrarActividades);
		db.execSQL(administracionDb.tablaPosicion);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// Actualizacion DB
		
	}

}