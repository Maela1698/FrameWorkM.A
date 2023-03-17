/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1966.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import etu1966.framework.Mapping;
import generalisation.annotations.Url;
import generalisation.utils.FrameMethodUtil;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MAELA
 */
public class FrontServlet extends HttpServlet {
    HashMap<String,Mapping> MappingUrls;

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
            Set<String> allKey = this.getMappingUrls().keySet();
            List<Class> allClass = FrameMethodUtil.getClassesInPackage("model");  
            this.formHashMapAllPkClasses(allClass);
            int indice = 0;
           HashMap<String, Mapping> allHashMap = this.getMappingUrls();
            for (Map.Entry<String, Mapping> entry : allHashMap.entrySet()) {
                String key = entry.getKey();
                String classe = entry.getValue().getClassName();
                String method = entry.getValue().getMethod();
                System.out.println("Clé : " + key + ", Class : " + classe + ", Method : " + method);
}

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
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = request.getRequestURL().toString();
            String[] splitUrl = url.split("/");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Servlet name:" + splitUrl[3] + "</h1>");
            out.println("<h2> Url:" + url + "</h2>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
