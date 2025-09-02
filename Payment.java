/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine_lld;

/**
 *
 * @author G KANNAN
 */
public abstract class Payment {
    private int balance;
    
    public abstract String paymentType();

    public Payment() {
        this.balance = 0;
    }

    int calculateChange(int amt) {
        return this.balance - amt;
    }

    void acceptMoney(int amt) {
        this.balance = amt;
    }
    
    boolean isSufficient(Product prod, int quantity) throws InsufficientFundException{
        if(balance < (prod.getPrice() * quantity))
            throw new InsufficientFundException("Required: " + (prod.getPrice() * quantity) + ", Available: " + balance);
        return prod.getQuantity() >= quantity;
    }

    void deductMoney(int amt) {
        this.balance -= amt;
    }

    void setBalance() {
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }
    
}