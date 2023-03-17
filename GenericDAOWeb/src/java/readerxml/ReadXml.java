/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerxml;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;   
import java.util.Vector;

/**
 *
 * @author MAELA
 */
public class ReadXml {
    String user;
    String password;
    String database;
    String port;
    File file = new File("D:\\bosy\\Final\\GenericDAO\\src\\config\\config.xml");

    public ReadXml(String user, String password, String database, String port) {
        this.user = user;
        this.password = password;
        this.database = database;
        this.port = port;
    }
    
    

    public ReadXml() {
    }
    
    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    public Document prepareDoc(){
        Document doc = null ;
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();  
            doc = db.parse(this.file);
            doc.getDocumentElement().normalize();
            return doc;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return doc;
    }
    
    public void setter(){
        Document doc = prepareDoc();
        NodeList list = doc.getElementsByTagName("dbconnection");
        setterBoucle(list);
    }
    
    public void setterBoucle(NodeList list){
        Node node = list.item(0);
        if(node.getNodeType()== Node.ELEMENT_NODE){
            Element eElement = (Element)node;
            this.setUser(eElement.getElementsByTagName("user").item(0).getTextContent());
            this.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
            this.setDatabase(eElement.getElementsByTagName("database").item(0).getTextContent());
            this.setPort(eElement.getElementsByTagName("port").item(0).getTextContent());
        }
    }
    
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ReadXml reader = new ReadXml();
            reader.setter();
            System.out.print(reader.getPort());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
