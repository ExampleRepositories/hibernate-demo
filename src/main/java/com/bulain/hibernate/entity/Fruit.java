package com.bulain.hibernate.entity;
// Generated 2011-10-25 20:15:48 by Hibernate Tools 3.2.2.GA



/**
 * Fruit generated by hbm2java
 */
public class Fruit  implements java.io.Serializable {


     /**
     * 
     */
    private static final long serialVersionUID = -1657192148145061585L;
    private long id;
     private String name;

    public Fruit() {
    }

    public Fruit(String name) {
       this.name = name;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}

