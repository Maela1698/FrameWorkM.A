/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1966.framework;

import java.util.HashMap;

/**
 *
 * @author MAELA
 */
public class ModelView {
    String view;
    HashMap<String,Object> data;
    HashMap<String,Object> session;

    public ModelView() {}
    
    public ModelView(String view) {
        this.setView(view);
        HashMap<String,Object> data = new HashMap<>();
        HashMap<String,Object> session = new HashMap<>();
        this.setData(data);
        this.setSession(session);
        
    }
    public String getView() {
        return view;
    }

    public void setView(String view){
        this.view = view;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public HashMap<String, Object> getSession() {
        return this.session;
    }

    public void setSession(HashMap<String, Object> session) {
        this.session = session;
    }
    
    public void addSession(String key,Object value){
        this.getSession().put(key, value);
    }
    
    public void addItem(String key,Object value){
        this.getData().put(key, value);
    }
}
