/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.news.util;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Designer Nguyễn
 */
public class RequestUtil {
    public static Integer getInt(HttpServletRequest request, String paramName, Integer defaultValue){
        try{
            Integer rs = Integer.parseInt(request.getParameter(paramName));
            return rs;
        }catch(Exception ex){}
        return defaultValue;
    }
    
    public static BigDecimal getBigDecimal(HttpServletRequest request, String paramName, BigDecimal defaultValue){
        try{
            BigDecimal rs = new BigDecimal(request.getParameter(paramName));
            return rs;
        }catch(Exception ex){}
        return defaultValue;
    }
    
    public static String getString(HttpServletRequest request, String paramName, String defaultValue){
        try{
            if(request.getParameter(paramName) != null && !"".equals(request.getParameter(paramName))) 
                return request.getParameter(paramName);
        }catch(Exception ex){}
        return defaultValue;
    }
    
    public static String getStringUTF8(HttpServletRequest request, String paramName, String defaultValue){
        try{
            if(request.getParameter(paramName) != null && !"".equals(request.getParameter(paramName))) 
                return new String(request.getParameter(paramName).getBytes(
                                "iso-8859-1"), "UTF-8");
        }catch(Exception ex){}
        return defaultValue;
    }
    
    public static String getRealContextPath(HttpServletRequest request){
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = "";        
        if("localhost".equals(serverName) || serverName.split("\\.").length > 0) contextPath = request.getScheme() + "://"+serverName+":"+serverPort+request.getContextPath();
        else contextPath = request.getScheme() + "://"+serverName;
        return contextPath;
    }
    
    public static String getContextPath(HttpServletRequest request){
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = "";
        if("localhost".equals(serverName) || serverName.split("\\.").length > 0) contextPath = request.getScheme() + "://"+serverName+":"+serverPort+request.getContextPath();
        else contextPath = request.getScheme() + "://"+serverName;
        return contextPath;
    }
    
    public static String getDomainName(HttpServletRequest request) throws MalformedURLException {
        String result = null;
        String referrer = request.getHeader("referer");
        if (referrer != null && !"".equals(referrer)) {
            if (!referrer.startsWith("http") && !referrer.startsWith("https")) {
                referrer = "http://" + referrer;
            }
            URL netUrl = new URL(referrer);
            result = netUrl.getHost();
            if (result.startsWith("www")) {
                result = result.substring("www".length() + 1);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String serverName = "113.113.113.14";        
        System.out.println(serverName.split("\\.").length);
    }
}
