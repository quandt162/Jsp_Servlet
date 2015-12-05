/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao;

import com.test.entity.News;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewsDao {
    public List<News> getList(){
        System.out.println("Goi vao co so du lieu!!!!");
        List<News> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            News news = new News(new BigDecimal(i), "Tin tuc "+i);
            list.add(news);
        }
        return list;
    }
}
