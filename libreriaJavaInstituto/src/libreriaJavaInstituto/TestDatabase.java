package libreriaJavaInstituto;

import java.util.ArrayList;


public class TestDatabase {
	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		
		if(databaseConnection.connect("jdbc:mysql://localhost/instituto?" + "user=root&password=usuario"));
		
		DatabaseManager dataBaseManager = new DatabaseManager(databaseConnection.getConnection());
		System.out.println(databaseConnection.isConnected());
		ArrayList<Alumno> Alumno = new ArrayList<>();
		Alumno = dataBaseManager.getAlumnos();
		Alumno.stream().forEach(b->System.out.println(b));
		ArrayList<Profesor> Profesor = new ArrayList<>();
		Profesor = dataBaseManager.getProfesores();
		Profesor.stream().forEach(b->System.out.println(b));
	}

}
