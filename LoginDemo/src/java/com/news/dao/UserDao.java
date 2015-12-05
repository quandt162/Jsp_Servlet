/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.dao;

import com.news.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Love JAV
 */
public class UserDao {
    public boolean login(String username, String password){
        if("admin".equals(username) && "admin".equals(password)) return true;
        return false;
    }
}
