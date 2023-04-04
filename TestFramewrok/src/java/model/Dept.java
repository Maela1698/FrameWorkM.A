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
    @Url(valeur="/testDept")
    public ModelView testhaha(){
        ModelView m = new ModelView("haha.jsp");
        String test = "test ihany ity";
        String key = "testKey";
        m.addItem(key, test);
        return m;
    }
}
