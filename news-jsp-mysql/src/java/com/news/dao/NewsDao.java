/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.dao;

import com.news.entity.News;
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
public class NewsDao extends BaseDao{
    public boolean create(News news){
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            String sql = "insert into news(title,short_desc,content,category_id,url_friendly,thumbnail,gen_date)"
                    +"    values(?, ?, ?, ?, ?, ?, now())";
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            int i = 1;
            ps.setString(i++, news.getTitle());
            ps.setString(i++, news.getShortDesc());
            ps.setString(i++, news.getContent());
            ps.setBigDecimal(i++, news.getCategoryID());
            ps.setString(i++, news.getUrlFriendly());
            ps.setString(i++, news.getThumbnail());
            
            return ps.executeUpdate() == 1;   
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            releaseConnection(conn, ps);
        }
        return false;
    }
    
    public boolean delete(News news){
       Connection conn = null;
       PreparedStatement pstm = null;
       
       try{
           String sql = "delete news where id = ?";
           conn = getConnection();
           pstm = conn.prepareStatement(sql);
           
           int i = 1;
           pstm.setBigDecimal(i, news.getId());
           
           return pstm.executeUpdate()== 1;
       }catch(Exception ex){
           ex.printStackTrace();
       }finally{
           releaseConnection(conn, pstm);
       }
       return false;
   }
    
    public News findByUrlFriendly(String urlFriendly){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        News news = null;
        
        try{
            String sql = "select id, title,short_desc,content,category_id,url_friendly,thumbnail,gen_date"
                    + "   from news"
                    + "   where upper(url_friendly) like concat('%',upper(?),'%')";
            
            
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, urlFriendly);
            rs= ps.executeQuery();
                    
            if(rs.next()){
                int i = 1;
                news = new News(rs.getBigDecimal(i++), rs.getString(i++), rs.getString(i++),rs.getString(i++),
                        rs.getBigDecimal(i++),rs.getString(i++),rs.getString(i++),rs.getTimestamp(i++));
   
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            releaseConnection(conn, ps);
        }
        
        return news;
    }
    
     public List<News> find(int rowsPerPage, int currentPage, String title, String urlFriendly){
        
        int startRow = (currentPage - 1) * rowsPerPage;
        int stopRow = currentPage * rowsPerPage;
         
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<News> list = null;
        
        try{
            Vector vParam = new Vector();
            String sqlBonus = "";
            if(title != null && !"".equals(title)){
                sqlBonus = " and upper(title) like concat('%',upper(?),'%')";
                vParam.add(title);
            }
            if(urlFriendly != null && !"".equals(urlFriendly)){
                sqlBonus = " and upper(url_friendly) like concat('%',upper(?),'%')";
                vParam.add(urlFriendly);
            }
            
            String sql = "select id, title,short_desc,content,category_id,url_friendly,thumbnail,gen_date"
                    + "   from news"
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
            News news = null;
            for(Object o : vParam){
                ps.setString(i++, vParam.get(i).toString());
            }
            while(rs.next()){
                if(list == null) list = new ArrayList<News>();
                i = 1;
                news = new News(rs.getBigDecimal(i++), rs.getString(i++), rs.getString(i++),rs.getString(i++),
                        rs.getBigDecimal(i++),rs.getString(i++),rs.getString(i++),rs.getTimestamp(i++));
                list.add(news);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            releaseConnection(conn, ps, rs);
        }
        
        return list;
    }
    
    public int count(String title, String urlFriendly){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Vector vParam = new Vector();
            String sqlBonus = "";
            if(title != null && !"".equals(title)){
                sqlBonus = " and upper(title) like concat('%',upper(?),'%')";
                vParam.add(title);
            }
            if(urlFriendly != null && !"".equals(urlFriendly)){
                sqlBonus = " and upper(url_friendly) like concat('%',upper(?),'%')";
                vParam.add(urlFriendly);
            }
            
            String sql = "select count(*)"
                    + "   from news"
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
    
 
    public static void main(String[] args) {
        News news = null;
        NewsDao newsDao = new NewsDao();
        for(int i = 1; i < 10; i++){
            news = new News(null, "News "+i, "ban tin nay la ban tin thu "+i, "Hom nay la mot ngay dep troi ", new BigDecimal(10), "news-"+i, "https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0CAcQjRxqFQoTCNn9lpDd4sgCFUFbpgodlJAAFw&url=https%3A%2F%2Fwww.sofort.com%2Feng-GB%2Fbuyer%2Fsb%2Fdirect-payment-made-easy%2F&psig=AFQjCNEMZcMYozQerPGd22p7F_bNUocXYg&ust=1446037904811772", null);
            System.out.println("rs="+newsDao.create(news));
        }
    }
}
