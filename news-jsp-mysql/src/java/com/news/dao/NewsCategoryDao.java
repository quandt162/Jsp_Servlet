/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.dao;

import com.news.entity.NewsCategory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Love JAV
 */
public class NewsCategoryDao extends BaseDao{
    public boolean create(NewsCategory newsCategory){
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            String sql = "insert into news_category(name, url_friendly, gen_date)"
                    + "   values(?, ?, now())";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            int i = 1;
            ps.setString(i++, newsCategory.getName());
            ps.setString(i++, newsCategory.getUrlFriendly());
            
            return ps.executeUpdate() == 1;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            releaseConnection(conn, ps);
        }
        return false;
    }
    
   public boolean read(NewsCategory newsCategory){
       
       
       return false;
   }
    
   public boolean delete(NewsCategory newsCategory){
       Connection conn = null;
       PreparedStatement pstm = null;
       
       try{
           String sql = "delete NewsCategory where id = ?";
           conn = getConnection();
           pstm = conn.prepareStatement(sql);
           
           int i = 1;
           pstm.setBigDecimal(i, newsCategory.getId());
           
           return pstm.executeUpdate()== 1;
       }catch(Exception ex){
           ex.printStackTrace();
       }finally{
           releaseConnection(conn, pstm);
       }
       return false;
   }
    public boolean update(NewsCategory newsCategory){
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            String sql = "update NewsCategory "
                    + "   set name = ?, urlFriendly =?"
                    + "   where id = ?";
            conn = getConnection();
            pstm = conn.prepareStatement(sql);
            
            int i = 1;
            pstm.setString(i++, newsCategory.getName());
            pstm.setString(i++, newsCategory.getUrlFriendly());
            pstm.setBigDecimal(i++, newsCategory.getId());
            
            return pstm.executeUpdate() == 1;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            releaseConnection(conn, pstm);
        }
        return false;
    }
   
    
    public List<NewsCategory> find(int rowsPerPage, int currentPage,String name, String urlFriendly){
        
        int startRow = (currentPage -1) * rowsPerPage;
        int stopRow  = currentPage * rowsPerPage;
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<NewsCategory> list = null;
        
        try{
            Vector vParam = new Vector();
            String sqlBonus = "";
            if(name != null && !"".equals(name)){
                sqlBonus = " and upper(name) like concat('%',upper(?),'%')";
                vParam.add(name);
            }
            if(urlFriendly != null && !"".equals(urlFriendly)){
                sqlBonus = " and upper(url_friendly) like concat('%',upper(?),'%')";
                vParam.add(urlFriendly);
            }
            
            String sql = "select id, name, url_friendly, gen_date"
                    + "   from news_category"
                    + "   where 1 = 1 " + sqlBonus
                    + "   limit ?,?";
            
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            int i = 1;
            for(Object o : vParam){
                ps.setString(i++, vParam.get(i).toString());
            }
            ps.setInt(i++, startRow);
            ps.setInt(i++, stopRow);
            rs = ps.executeQuery();
            NewsCategory newsCategory = null;
            while(rs.next()){
                if(list == null) list = new ArrayList<NewsCategory>();
                i = 1;
                newsCategory = new NewsCategory(rs.getBigDecimal(i++), rs.getString(i++), rs.getString(i++), rs.getTimestamp(i++));
                list.add(newsCategory);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            releaseConnection(conn, ps, rs);
        }
        
        return list;
    }
    
     public int count(String name, String urlFriendly){
        
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<NewsCategory> list = null;
        
        try{
            Vector vParam = new Vector();
            String sqlBonus = "";
            if(name != null && !"".equals(name)){
                sqlBonus = " and upper(name) like concat('%',upper(?),'%')";
                vParam.add(name);
            }
            if(urlFriendly != null && !"".equals(urlFriendly)){
                sqlBonus = " and upper(url_friendly) like concat('%',upper(?),'%')";
                vParam.add(urlFriendly);
            }
            
            String sql = "select id, name, url_friendly, gen_date"
                    + "   from news_category"
                    + "   where 1 = 1 " + sqlBonus;
            
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            int i = 1;
            for(Object o : vParam){
                ps.setString(i++, vParam.get(i).toString());
            }
         
            rs = ps.executeQuery();
            if(rs.next()) return rs.getInt(1);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            releaseConnection(conn, ps, rs);
        }
        
        return 0;
    }
    public List<NewsCategory> find1(String name, String urlFriendly){
        List<NewsCategory> list = new ArrayList<NewsCategory>();
        NewsCategory newsCategory = null;
        for(int i=0; i<6; i++){
            newsCategory = new NewsCategory(BigDecimal.ONE, "CATE "+i, "Friend "+i, null);
            list.add(newsCategory);
        }
        return list;
    }
    
    public static void main(String[] args) {
//        NewsCategoryDao newsCategoryDao = new NewsCategoryDao();
//        NewsCategory newsCategory = null;
//        for(int i = 1; i < 10; i++){
//            newsCategory = new NewsCategory(null, "Category "+i, "category-"+i, null);
//            System.out.println("rs="+newsCategoryDao.create(newsCategory));
//        }
    }
}












