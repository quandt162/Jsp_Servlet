package com.news.database;

import inet.util.Encrypter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.*;
import java.util.*;
import snaq.db.ConnectionPoolManager;

public class DBPoolX {

    public static ConnectionPoolManager poolManager;
    public String poolName;

    static {
        try {
            init();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public DBPoolX() throws Exception {
        init();
    }

    public DBPoolX(String poolName) throws Exception {

        if (poolManager == null) {
            init();
        }

        this.poolName = poolName;
    }

    public static void init() throws Exception {
        try {
            File file = new File("dbpool.propertiesExt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

            Properties properties = new Properties();
            properties.load(DBPoolX.class.getResourceAsStream("/com/news/configuration/dbpool.properties"));
            Enumeration e = properties.propertyNames();

            while (e.hasMoreElements()) {
                String data = "";
                String value = "";
                String key = (String) e.nextElement();
                if (key.contains("password")) {
                    if(properties.getProperty(key) == null || "".equals(properties.getProperty(key))) value = "";
                    else value = Encrypter.decrypt(properties.getProperty(key));
                } else {
                    value = properties.getProperty(key);
                }
                data = key + "=" + value;
                bw.write(data);
                bw.newLine();
            }

            bw.close();
            poolManager = ConnectionPoolManager.getInstance(file);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public static DBPoolX getInstance(String poolName) throws Exception {
        return new DBPoolX(poolName);
    }

    // Remove and close all connections in pool
    public static void releaseAll() {
        poolManager.release();
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = poolManager.getConnection(poolName, 60000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection conn, PreparedStatement preStmt) {
        try {
            if (preStmt != null) {
                preStmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void releaseConnection(Connection conn, PreparedStatement preStmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }

        releaseConnection(conn, preStmt);
    }

    public void releaseConnection(Connection conn, PreparedStatement preStmt, Statement stmt, ResultSet rs) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
        }

        releaseConnection(conn, preStmt, rs);
    }

    public static String getSequenceValue(Connection cn, String sequenceName,
            boolean bAutoCreate) throws Exception {
        // SQL command to sequence value
        String strSQL = "SELECT " + sequenceName + ".NEXTVAL FROM DUAL";

        // Get query data
        ResultSet rs = null;
        Statement stmt = null;
        try {
            stmt = cn.createStatement();
            rs = stmt.executeQuery(strSQL);
            rs.next();
            String strReturn = rs.getString(1);
            rs.close();
            stmt.close();
            return strReturn;
        } catch (Exception e) {
            if (e.getMessage() != null
                    && e.getMessage().startsWith("ORA-02289")) {
                if (!bAutoCreate) {
                    throw new Exception("getSequenceValue");
                } else {
                    stmt = cn.createStatement();
                    stmt.executeUpdate("CREATE SEQUENCE " + sequenceName
                            + " START WITH 2");
                    stmt.close();
                    return "1";
                }
            } else {
                throw e;
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
//        System.out.println("Encrypter.encrypt(\"yte\")="+Encrypter.encrypt("thuoc"));
//        System.out.println(Encrypter.decrypt("rRhG3MrMguo="));
        System.out.println(Encrypter.encrypt("noithat##2015"));
//        DBPoolX poolX = DBPoolX.getInstance(Constants.DATABASE);
//        if(poolX.getConnection() != null) System.out.println("success");
//        else System.out.println("fail");
    }
}
