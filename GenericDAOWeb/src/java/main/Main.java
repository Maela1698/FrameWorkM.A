/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.List;
import generalisation.utils.FrameMethodUtil;
/**
 *
 * @author MAELA
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        List<Class> allClass = FrameMethodUtil.getClassesInPackage("model");
        for(int i=0;i<allClass.size();i++){
            System.err.println(allClass.get(i).getSimpleName());
        }
    }
}
