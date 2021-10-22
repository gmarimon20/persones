/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaumebalmes.personesxml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.Attr;
/**
 *
 * @author claudi & gerard
 */
public class Main {
    
    static Persona llista[] = new Persona[4];
    static Persona llistaRecuperada[] = new Persona[4];
    
    public static void main(String[] args) {
        
        creaPersones();
        
        recuperaPersones();
        
        creaXML();
        
        
                
    }
    
    private static void crearElement(String dada, String valor, Element arrel, Document doc){
        Element e = doc.createElement(dada);
	Text text = doc.createTextNode(valor);
	arrel.appendChild(e);
	e.appendChild(text);
    }
    
    private static void creaPersones(){
                
        llista[0] = new Persona("Pedro", "Martínez", 26, 664485132);
        llista[1] = new Persona("Miguel", "Navarro", 43, 651874523);
        llista[2] = new Persona("Jordina", "Pujol", 35, 648153244);
        llista[3] = new Persona("Gerard", "Piqué", 36, 618475551);
        
        
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("persones.bin"))){
            
            for (Persona i : llista)    
                os.writeObject(i);
            
            os.close();
        }catch(Exception ex){
            System.out.println("Error de escriptura. :( " + ex);
        }
    }
    
    private static void recuperaPersones(){
                
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persones.bin"))){ 
            
            for (int i = 0; i < llistaRecuperada.length; i++) {
                Persona temp = (Persona)ois.readObject();
                llistaRecuperada[i] = new Persona (temp.getName(),null,temp.getAge(),0); 
                //llista[i] = (Persona)ois.readObject(); // Alternativa agafant tots els atributs guardats.
            }
                        
            ois.close();
        }catch(Exception ex){
            System.out.println("Error de lectura. :S " + ex);
        }
    }
    
    private static void creaXML(){
        try (FileWriter writer = new FileWriter("persones.xml")) {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
            Document document = builder.newDocument(); 
            document.setXmlVersion("1.0"); 
            
            Element arrel = document.createElement("Persones");
            document.appendChild(arrel);
            
            int cnt = 1;
            
            for(Persona p : llistaRecuperada){
                Element persona = document.createElement("Persona");
                arrel.appendChild(persona);
                
                persona.setAttribute("id", ""+cnt);
                cnt++;
                
                crearElement("Nom", p.getName(), persona, document);
                crearElement("Edat", ""+p.getAge(), persona, document);
            }
            
            Source source = new DOMSource(document);
            Result result = new StreamResult(writer);
            
            Transformer transformerFactory= TransformerFactory.newInstance().newTransformer();
            transformerFactory.setOutputProperty(OutputKeys.INDENT, "yes");
            transformerFactory.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformerFactory.transform(source, result);
            
            Result print = new StreamResult(System.out);
            transformerFactory.transform(source, print);
                
        }catch(Exception e){
            System.out.println("Error! :c" + e);
        }
    }
    
}
