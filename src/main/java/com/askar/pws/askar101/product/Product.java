/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.askar.pws.askar101.product;

/**
 *
 * @author STRIX
 */
public class Product {
    private String id;
    private String name;
    private String quantity;
    private String price;

    
    //untuk mengambil data dari varibel quantity
    public String getQuantity() {
        return quantity;
    }

    //untuk mengisi atau mengubah data dari varibel quantity
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    //untuk mengambil data dari varibel price
    public String getPrice() {
        return price;
    }

    //untuk mengisi atau mengubah data dari varibel price
    public void setPrice(String price) {
        this.price = price;
    }

    //untuk mengambil data dari varibel id
    public String getId() {
        return id;
    }

    //untuk mengisi atau mengubah data dari varibel id
    public void setId(String id) {
        this.id = id;
    }

    //untuk mengambil data dari variabel name
    public String getName() {
        return name;
    }
    
    //untuk mengisi atau mengubah data dari variabel name
    public void setName(String name) {
        this.name = name;
    }
    
    
}
