package com.bulain.hibernate.entity;
// Generated 2011-10-25 20:35:54 by Hibernate Tools 3.2.2.GA



/**
 * Lappad generated by hbm2java
 */
public class Lappad extends com.bulain.hibernate.entity.Computer implements java.io.Serializable {


     /**
     * 
     */
    private static final long serialVersionUID = 42543208091598634L;
    private String lappadInfo;

    public Lappad() {
    }

    public Lappad(String name, String lappadInfo) {
        super(name);        
       this.lappadInfo = lappadInfo;
    }
   
    public String getLappadInfo() {
        return this.lappadInfo;
    }
    
    public void setLappadInfo(String lappadInfo) {
        this.lappadInfo = lappadInfo;
    }




}

