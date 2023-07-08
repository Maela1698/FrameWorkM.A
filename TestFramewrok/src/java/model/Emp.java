/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import etu1966.framework.ModelView;
import etu1966.annotations.Scope;
import etu1966.annotations.Url;

/**
 *
 * @author andri
 */
@Scope
public class Emp {
    String name;
    String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Emp() {
    }
    
    @Url(valeur="/addSessionEmp")
    public ModelView addSessionEmp(){
        ModelView view = new ModelView("addSession.jsp");
        view.addSession("idEmp","EMP1090");
        return view;
    }
    
   
    
    
}
