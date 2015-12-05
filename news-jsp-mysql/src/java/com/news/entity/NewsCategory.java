/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author Love JAV
 */
public class NewsCategory {
    private BigDecimal id;
    private String name;
    private String urlFriendly;
    private Timestamp genDate;

    public NewsCategory() {
    }

    public NewsCategory(BigDecimal id, String name, String urlFriendly, Timestamp genDate) {
        this.id = id;
        this.name = name;
        this.urlFriendly = urlFriendly;
        this.genDate = genDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlFriendly() {
        return urlFriendly;
    }

    public void setUrlFriendly(String urlFriendly) {
        this.urlFriendly = urlFriendly;
    }

    public Timestamp getGenDate() {
        return genDate;
    }

    public void setGenDate(Timestamp genDate) {
        this.genDate = genDate;
    }
}
