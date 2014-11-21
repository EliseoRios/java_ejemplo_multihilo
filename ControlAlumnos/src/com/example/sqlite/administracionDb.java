package com.example.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class administracionDb 
{
	//TABLAS GENERALES
	public static final String tablaCursos = "CREATE TABLE IF NOT EXISTS cursos (" +
            "id INTEGER PRYMARY KEY AUTOINCREMENT,"+
			"nombre TEXT NOT NULL,"+
			"id_profesor" +
            "aula TEXT," +
            "dias TEXT NOT NULL" +
			"hora_inicio TEXT" +
			"hora_salida TEXT);";
	public static final String tablaAlumnos = "CREATE TABLE IF NOT EXISTS alumnos (" +
			"codigo INTEGER PRYMARY KEY NOT NULL," +
			"nombre TEXT NOT NULL," +
			"id_curso TEXT NOT NULL" +
			"calificacion_tareas INTEGER," +
			"calificacion_examenes INTEGER," +
			"calificacion_practicas INTEGER" +
			"derecho_examen INTEGER);";
	public static final String tablaProfesores = "CREATE TABLE IF NOT EXISTS profesores (" +
			"id INTEGER PRIMARY KEY AUTOINCREMENT," +
			"nombre TEXT NOT NULL," +
			"contrasenia TEXT);";
	
	//Tablas administrador. Indicadores Examen0, Tareas1, Practicas2.
	public static final String tablaExamenes = "CREATE TABLE IF NOT EXISTS examenes (" +
			"id INTEGER PRIMARY KEY AUTOINCREMENT" +
			"indicador INTEGER," +
			"nombre TEXT," +
			"valor_porcentual INTEGER NOT NULL," +
			"id_curso INTEGER);";
	public static final String tablaTareas = "CREATE TABLE IF NOT EXISTS tareas (" +
			"id INTEGER PRIMARY KEY AUTOINCREMENT," +
			"indicador INTEGER," +
			"total_porcentual INTEGER NOT NULL," +
			"id_curso INTEGER);";
	public static final String tablaPracticas = "CREATE TABLE IF NOT EXISTS practicas (" +
			"id INTEGER PRIMARY KEY AUTOINCREMENT," +
			"indicador INTEGER," +
			"nombre TEXT," +
			"valor_porcentual INTEGER NOT NULL," +
			"id_curso INTEGER);";
	public static final String tablaAsistencias = "CREATE TABLE IF NOT EXISTS asistencias(" +
			"id AUTOINCREMENT," +
			"fecha TEXT);";
	
	//Tablas registro continuo
	public static final String tablaRegistrarActividades = "CREATE TABLE IF NOT EXISTS registro_actividades(" +
			"id INTEGER AUTOINCREMENT PRIMARY KEY," +
			"id_alumno INTEGER," +
			"indicador_actividad INTEGER," +
			"id_actividad INTEGER," +
			"id_curso INTEGER);";
	
	//tabla para saber posicionamiento en Actividades
	public static final String tablaPosicion = "CREATE TABLE IF NOT EXISTS posicion(" +
			"id_profesor INTEGER," +
			"id_curso INTEGER," +
			"id_alumno INTEGER," +
			"id_indicador_actividad," +
			"id_actividad INTEGER";
	
	private dbHelper helper;
	private SQLiteDatabase db;
	
	public administracionDb(Context contexto)
	{
		helper = new dbHelper(contexto);
		db = helper.getWritableDatabase();
	}
	
	public void registrarProfesor()
	{
		String sqlRegistrarProfesor = "";
	}
	
	public void verificarProfesor()
	{
		String sqlVerificarProfesor = "";
	}
	
	public void cargarCursos()
	{
		String sqlCargarCursos = "";
	}
	
	public void cargarAlumnos()
	{
		String sqlCargarAlumnos = "";
	}
	
	public void consultarDatosAlumno()
	{
		datosBasicosAlumno();
		consultarTrabajosAlumno();
		consultarCalificacionAlumno();
		verificarDerechoOrdinario();
	}
	
	private void datosBasicosAlumno()
	{
		String sqlDatosBasicosAlumno = "";
	}
	
	private void consultarCalificacionAlumno()
	{
		String sqlConsultarCalificaciones = "";
	}
	
	private void consultarTrabajosAlumno()
	{
		String sqlConsultarTrabajosAlumno = "";
	}
	
	private void verificarDerechoOrdinario()
	{
		String sqlDerechoOrdinario = "";
	}
	
	public void registrarTareaAlumno()
	{
		String sqlRegistrarAlumno = "";
	}
	
	public void registrarExamenAlumno()
	{
		String sqlRegistrarExamenAlumno = "";
	}
	
	public void registrarPracticaAlumno()
	{
		String sqlRegistrarPracticaAlumno = "";
	}
	
	public void agregarTareaAdministrador()
	{
		String sqlAgregarTareaAlumno = "";
	}
	
	public void agregarExamenAdministrador()
	{
		String sqlAgregarExamenAdminitrador = "";
	}
	
	public void agregarPracticaAdministrador()
	{
		String sqlAgregarPracticasAdministrador = "";
	}
	
	public void guardarAsistencias()
	{
		String sqlGuardarAsistencias = "";
	}
	
	public void justificarFalta()
	{
		String sqlJustificarFalta = "";
	}
	
	public void consultarPosicion()
	{
		String sqlConsultarPosicion = "";
	}
}
