/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.vendingmachine_lld;

import java.util.Scanner;

/**
 *
 * @author G KANNAN
 */
public class Main {
    public static void main(String args[]) throws InsufficientFundException, OutOfStockException, ProductNotFoundException{
        Scanner sc = new Scanner(System.in);
        VendingMachine machine = new VendingMachine();
        
        System.out.println("Welcome to Vending Machine!");
        char ch;
        do{
            System.out.println("What do you want\n1.Refill 2.Buy 3.Display 4.Show Transaction");
            int t = sc.nextInt();
            switch (t) {
                case 1 -> machine.refill();
                case 2 -> machine.buy();
                case 3 -> machine.display();
                default -> machine.transac();
            }
            System.out.println("Do you want to continue.. (y/n): ");
            ch = sc.next().charAt(0);
        }while(ch == 'y');
    }
}
