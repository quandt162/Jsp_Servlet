/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.dao;

import com.news.constant.Constants;
import com.news.database.DBPoolX;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public abstract class BaseDao implements Serializable {

    protected DBPoolX poolX = null;

    protected BaseDao() {
        try {
            poolX = DBPoolX.getInstance(Constants.DATABASE);
        } catch (Exception dbnf) {
            dbnf.printStackTrace();
        }

    }

    protected Connection getConnection() {
        return poolX.getConnection();
    }

    protected void releaseConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        poolX.releaseConnection(conn, stmt, rs);
    }

    protected void releaseConnection(Connection conn, PreparedStatement stmt) {
        poolX.releaseConnection(conn, stmt);
    }

    public DBPoolX getPoolX() {
        return poolX;
    }

    public void setPoolX(DBPoolX poolX) {
        this.poolX = poolX;
    }

    public String getSequeceValue(String sequence) throws Exception {
        Connection connection = null;
        try {
            connection = getConnection();
            Integer nextValue = Integer.parseInt(DBPoolX.getSequenceValue(connection, sequence, true)) + 1;
            return nextValue.toString();
            
        } finally {
            releaseConnection(connection, null);
        }
    }
}
