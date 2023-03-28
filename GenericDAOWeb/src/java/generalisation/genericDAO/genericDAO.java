/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generalisation.genericDAO;

import generalisation.annotations.DBField;
import java.sql.*;
import generalisation.connection.DBConnection;
import generalisation.utils.Query;
import generalisation.utils.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;



public class genericDAO {
    String prefix = "PER";
    int sizePK = 7;
    String nomFonction = "getSeqPersonne";

    public static Object[] getResultArguments(ResultSet resultat, Object objet) throws Exception {
        Field[] champs = objet.getClass().getDeclaredFields();
        Object[] arguments = new Object[champs.length];
        for (int i = 0; i < champs.length; i++) {
            if (champs[i].getAnnotation(DBField.class).type() == Integer.class) {
                arguments[i] = resultat.getInt(champs[i].getAnnotation(DBField.class).name());
            } else if (champs[i].getAnnotation(DBField.class).type() == Double.class) {
                arguments[i] = resultat.getDouble(champs[i].getAnnotation(DBField.class).name());
            } else if (champs[i].getAnnotation(DBField.class).type() == String.class) {
                arguments[i] = resultat.getString(champs[i].getAnnotation(DBField.class).name());
            } else if (champs[i].getAnnotation(DBField.class).type() == Date.class) {
                arguments[i] = resultat.getDouble(champs[i].getAnnotation(DBField.class).name());
            } else if (champs[i].getAnnotation(DBField.class).type() == Timestamp.class) {
                arguments[i] = resultat.getTimestamp(champs[i].getAnnotation(DBField.class).name());
            }
        }
        return arguments;
    }

    public static List<Object> executeQuery(String sql, Object objet, Connection connection) throws Exception {
        // Execution d'une selection
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = connection.createStatement();
            System.out.println(sql);
            resultat = statement.executeQuery(sql);

            List<Object> listes = new ArrayList<>();
            while (resultat.next()) {
                Constructor construct = Util.getClassConstructor(objet);
                Object[] arguments = genericDAO.getResultArguments(resultat, objet);
                listes.add(construct.newInstance(arguments));
            }
            return listes;
        } catch (Exception e) {
            throw e;
        } finally {
            statement.close();
            if (resultat != null) {
                resultat.close();
            }
        }
    }

    public static <T extends Object>List getAll(T objet, String suppl, Connection connection) throws Exception {
        // selection de tous les objets dans un table
        try {
            String sql = Query.getAllQuery(objet, suppl);
            int closeIndice = 1;    // 0 si on doit le fermer et 1 sinon
            if (connection == null) {
                closeIndice = 0;
                connection = DBConnection.getConnection();
            }

            List<T> listes = (List<T>)genericDAO.executeQuery(sql, objet, connection);
            if (closeIndice == 0) {
                connection.close();
            }
            
            return listes;
        } catch (Exception e) {
            e.printStackTrace();
            connection.close();
        }
        return null;
    }
}
