/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.news.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author 24h
 */
public class ProductUtil {
    public static NumberFormat formatPrice = NumberFormat.getInstance();
    public static String showPrice(BigDecimal price){
        if(price == null || price.compareTo(BigDecimal.ZERO) == 0) return "Liên hệ";
        return formatPrice.format(price)+" VNĐ";
    }
    public static String showPriceNoVND(BigDecimal price){
        if(price == null || price.compareTo(BigDecimal.ZERO) == 0) return "Liên hệ";
        return formatPrice.format(price);
    }
}
