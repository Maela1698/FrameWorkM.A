    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1966.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import etu1966.framework.Mapping;
import etu1966.framework.ModelView;
import generalisation.annotations.Url;
import etu1966.framework.FrameMethodUtil;
import java.lang.reflect.Field;
import jakarta.servlet.RequestDispatcher;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;


/**
 *
 * @author MAELA
 */
public class FrontServlet extends HttpServlet {
    HashMap<String,Mapping> MappingUrls;
    List<Class> modelClasses;

    public List<Class> getModelClasses() {
        return modelClasses;
    }

    public void setModelClasses(List<Class> modelClasses) {
        this.modelClasses = modelClasses;
    }

    public HashMap<String, Mapping> getMappingUrls() {
        return this.MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> MappingUrls){
        this.MappingUrls = MappingUrls;
    }
    

        
       
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */

    public void init() throws ServletException {
        try {
            HashMap<String, Mapping> MappingUrls = new HashMap<>();
            this.setMappingUrls(MappingUrls);
//            Set<String> allKey = this.getMappingUrls().keySet();
            List<Class> allClass = FrameMethodUtil.getClassesInPackage("model");  
            this.setModelClasses(allClass);
            this.formHashMapAllPkClasses(allClass);
            int indice = 0;
            HashMap<String, Mapping> allHashMap = this.getMappingUrls();
//            for (Map.Entry<String, Mapping> entry : allHashMap.entrySet()) {
//                String key = entry.getKey();
//                String classe = entry.getValue().getClassName();
//                String method = entry.getValue().getMethod();
//                System.out.println("Clé : " + key + ", Class : " + classe + ", Method : " + method);
        } catch (IOException ex) {        
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void formHashMapAllPkClasses(List<Class> allClass) throws IOException, ClassNotFoundException{
        for(int i=0; i<allClass.size(); i++){
            this.formHashMapOneClass(allClass.get(i));  
        }
    }
    
    public void formHashMapOneClass(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Url.class)) {
                Mapping mapping = new Mapping();
                mapping.setClassName(clazz.getSimpleName());
                mapping.setMethod(method.getName());
                String key = method.getAnnotation(Url.class).valeur();
                this.getMappingUrls().put(key, mapping);
            }
        }
    }
    
    public String getUrl(HttpServletRequest request) {
        String result;
        String contextPath = request.getContextPath();
        String url = request.getRequestURI();
        result = url.split(contextPath)[1];
        String query = request.getQueryString();
        return result;
    }
   
    public Method getMethodFromUrl(String url) throws Exception {
        List<Class> lc = getModelClasses();
        for (Class c : lc) {
            if (c.getSimpleName().equals(getMappingUrls().get(url).getClassName())) {
                for (Method m : c.getDeclaredMethods()) {
                    if (m.getName().equals(getMappingUrls().get(url).getMethod())){
                        return m;
                    }
                }
            }
        }
        throw new Exception("Method not found");
    }
    
    
    
    public Class getClassFromUrl(String url) throws Exception {    
        List<Class> lc = getModelClasses();
        for (Class c : lc) {
            if (c.getSimpleName().equals(getMappingUrls().get(url).getClassName())) {
                for (Method m : c.getDeclaredMethods()) {
                    if (m.getName().equals(getMappingUrls().get(url).getMethod())){
                        return c;
                    }
                }
            }
        }
        throw new Exception("Class not found");
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<h1><u> Url </u>at haha " + getUrl(request) + "</h1>");
            Method m = getMethodFromUrl(getUrl(request));   //get the method that correspond to the url key
            Parameter[] mParameters = m.getParameters();    //les parametres du methode 
//            for(Parameter param : mParameters){
//                System.out.println(param.getName());
//            }
            System.out.println("La methode "+ m.getName());
            Class c = getClassFromUrl(getUrl(request)); //get the class that correspond to the url key 
            System.out.println("La classe "+ c.getSimpleName());
            Object object = c.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Field[] attributes = c.getDeclaredFields(); // get allFields of the class 
            Map<String, String[]> parameters = request.getParameterMap();
            for(String key : parameters.keySet()){
                for(Field attribut : attributes){
                    if(key.equals(attribut.getName())){
                        System.out.println("ok ao  izy");
                        FrameMethodUtil.setValeur(attribut, c, parameters, key, object);
                    }
                }
            }
            String[] methodArgument = FrameMethodUtil.formMethodArgument(mParameters,parameters);
            Object o = new Object();
            if(methodArgument != null){                         //si methodeArgument est different de nulle then Sprint8 (fonction avec argument)
                o = m.invoke(object,methodArgument);
            }
            else{
                o = m.invoke(object,new Object[0]);         //sinon : sprint7 (fonction sans argument)
            }
            this.dispatchToView(request, response, o);   //dispatch   
        }
    }
    //function to redirect page to the view set in the ModelView
    public void dispatchToView(HttpServletRequest request, HttpServletResponse response,Object o)throws ServletException, IOException, Exception {
        if (o instanceof ModelView) { 
            ModelView mv = (ModelView)o;
            HashMap<String,Object> data = mv.getData();                   //getter tous les dataa(hashMap) du modelView mv
            for (Map.Entry<String, Object> entry : data.entrySet()) {    //boucler le data et setter attribute pour chaque element          
                request.setAttribute(entry.getKey(), entry.getValue());
                System.out.println(entry.getKey()+ ","+ entry.getValue());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(mv.getView());
            dispatcher.forward(request, response);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
