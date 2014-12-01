package com.example.sqlite;


import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class administracionDb
{
	//TABLAS GENERALES
	public static final String tablaCursos = "CREATE TABLE IF NOT EXISTS cursos (" +
            "id INTEGER PRIMARY KEY NOT NULL,"+
			"nombre TEXT NOT NULL,"+
			"id_profesor TEXT," +
            "aula TEXT," +
			"hora_inicio TEXT" +
			"hora_salida TEXT);";
	public static final String tablaAlumnos = "CREATE TABLE IF NOT EXISTS alumnos (" +
			"codigo INTEGER PRIMARY KEY NOT NULL," +
			"nombre TEXT NOT NULL," +
			"id_curso TEXT NOT NULL" +
			"calificacion_tareas INTEGER," +
			"calificacion_examenes INTEGER," +
			"calificacion_practicas INTEGER" +
			"derecho_examen INTEGER);";
	public static final String tablaProfesores = "CREATE TABLE IF NOT EXISTS profesores (" +
			"nombre TEXT NOT NULL PRIMARY KEY," +
			"contrasenia TEXT);";
	public static final String tablaDias = "CREATE TABLE IF NOT EXISTS dias(" +
			"id INTEGER AUTOINCREMENT PRIMARY KEY," +
			"id_curso INTEGER NOT NULL," +
			"lunes INTEGER," +
			"martes INTEGER," +
			"miercoles INTEGER," +
			"jueves INTEGER," +
			"viernes INTEGER," +
			"sabado INTEGER," +
			"domingo INTEGER;";
	
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
	
	//Tabla para saber posicionamiento en Actividades
	public static final String tablaPosicion = "CREATE TABLE IF NOT EXISTS posicion(" +
			"id_profesor TEXT PRIMARY KEY," +
			"id_curso INTEGER," +
			"id_alumno INTEGER," +
			"id_indicador_actividad," +
			"id_actividad INTEGER";
	
	private dbHelper helper;
	private SQLiteDatabase db;
	
	//CONTRUCTOR 
	public administracionDb(Context contexto)
	{
		helper = new dbHelper(contexto);
		db = helper.getWritableDatabase();
	}
	
	public void registrarProfesor(String nombre, String contrasenia)
	{
		String sqlRegistrarProfesor = "INSERT INTO profesores (nombre, contrasenia) VALUES ('"+nombre+"','"+contrasenia+"');";
		db.execSQL(sqlRegistrarProfesor);
	}
	
	public void verificarProfesor(String nombre, String contrasenia)
	{
		//retorna 0 ó 1
		String sqlVerificarProfesor = "SELECT CASE WHEN COUNT( * ) >0 THEN TRUE " +
				                      "ELSE FALSE " +
				                      "END " +
				                      "FROM profesores WHERE contrasenia = '"+contrasenia+"';";
		
		db.rawQuery(sqlVerificarProfesor, null);
	}
	
	public Cursor cargarCursos(String dia, String idProfesor)
	{
		String sqlCargarCursos = "SELECT cursos.nombre FROM cursos,dias WHERE dias.id_curso=cursos.id AND cursos.id_profesor=? AND ?=1;";
		String argumentosCompara[]={idProfesor, dia};
		return db.rawQuery(sqlCargarCursos, argumentosCompara);
	}
	
	public void cargarAlumnos(String idCurso, String idProfesor)
	{
		String sqlCargarAlumnos = "SELECT alumnos.codigo, alumnos.nombre FROM alumnos, cursos WHERE cursos.id='"+idCurso+"' AND cursos.id=alumnos.id_curso AND cursos.id_profesor='"+idProfesor+"';";	
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
		//String sqlDatosBasicosAlumno = "";
	}
	
	private void consultarCalificacionAlumno()
	{
		//String sqlConsultarCalificaciones = "";
	}
	
	private void consultarTrabajosAlumno()
	{
		//String sqlConsultarTrabajosAlumno = "";
	}
	
	private void verificarDerechoOrdinario()
	{
		//String sqlDerechoOrdinario = "";
	}
	
	public void registrarTareaAlumno()
	{
		//String sqlRegistrarAlumno = "";
	}
	
	public void registrarExamenAlumno()
	{
		//String sqlRegistrarExamenAlumno = "";
	}
	
	public void registrarPracticaAlumno()
	{
		//String sqlRegistrarPracticaAlumno = "";
	}
	
	public void agregarTareaAdministrador()
	{
		//String sqlAgregarTareaAlumno = "";
	}
	
	public void agregarExamenAdministrador()
	{
		//String sqlAgregarExamenAdminitrador = "";
	}
	
	public void agregarPracticaAdministrador()
	{
		//String sqlAgregarPracticasAdministrador = "";
	}
	
	public void guardarAsistencias()
	{
		//String sqlGuardarAsistencias = "";
	}
	
	public void justificarFalta()
	{
		//String sqlJustificarFalta = "";
	}
	
	public void establecerProfesorActivo(String idProfesor)
	{
		String sqlProfesorActivo = "INSERT INTO posicion (id_profesor) VALUES ("+idProfesor+");";
		db.execSQL(sqlProfesorActivo);
	}
	
	public void establecerCursoActivo(String idCurso)
	{
		String sqlCursoActivo = "INSERT INTO posicion (id_curso) VALUES ("+idCurso+");";
		db.execSQL(sqlCursoActivo);
	}
	
	public void establecerAlumnoActivo(String idAlumno)
	{
		String sqlAlumnoActivo =" INSERT INTO posicion (id_alumno) VALUES ("+idAlumno+");";
		db.execSQL(sqlAlumnoActivo);
	}
	
	public String obtenerProfesorActivo()
	{
		String nombreProfesor="";
		String columnas[] = {"id_profesor"};
		Cursor cursor = db.query("posicion", columnas, null, null, null, null, null);
		
		do
		{
			nombreProfesor = cursor.getString(0);
		}while(cursor.moveToNext());
		
		return nombreProfesor;
	}
	
	public String obtenerCursoActivo()
	{
		String nombreCurso="";
		String columnas[] = {"id_curso"};
		Cursor cursor = db.query("posicion", columnas, null, null, null, null, null);
		
		do
		{
			nombreCurso = cursor.getString(0);
		}while(cursor.moveToNext());
		
		return nombreCurso;
	}
	
	public String obtenerIdAlumno()
	{
		String idAlumno="";
		String columnas[] = {"id_alumno"};
		Cursor cursor = db.query("posicion", columnas, null, null, null, null, null);
		
		do
		{
			idAlumno = cursor.getString(0);
		}while(cursor.moveToNext());
		
		return idAlumno;
	}
}
