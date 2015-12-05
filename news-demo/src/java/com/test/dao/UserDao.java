/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao;

/**
 *
 * @author Admin
 */
public class UserDao {
    public boolean login(String username, String password){
        if("admin".equals(username) && "quan".equals(password)) return true;
        return false;
    }
}
