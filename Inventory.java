/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine_lld;

import java.util.*;

/**
 *
 * @author G KANNAN
 */
public class Inventory {
    private final HashMap<Integer, Product> products;
            
    public Inventory() {
        this.products = new HashMap<>();
    }
    
    public void addProduct(int id, Product product){
        products.put(id, product);
    }

    public boolean checkAvailability(int id) throws ProductNotFoundException, OutOfStockException {
        Product prod = getProductById(id);
        if(prod.getQuantity() < 0) throw new OutOfStockException("Product " + prod.getName() + " is out of stock");
        return true;
    }

    void reduceStock(int id, int q) {
        Product prod = products.get(id);
        prod.decQuantity(q);
    }
    
    String getName(int id) throws ProductNotFoundException{
        Product prod = getProductById(id);
        return prod.getName();
    }
    
    boolean restock(int id, int quan) {
        try{
            Product prod = getProductById(id);
            prod.incQuantity(quan);
            return true;
        }catch (ProductNotFoundException e){
            return false;
        }
    }
    
    Product getProductById(int id) throws ProductNotFoundException{
        if(!products.containsKey(id)) throw new ProductNotFoundException("Product with id " + id + " not found");
        return products.get(id);
    }
    
    void display(){
        for(Product p : products.values()){
            System.out.println("Id:" + p.getId() + " Name:" + p.getName() + " Quan:" + p.getQuantity() + " Price:" +p.getPrice());
        }
    }
    
}