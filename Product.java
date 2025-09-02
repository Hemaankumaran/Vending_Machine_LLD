/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine_lld;

/**
 *
 * @author G KANNAN
 */
public class Product {
    private final int id;
    private final String name;
    private int quantity;
    private final int price; // All prices/amounts are in rupees (whole numbers).

    public Product(int p_id, String p_name, int quantity, int price) {
        this.id = p_id;
        this.name = p_name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    void decQuantity(int q) {
        this.quantity -= q;
    }

    void incQuantity(int quan) {
        this.quantity += quan;
    }
    
}