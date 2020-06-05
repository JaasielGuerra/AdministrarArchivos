/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.cargaarchivos;

/**
 *
 * @author Jaasiel
 */
public class Archivo {
    
    private int no;
    private String name;
    private String type;
    private String size;

    public Archivo(int no, String name, String type, String size) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.size = size;
    }
    
    

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    
    
}
