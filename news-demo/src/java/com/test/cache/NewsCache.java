/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.cache;

import com.test.dao.NewsDao;
import com.test.entity.News;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewsCache {
    public static HashMap<String, List<News>> hmListNews = new HashMap<>();
    public static List<News> getList(String key){
        if(hmListNews.get(key) != null) return hmListNews.get(key);
        else{
            NewsDao newsDao = new NewsDao();
            List<News> listRs = newsDao.getList();
            hmListNews.put("GET_ALL", listRs);
            return listRs;
        }
    }
}
