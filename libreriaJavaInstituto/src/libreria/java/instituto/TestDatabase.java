package libreria.java.instituto;

import java.util.ArrayList;


public class TestDatabase {
	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		
		if(databaseConnection.connect("jdbc:mysql://localhost/instituto?" + "user=root&password=usuario"));
		
		DatabaseManager dataBaseManager = new DatabaseManager(databaseConnection.getConnection());
		System.out.println(databaseConnection.isConnected());
		
		ArrayList<Alumno> Alumnos = new ArrayList<>();
		Alumnos = dataBaseManager.getAlumnos();
		Alumnos.stream().forEach(b->System.out.println(b));
		
		ArrayList<Profesor> Profesor = new ArrayList<>();
		Profesor= dataBaseManager.getProfesores();
		Profesor.stream().forEach(b->System.out.println(b));
		
		ArrayList<Asignatura> Asignaturas = new ArrayList<>();
		Asignaturas = dataBaseManager.getAsignaturas();
		Asignaturas.stream().forEach(b->System.out.println(b));
		
		ArrayList<Recibe> Recibe = new ArrayList<>();
		Recibe = dataBaseManager.getRecibe();
		Recibe.stream().forEach(b->System.out.println(b));
		
		ArrayList<Alumno> Alumno = new ArrayList<>();
		Alumno = dataBaseManager.getAlumnos("numMatricula", 4);
		Alumno.stream().forEach(b->System.out.println(b));
		
		ArrayList<Asignatura> Asignatura = new ArrayList<>();
		Asignatura = dataBaseManager.getAsignatura("codAsignatura", "2");
		Asignatura.stream().forEach(b->System.out.println(b));
		
		Profesor = new ArrayList<>();
		Profesor = dataBaseManager.getProfesores("dni", "123456789");
		Profesor.stream().forEach(b->System.out.println(b));
		
		boolean borradoRegistros;
		System.out.println(borradoRegistros = dataBaseManager.deleteRegistro("profesor", "987654321"));
	}

}
