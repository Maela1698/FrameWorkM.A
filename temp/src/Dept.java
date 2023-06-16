/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import generalisation.annotations.Url;
import etu1966.framework.ModelView;
import java.util.HashMap;

/**
 *
 * @author MAELA
 */
public class Dept {
    String nom;
    String num;

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
    
  

    public Dept(String nom, String num) {
        this.setNom(nom);
        this.setNum(num);
    }

    public Dept(){ }
    
    @Url(valeur="/testDept")
    public ModelView testhaha(){
        ModelView m = new ModelView("form.jsp");
        String test = "tonga iany ity";
        String key = "testKey";
        m.addItem(key, test);
        return m;
    }
    
    @Url(valeur="/saveDept")
    public void save(){
        System.out.println("le nom:"+ this.getNom());
        System.out.println("le num:"+ this.getNum());
    }
    
    @Url(valeur="/form8")
    public ModelView testSprint8(){
        ModelView m = new ModelView("form8.jsp");
        String test = "Sprint8";
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
    
    
}
