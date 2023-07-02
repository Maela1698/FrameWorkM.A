/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import etu1966.annotations.Auth;
import etu1966.annotations.session;
import etu1966.framework.ModelView;
import etu1966.annotations.Url;
import etu1966.annotations.Scope;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MAELA
 */
@Scope()
public class Dept {
    String nom;
    String num;
    String[] langue;
    HashMap<String,Object> session;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }  
    
    

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String[] getLangue() {
        return langue;
    }

    public void setLangue(String[] langue) {
        this.langue = langue;
    }

    public HashMap<String, Object> getSession() {
        return session;
    }

    public void setSession(HashMap<String, Object> session) {
        this.session = session;
    }
    
    
    
  

    public Dept(String nom, String num, String[] langue) {
        this.setNom(nom);
        this.setNum(num);
        this.setLangue(langue);
    }

    public Dept(){ 
        HashMap<String, Object> allSession = new HashMap<>();
        this.setSession(allSession);
    }
    
    @Url(valeur="/testDept")
    public ModelView testhaha(){
        ModelView m = new ModelView("form.jsp");
        String test = "tonga iany ity";
        String key = "testKey";
        m.addItem(key, test);
        return m;
    }
    
    //Test Sprint7
    @Url(valeur="/saveDept")
    public void save(){
        System.out.println("le nom mety: "+ this.getNom());
        System.out.println("le num mety:"+ this.getNum());
        String[] langue = this.getLangue();
        int i=0;
        for(String oneLangue : langue){
            System.out.println("lange "+i+ " "+oneLangue);
            i++;
        }
    }

  
    //Test Sprin8
    @Url(valeur="/form8")
    public ModelView testSprint8(){
        ModelView m = new ModelView("form8.jsp");
        String test = "Sprint8 Test";
        String key = "cleSprint8";
        m.addItem(key, test);
        return m;
    }
    
    @Url(valeur="/saveDeptWithAttribut")
    public void update(String laharana,String anarana){
        System.out.println("Sprint8");
        System.out.println("laharana"+laharana);
        System.out.println("anarana"+anarana);
    }
    
    @Url(valeur="/testEmp")
    @Auth
    public ModelView getListEmp(){
        ModelView m = new ModelView("listEmp.jsp");
        String test = "key";
        String key = "You can access to this getListEmp() method in Dept Class";
        m.addItem(key, test);
        return m;
    }
    
    @Url(valeur="/seConnecter")
    public ModelView seConnecter(){
        ModelView m = new ModelView("form8.jsp");
        m.addItem("testConnecion","Huhu");
        m.addSession("isConnected",true);
        return m;
    }
    
    @Url(valeur="/deleteEmp")
    @Auth("admin")
    public ModelView deleteEmp(){
        ModelView m = new ModelView("deleteEmp.jsp");
        String key = "deleteEmp";
        String value = "You can access to this deleteEmp() method in Dept Class";
        m.addItem(key,value);
        return m;
    }
    
    @Url(valeur="/seConnecterAdmin")
    public ModelView seConnecterAdmin(){
        ModelView m = new ModelView("form8.jsp");
        m.addSession("isConnected",true);
        m.addSession("profile","admin");
        return m;
    }
    
    @session
    @Url(valeur="/reservationTerrain")
    public ModelView reservationTerrain(){
        ModelView view = new ModelView("reservationTerrain.jsp");
        HashMap<String,Object> allSessions = this.getSession();                 //charger tous les sesssion de qu'on a ajouter dans cette classe
        String key = "testSprint12";
        System.out.println("tous les sessions dans le serveur:"+allSessions);
        String value = (String)allSessions.get("kindy");
        
        view.addItem(key, value);
        return view;
    }
    
    @Url(valeur="/addSessionEmp")
    public ModelView addSessionEmp(){
        ModelView view = new ModelView("addSessionEmp.jsp");
        String huhu = "EMP1902";
        view.addSession("kindy", huhu);
        return view;
    }
}
