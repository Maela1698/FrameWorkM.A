/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import generalisation.connection.DBConnection;
import generalisation.genericDAO.genericDAO;
import java.util.List;
import generalisation.utils.FrameMethodUtil;
import java.sql.Connection;
import model.Person;
/**
 *
 * @author MAELA
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, Exception {
//        List<Class> allClass = FrameMethodUtil.getClassesInPackage("model");
//        for(int i=0;i<allClass.size();i++){
//            System.err.println(allClass.get(i).getSimpleName());
//        }
        Person test = new Person();
        List<Person> objets = genericDAO.getAll(test, null, null);
        for (int i = 0; i < objets.size(); i++) {
            System.out.println((objets.get(i)).getNom());
        }
    }
}