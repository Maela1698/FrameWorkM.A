/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generalisation.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author to
 */
public class Util {
    
    public static Constructor getClassConstructor(Object objet) throws Exception {
        Field[] champs = objet.getClass().getDeclaredFields();
        
        Class[] parametres = new Class[champs.length];
        for(int i = 0; i < parametres.length; i++) {
            parametres[i] = champs[i].getType();
        }
        
        Constructor result = objet.getClass().getConstructor(parametres);
        return result;
    }
    
    public static int getSequence(Connection connection,String nomFonction) throws Exception {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery("select " + nomFonction);
            if(resultat.next()) return resultat.getInt(1);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
            if (statement != null) statement.close();
            if (connection != null) {
                connection.rollback();
                connection.close();
            }
        }
        return 0;
    }
    
    public static String completerZero(int seq, int taillePrefix,int sizePK) {
        String sequence = String.valueOf(seq);
        int manquant = sizePK - taillePrefix - sequence.length();
        String complet = "";
        for(int i = 0; i < manquant; i++) {
            complet += "0";
        }
        return complet + sequence;
    }
    
    public static void setPrimaryKey(String valeur, Object objet) throws Exception {       // Fonction pour getter dans n'importe quel class
        String fonction = "setId";
        Class[] argument = new Class[1];
        argument[0] = valeur.getClass();
        Method method = objet.getClass().getDeclaredMethod(fonction, argument);     // trouve le fonction correspondant
        Object[] parametre = new Object[1];
        parametre[0] = valeur;
        Object resultat = method.invoke(objet, parametre);
    }
    
    public static String construirePK(Connection c,String nomFonction,String prefix,int sizePK,Object obj) throws Exception {     // Construit en string le cle primaire
        int seq = getSequence(c,nomFonction);
        String cle = prefix + completerZero(seq, prefix.length(),sizePK);
        setPrimaryKey(cle, obj);
        return cle;
    }
}
