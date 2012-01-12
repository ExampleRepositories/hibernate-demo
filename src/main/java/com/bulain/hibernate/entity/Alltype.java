package com.bulain.hibernate.entity;
// Generated 2012-1-12 14:21:26 by Hibernate Tools 3.2.2.GA


import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Alltypes generated by hbm2java
 */
public class Alltype  implements java.io.Serializable {


     private Integer id;
     private Integer version;
     private String fvarchar;
     private Date fdate;
     private Date fdatetime;
     private Integer fint;
     private Long fbitint;
     private Float ffload;
     private Double fdouble;
     private TimeZone ftimezone;
     private Currency fcurrency;
     private Locale flocale;
     private String createdBy;
     private Date createdAt;
     private String updatedBy;
     private Date updatedAt;

    public Alltype() {
    }

    public Alltype(String fvarchar, Date fdate, Date fdatetime, Integer fint, Long fbitint, Float ffload, Double fdouble, TimeZone ftimezone, Currency fcurrency, Locale flocale, String createdBy, Date createdAt, String updatedBy, Date updatedAt) {
       this.fvarchar = fvarchar;
       this.fdate = fdate;
       this.fdatetime = fdatetime;
       this.fint = fint;
       this.fbitint = fbitint;
       this.ffload = ffload;
       this.fdouble = fdouble;
       this.ftimezone = ftimezone;
       this.fcurrency = fcurrency;
       this.flocale = flocale;
       this.createdBy = createdBy;
       this.createdAt = createdAt;
       this.updatedBy = updatedBy;
       this.updatedAt = updatedAt;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    public String getFvarchar() {
        return this.fvarchar;
    }
    
    public void setFvarchar(String fvarchar) {
        this.fvarchar = fvarchar;
    }
    public Date getFdate() {
        return this.fdate;
    }
    
    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }
    public Date getFdatetime() {
        return this.fdatetime;
    }
    
    public void setFdatetime(Date fdatetime) {
        this.fdatetime = fdatetime;
    }
    public Integer getFint() {
        return this.fint;
    }
    
    public void setFint(Integer fint) {
        this.fint = fint;
    }
    public Long getFbitint() {
        return this.fbitint;
    }
    
    public void setFbitint(Long fbitint) {
        this.fbitint = fbitint;
    }
    public Float getFfload() {
        return this.ffload;
    }
    
    public void setFfload(Float ffload) {
        this.ffload = ffload;
    }
    public Double getFdouble() {
        return this.fdouble;
    }
    
    public void setFdouble(Double fdouble) {
        this.fdouble = fdouble;
    }
    public TimeZone getFtimezone() {
        return this.ftimezone;
    }
    
    public void setFtimezone(TimeZone ftimezone) {
        this.ftimezone = ftimezone;
    }
    public Currency getFcurrency() {
        return this.fcurrency;
    }
    
    public void setFcurrency(Currency fcurrency) {
        this.fcurrency = fcurrency;
    }
    public Locale getFlocale() {
        return this.flocale;
    }
    
    public void setFlocale(Locale flocale) {
        this.flocale = flocale;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }




}

