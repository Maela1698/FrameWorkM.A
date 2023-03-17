/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generalisation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import readerxml.ReadXml;
/**
 *
 * @author to
 */
public class DBConnection {
    public static Connection getConnection() throws Exception {     
        // Fonction qui renvoie la connection vers la base : 
            ReadXml reader = new ReadXml();
            reader.setter();
            String database = reader.getDatabase();       // Nom de la base
            String user = reader.getUser();       // User dans postgres
            String mdp = reader.getPassword();       // Mot de passe

            
            // Charge la classe de driver
            Class.forName("org.postgresql.Driver");
            
            // Creation de l'objet de connection
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + database, user,  mdp);
            
            connection.setAutoCommit(false);
            return connection;
    }
}
