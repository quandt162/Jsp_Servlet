/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.entity;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class News {
    private BigDecimal id;
    private String title;

    public News() {
    }

    public News(BigDecimal id, String title) {
        this.id = id;
        this.title = title;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
