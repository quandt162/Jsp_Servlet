/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.news.util;

import java.math.BigDecimal;

/**
 *
 * @author Designer Nguyễn
 */
public class AdvUtil {
    public static String showAdv(String script,String contextPath, BigDecimal advId){
        if(script == null || "".equals(script)) return "";
        script = script.replace("href='", "href='"+contextPath+"/count-click.html?i="+advId+"&u=");
        script = script.replace("href=\"", "href=\""+contextPath+"/count-click.html?i="+advId+"&u=");
        return script;
    }
    public static void main(String[] args) {
        String rs = showAdv("<a href=\"www.google.com\"><img src=\"http://cdn.olympiaplus.net/thuoc/1418183338174\" with=\"280\" hieght=\"185\"></a>", "http://nhathuoc.net:7007", BigDecimal.ZERO);
        System.out.println("rs="+rs);
    }
}
