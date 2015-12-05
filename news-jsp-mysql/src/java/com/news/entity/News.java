package com.news.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Love JAV
 */
public class News {
    private BigDecimal id;
    private String title;
    private String shortDesc;
    private String content;
    private BigDecimal categoryID;   
    private String urlFriendly;
    private String thumbnail;
    private Timestamp genDate;

    public News() {
    }

    public News(BigDecimal id, String title, String shortDesc, String content, BigDecimal categoryID, String urlFriendly, String thumbnail, Timestamp genDate) {
        this.id = id;
        this.title = title;
        this.shortDesc = shortDesc;
        this.content = content;
        this.categoryID = categoryID;
        this.urlFriendly = urlFriendly;
        this.thumbnail = thumbnail;
        this.genDate = genDate;
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(BigDecimal categoryID) {
        this.categoryID = categoryID;
    }

    public Timestamp getGenDate() {
        return genDate;
    }

    public void setGenDate(Timestamp genDate) {
        this.genDate = genDate;
    }

    public String getUrlFriendly() {
        return urlFriendly;
    }

    public void setUrlFriendly(String urlFriendly) {
        this.urlFriendly = urlFriendly;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    
}
