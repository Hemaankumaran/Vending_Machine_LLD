/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vendingmachine_lld;
import com.mycompany.vendingmachine_lld.Transaction.transactionStatus;
import java.util.*;

/**
 *
 * @author G KANNAN
 */
public class VendingMachine {
    Scanner sc = new Scanner(System.in);
    private final Inventory inventory;
    private Payment payment;
    private final List<Transaction> trans;
    private int transid;
    
    public VendingMachine(){
        this.inventory = new Inventory();
        this.trans = new ArrayList<>();
        this.transid = 1;
        
        Product p1 = new Product(1, "Cake", 10, 5);
        Product p2 = new Product(2, "Coke", 20, 15);
        Product p3 = new Product(3, "Tea", 25, 10);
        inventory.addProduct(1, p1);
        inventory.addProduct(2, p2);
        inventory.addProduct(3, p3);
    }
    
    public void refill() throws ProductNotFoundException{
        System.out.println("Enter the product id to refill: ");
        int id = sc.nextInt();
        System.out.println("Enter the quantity: ");
        int quan = sc.nextInt();
        try{
            if(refillInventory(id, quan)) System.out.println("Refill successful! Added " + quan + " " + inventory.getProductById(id).getName());
            else System.out.println("Refill failed, Product with Id: " + id + " not found");
        }catch (ProductNotFoundException e){
            System.out.println("Error: " +e);
        }
    }
    
    public void buy() throws InsufficientFundException, OutOfStockException{
        System.out.println("1.Cash or 2.Card");
        int c = sc.nextInt();
        if(c == 1) payment = new CashPayment();
        else payment = new CardPayment();
        System.out.print("Enter the money: ");
        int amt = sc.nextInt();
        insertMoney(amt);
        System.out.print("Enter the product id: ");
        int id = sc.nextInt();
        System.out.print("Enter the quantity: ");
        int q = sc.nextInt();
        try{
            if(selectProduct(id)){
                if(!payment.isSufficient(inventory.getProductById(id), q)){
                    System.out.println("Money not sufficient\nTake your money back..!");
                    payment.deductMoney(amt);
                    logTransaction(transid++, inventory.getProductById(id), q, amt, payment, Transaction.transactionStatus.REFUND);

                }
                else{
                    dispenseProduct(id, q);
                    if(q == 1) System.out.println("Here's your " + inventory.getName(id));
                    else System.out.println("Please take your " + q + " " + inventory.getName(id) + "s");
                    System.out.println("Your change: Rs." + returnChange(id));
                    logTransaction(transid++, inventory.getProductById(id), q, amt, payment, Transaction.transactionStatus.SUCCESS);
                    payment.setBalance();
                }
            }
            else{
                System.out.println("Product unavailable!");
                logTransaction(transid++, inventory.getProductById(id), q, amt, payment, Transaction.transactionStatus.FAILED);
            }
        }catch (ProductNotFoundException e){
            System.out.println("Error: " + e);
        }
    }

    public void insertMoney(int amt){
        payment.acceptMoney(amt);
    }
    
    public boolean selectProduct(int id) throws ProductNotFoundException, OutOfStockException{
        return inventory.checkAvailability(id);
    }

    public void dispenseProduct(int id, int q) {
        inventory.reduceStock(id, q);
    }

    public int returnChange(int id) throws ProductNotFoundException{
        Product prod = inventory.getProductById(id);
        return payment.calculateChange(prod.getPrice());
    }

    public boolean refillInventory(int id, int quan) {
        return inventory.restock(id, quan);
    }
    
    public void display(){
        inventory.display();
    }
    
    public void transac(){
        if(trans.isEmpty()){
            System.out.println("No Transactions");
        }
        else{
            for(Transaction t : trans){
                System.out.println(t);
            }
        }
    }
    
    public void logTransaction(int transid, Product prod, int q, int amt, Payment payment, transactionStatus transactionStatus) {
        Transaction tr = new Transaction(transid++, prod, q, amt, payment, transactionStatus.SUCCESS);
        trans.add(tr);
    }

    public void addProduct(int i, Product p) {
        inventory.addProduct(i, p);
    }
    
}