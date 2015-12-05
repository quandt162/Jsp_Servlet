/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author lampt
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //get input from user
        String userID=request.getParameter("txtUserID");
        String pwd=request.getParameter("txtPassword");
        
        //connect to DB
        Connection con = Helper.getConnection();        
        //validate the acc
        String sql="SELECT * FROM [USER] "+
                   "WHERE UserID='"+userID+"' AND Password='"+pwd+"'";
        out.println(sql);
        boolean isLogin=false;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                //valid acc
                isLogin=true;
            }
            else{
                //acc is NOT valid
                isLogin=false;            
            }
            rs.close();
            con.close();  
        }
        catch(SQLException ex){
            out.println(ex);
        }                   
        //display result
        if(isLogin){
            //send outpuit to user       
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Servlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h2><i>Hello user:</i></h2>"+userID);               
                out.println("</body>");
                out.println("</html>");
            } finally {            
                out.close();
            }
        }
        else{
        try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Servlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h2><i>Invalid account information!</i></h2>");               
                out.println("</body>");
                out.println("</html>");
            } finally {            
                out.close();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
