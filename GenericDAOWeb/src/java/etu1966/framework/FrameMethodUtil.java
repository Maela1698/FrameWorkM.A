/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1966.framework;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author M.Andriamahery
 */
public class FrameMethodUtil {
     public static List<Class> getClassesInPackage(String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File directory = new File(classLoader.getResource(path).getFile());
        if (directory.exists()) {
            String[] files = directory.list();
            for (String file : files) {
                if (file.endsWith(".class")) {
                    String className = packageName + "." + file.substring(0, file.length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        } else {
            throw new ClassNotFoundException("Package " + packageName + " not found.");
        }
        return classes;
    }
    
    public static Method getSetMethod(Class c, String methodName){
        for(Method m : c.getDeclaredMethods()){
            if(m.getName().equals(methodName)){
                return m;
            }
        }
        return null;
    }
    
    public static String formMethodName(String field){
        String strCapitalized = field.substring(0,1).toUpperCase() + field.substring(1);
        return "set"+strCapitalized;
    }
    
    
    
    public static void setValeur(Field attribut,Class c,  Map<String, String[]> parameters, String parameter,Object object) throws IllegalAccessException, InvocationTargetException{
        String methodName = FrameMethodUtil.formMethodName(attribut.getName());
        Method setter = FrameMethodUtil.getSetMethod(c, methodName);
        String[] valeur = parameters.get(parameter);
        Object set = setter.invoke(object, valeur);
    }
    
}
