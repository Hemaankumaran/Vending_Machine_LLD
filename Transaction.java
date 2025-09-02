/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendingmachine_lld;

import java.time.LocalDateTime;

/**
 *
 * @author G KANNAN
 */
public class Transaction {
    private final int id;
    private final Product prod;
    private final int quan;
    private final int amtPaid;
    private final Payment payment;
    private final transactionStatus status;
    private final LocalDateTime time;
    
    public enum transactionStatus{SUCCESS, FAILED, REFUND};

    public Transaction(int id, Product prod, int quan, int amtPaid, Payment payment, transactionStatus status) {
        this.id = id;
        this.prod = prod;
        this.quan = quan;
        this.amtPaid = amtPaid;
        this.status = status;
        this.time = LocalDateTime.now();
        this.payment = payment;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public Product getProd() {
        return prod;
    }

    public int getQuan() {
        return quan;
    }

    public String getPayment() {
        return payment.paymentType();
    }

    public int getAmtPaid() {
        return amtPaid;
    }

    public transactionStatus getMsg() {
        return status;
    }
    
    @Override
    public String toString(){
        return "Txn# " + this.id + " | Name:" + prod.getName() + " | Quan:" + this.quan + " | Amt paid:" + amtPaid 
                + " | Payment Type:" + this.getPayment() + " | Status:" + status + " | Time Stamp:" + time;
    }
}