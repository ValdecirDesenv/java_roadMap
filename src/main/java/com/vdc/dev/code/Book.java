/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vdc.dev.code;

import java.io.Serializable;

/**
 *
 * @author vdc
 * 
 * Serialization in Java is the process of converting an object into a 
 * stream of bytes, which can then be stored in a file or sent over a 
 * network, and later deserialized back into an object. 
 * This mechanism allows you to persist the state of an object or transfer 
 * it between different applications or systems.
 */
public class Book implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String author;
    private String info;
    private int pages;

    transient int valueForServerOnly;
    
    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public int getValueForServerOnly() {
        return valueForServerOnly;
    }

    public void setValueForServerOnly(int valueForServerOnly) {
        this.valueForServerOnly = valueForServerOnly;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", author=" + author + ", info=" + info + ", pages=" + pages + '}';
    }
 
}
