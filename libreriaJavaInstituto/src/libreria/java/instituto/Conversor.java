package libreria.java.instituto;
/**
 * Clase para trabajar con ficheros xml
 * @author carlos
 * @version 1.0
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Conversor {
	
	/**
	 * Método para convertir un arrayList de profesores en un archivo xml
	 * @param profesores
	 */		
	public void profesoresToXml(ArrayList<Profesor> profesores) {
		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db= dbf.newDocumentBuilder();
		Document document = db.newDocument();
		Element elementoRaiz = document.createElement("profesores");
		document.appendChild(elementoRaiz);
		Element profesor;
		for (Profesor  p: profesores) {
			String dni = p.getDni();
			String nombre = p.getNombre();
			String telefono = p.getTelefono();
			profesor = document.createElement("profesor");
			profesor.setAttribute("dni", dni);
			profesor.setAttribute("nombre", nombre);
			profesor.setAttribute("telefono", telefono);
			elementoRaiz.appendChild(profesor);
		}
		FileWriter fileWriter = new FileWriter("src/profesores.xml");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
    	transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    	DOMSource domSource = new DOMSource(document);
    	StreamResult streamResult = new StreamResult(fileWriter);
    	transformer.transform(domSource, streamResult);
			
		} catch (ParserConfigurationException e) {
        	e.printStackTrace();
    	} catch (IOException e) {
        	throw new RuntimeException(e);
    	} catch (TransformerConfigurationException e) {
        	throw new RuntimeException(e);
    	} catch (TransformerException e) {
        	throw new RuntimeException(e);
    	}
		
	}
	
	/**
	 * Método para convertir un arrayList de profesores en un archivo xml
	 * @param alumnos
	 */
	public void alumnoToXml(ArrayList<Alumno> alumnos) {
		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db= dbf.newDocumentBuilder();
		Document document = db.newDocument();
		Element elementoRaiz = document.createElement("alumnos");
		document.appendChild(elementoRaiz);
		Element alumno;
		for (Alumno  p: alumnos) {
			int numMatricula = p.getNumMatrícula();
			String nombre = p.getNombre();
			String telefono = p.getTelefono();
			String fechaNacimiento= p.getFechaNacimiento();
			alumno = document.createElement("alumno");
			alumno.setAttribute("numMatricula", Integer.toString(numMatricula));
			alumno.setAttribute("nombre", nombre);
			alumno.setAttribute("FechaNacimiento", fechaNacimiento);
			alumno.setAttribute("telefono", telefono);
			elementoRaiz.appendChild(alumno);
		}
		FileWriter fileWriter = new FileWriter("src/alumnos.xml");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
    	transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    	DOMSource domSource = new DOMSource(document);
    	StreamResult streamResult = new StreamResult(fileWriter);
    	transformer.transform(domSource, streamResult);
			
		} catch (ParserConfigurationException e) {
        	e.printStackTrace();
    	} catch (IOException e) {
        	throw new RuntimeException(e);
    	} catch (TransformerConfigurationException e) {
        	throw new RuntimeException(e);
    	} catch (TransformerException e) {
        	throw new RuntimeException(e);
    	}
		
	}
	
	/**
	 * Método para convertir un arrayList de asignaturas en un archivo xml
	 * @param asignaturas
	 */
	public void asignaturatoXml(ArrayList<Asignatura> asignaturas) {
		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db= dbf.newDocumentBuilder();
		Document document = db.newDocument();
		Element elementoRaiz = document.createElement("asignaturas");
		document.appendChild(elementoRaiz);
		Element asignatura;
		for (Asignatura  p: asignaturas) {
			int codAsignatura = p.getCodAsignatura();
			String nombre = p.getNombre();
			String profesor = p.getProfesor();
			int dniProf = p.getDniProfesor();
			asignatura = document.createElement("asignatura");
			asignatura.setAttribute("codAsignatura", Integer.toString(codAsignatura));
			asignatura.setAttribute("nombre", nombre);
			asignatura.setAttribute("profesor", profesor);
			asignatura.setAttribute("dniProfesor", Integer.toString(dniProf));
			elementoRaiz.appendChild(asignatura);
		}
		FileWriter fileWriter = new FileWriter("src/asignaturas.xml");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
    	transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    	DOMSource domSource = new DOMSource(document);
    	StreamResult streamResult = new StreamResult(fileWriter);
    	transformer.transform(domSource, streamResult);
			
		} catch (ParserConfigurationException e) {
        	e.printStackTrace();
    	} catch (IOException e) {
        	throw new RuntimeException(e);
    	} catch (TransformerConfigurationException e) {
        	throw new RuntimeException(e);
    	} catch (TransformerException e) {
        	throw new RuntimeException(e);
    	}
		
	}
	/**
	 * Metodo para insertar la informacion de alumnos de un archivo xml en la base de datos
	 * @return
	 */
	public String xmlToSqlAlumnos() {
		String consultaSql="";
		try {
            consultaSql = "INSERT INTO alumno VALUES";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse("src/alumnos.xml");
            NodeList listaNodos = documento.getElementsByTagName("alumno");

            for (int i = 0; i < listaNodos.getLength(); i++) {
                String nombre = listaNodos.item(i).getAttributes().getNamedItem("nombre").getNodeValue();
                String matricula = listaNodos.item(i).getAttributes().getNamedItem("numMatricula").getNodeValue();
                String fechaN = listaNodos.item(i).getAttributes().getNamedItem("FechaNacimiento").getNodeValue();
                String telefono = listaNodos.item(i).getAttributes().getNamedItem("telefono").getNodeValue();

                // Genera la consulta SQL para insertar los datos en la tabla
                String fila = "('" + matricula + "', '" + nombre + "', '" + fechaN + "', '" + telefono + "')";
                consultaSql += fila + ", ";
                
            }
            consultaSql=consultaSql.substring(0, consultaSql.length()-2);
            return consultaSql;		

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
        return consultaSql;
	}
	/**
	 * Método par insertar la información de profesores de un archivo xml en la base de datos
	 * @return
	 */
	public String xmlToSqlProfesores() {
		String consultaSql="";
		try {
            consultaSql = "INSERT INTO profesor VALUES";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse("src/profesores.xml");
            NodeList listaNodos = documento.getElementsByTagName("profesor");

            for (int i = 0; i < listaNodos.getLength(); i++) {
                String dni = listaNodos.item(i).getAttributes().getNamedItem("dni").getNodeValue();
                String nombre = listaNodos.item(i).getAttributes().getNamedItem("nombre").getNodeValue();
                String telefono = listaNodos.item(i).getAttributes().getNamedItem("telefono").getNodeValue();

                // Genera la consulta SQL para insertar los datos en la tabla
                String fila = "('" + dni + "', '" + nombre + "', '" + telefono + "')";
                consultaSql += fila + ", ";
                
            }
            consultaSql=consultaSql.substring(0, consultaSql.length()-2);
            return consultaSql;


		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
        return consultaSql;
	}
	/**
	 * Método para insertar la informacion de asignatura de un archivo xml a la base de datos
	 * @return
	 */
	public String xmlToSqlAsignaturas() {
		String consultaSql="";
		try {
            consultaSql = "INSERT INTO asignatura VALUES";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse("src/asignaturas.xml");
            NodeList listaNodos = documento.getElementsByTagName("asignatura");

            for (int i = 0; i < listaNodos.getLength(); i++) {
                String nombre = listaNodos.item(i).getAttributes().getNamedItem("nombre").getNodeValue();
                String codAsignatura = listaNodos.item(i).getAttributes().getNamedItem("codAsignatura").getNodeValue();
                String dniProfesor = listaNodos.item(i).getAttributes().getNamedItem("dniProfesor").getNodeValue();
                String profesor = listaNodos.item(i).getAttributes().getNamedItem("profesor").getNodeValue();

                // Genera la consulta SQL para insertar los datos en la tabla
                String fila = "('" + codAsignatura + "', '" + nombre + "', '" + profesor + "', '" + dniProfesor + "')";
                consultaSql += fila + ", ";
                
            }
            consultaSql=consultaSql.substring(0, consultaSql.length()-2);
            return consultaSql;

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
        return consultaSql;
	}

}