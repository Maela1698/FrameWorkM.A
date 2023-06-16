/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1966.framework;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
    
    public static void setValeur(Field attribut,Class c,  Map<String, String[]> parameters, String parameter,Object object) throws IllegalAccessException, InvocationTargetException{
        String methodName = "set"+attribut.getName().toLowerCase();  //methode setter d'un attribut de classe
        Method setter = FrameMethodUtil.getSetMethod(c, methodName);
        String[] valeur = parameters.get(parameter); //
        setter.invoke(object, valeur);
    }

    //former les arguments dont une fonction a besoin
    public static String[] formMethodArgument(Parameter[] mParameters, Map<String, String[]> requestParameters) {
        List<String> arguments = new ArrayList<>();
        for(Parameter mParameter : mParameters ){
            for(String requestParameter : requestParameters.keySet()){
                if(mParameter.getName().equals(requestParameter)){
                    arguments.add(requestParameters.get(requestParameter)[0]);
                }
            }
        }
        String[] trueArguments = new String[arguments.size()];
        int indexTrueArguments = 0;
        for(String argument : arguments){
            trueArguments[indexTrueArguments] =argument;
            indexTrueArguments ++;
        }
        return trueArguments;
    }
    
}
