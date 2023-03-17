/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalisation.utils;
    import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MAELA
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

}
