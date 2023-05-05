package libreria.java.instituto;

import java.util.ArrayList;
import java.util.Iterator;


public class TestDatabase {
	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		
		if(databaseConnection.connect("jdbc:mysql://localhost/instituto?" + "user=root&password=usuario"));
		
		DatabaseManager dataBaseManager = new DatabaseManager(databaseConnection.getConnection());
		System.out.println(databaseConnection.isConnected());
		
		ArrayList<Alumno> Alumnos = new ArrayList<>();
		Alumnos = dataBaseManager.getAlumnos();
		Alumnos.stream().forEach(b->System.out.println(b));
		
		ArrayList<Profesor> Profesores = new ArrayList<>();
		Profesores= dataBaseManager.getProfesores();
		Profesores.stream().forEach(b->System.out.println(b));
		
		ArrayList<Asignatura> Asignaturas = new ArrayList<>();
		Asignaturas = dataBaseManager.getAsignaturas();
		Asignaturas.stream().forEach(b->System.out.println(b));
		
		ArrayList<Recibe> Recibe = new ArrayList<>();
		Recibe = dataBaseManager.getRecibe();
		Recibe.stream().forEach(b->System.out.println(b));
		
		Alumnos = dataBaseManager.getAlumnos("numMatricula", 1);
		Alumnos.stream().forEach(b->System.out.println(b));
		
		Asignaturas = dataBaseManager.getAsignatura("codAsignatura", "5");
		Asignaturas.stream().forEach(b->System.out.println(b));
		
		Profesores = dataBaseManager.getProfesores("dni", "123456789");
		Profesores.stream().forEach(b->System.out.println(b));
		Alumno alumnoUdate = new Alumno(1, "Carlos Sánchez","2005-05-10","123456789");
		Asignatura udpateAsignatura = new Asignatura(1, "Mates", "Antonio Ruiz", 123456789);
		Profesor profesor = new Profesor("111222333", "Pablo Díaz", "657854387");
		boolean acutualizar;
		//System.out.println(acutualizar=dataBaseManager.updateAlumno(alumnoUdate));
		//System.out.println(acutualizar=dataBaseManager.updateAsigntura(udpateAsignatura));
		System.out.println(acutualizar=dataBaseManager.updateProfesor(profesor));
		

		Alumnos = dataBaseManager.getAlumnos(new String[] {"numMatricula", "fechaNacimiento"});
		Alumnos.stream().forEach(b->System.out.println(b));
		
		//System.out.println(Alumnos);
		//boolean borradoRegistros;
		//System.out.println(borradoRegistros = dataBaseManager.deleteRegistro("profesor", "987654321"));

	}

}
