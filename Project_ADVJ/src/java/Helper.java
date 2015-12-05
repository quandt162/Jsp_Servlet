/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lampt
 */
public class Helper {
    public static Connection getConnection(){
        Connection con=null;
        //load jdbc driver
        String driver="sun.jdbc.odbc.JdbcOdbcDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        //create connection
        String jdbc_url="jdbc:odbc:sales_dsn";
        try {
            //con = DriverManager.getConnection(jdbc_url);;//windows authen
            con = DriverManager.getConnection(jdbc_url,"sa","");//sql serrver authen
        } catch (SQLException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    } 
}
