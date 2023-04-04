/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import etu1966.framework.ModelView;
import generalisation.annotations.Url;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

/**
 *
 * @author to
 */

@DBTable(name = "Olona")
public class Person {
/// Attributs
    @DBField(name = "idOlona", type = String.class)
    String id;
    
    @DBField(name = "nom", type = String.class)
    String nom;
    
    @DBField(name = "poids", type = Double.class)
    double poids;
    
/// Encapsulation

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
    
/// Constructeur

    public Person(String id, String nom, double poids) {
        this.id = id;
        this.nom = nom;
        this.poids = poids;
    }

    public Person() {
    }
    
    @Url(valeur="/testPerson")
    public ModelView testGUGU(){
        ModelView m = new ModelView("testAndrana.jsp");
        return m;
    }
    
    
}
