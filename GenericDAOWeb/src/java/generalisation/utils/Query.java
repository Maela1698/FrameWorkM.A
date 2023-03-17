/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generalisation.utils;

import generalisation.annotations.DBTable;

/**
 *
 * @author to
 */
public class Query {
    // Ce classe est resposable de tous les constructions de requete
    
    public static String getAllQuery(Object objet, String suppl) {
        if (suppl == null) suppl = "";
        
        String sql = "SELECT * FROM " + objet.getClass().getAnnotation(DBTable.class).name() + " " + suppl;
        return sql;
    }
}
