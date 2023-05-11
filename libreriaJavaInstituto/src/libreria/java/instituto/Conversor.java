package libreria.java.instituto;

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

public class Conversor {
		
	public void sqlToXml(ArrayList<Profesor> profesores) {
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
		FileWriter fileWriter = new FileWriter("profesores.xml");
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
	

}

