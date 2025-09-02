# Vending Machine - Low Level Design (LLD)

This project is a **Low Level Design (LLD)** implementation of a Vending Machine using **Java**.  
It demonstrates how to model a real-world system into code by applying **Object-Oriented Programming (OOP)** principles and design best practices.

---

## 🚀 Features
- **Product & Inventory Management**
  - Add products, check availability, restock, and dispense items.
- **Payment System**
  - Supports multiple payment methods (`CashPayment`, `CardPayment`).
  - Ensures sufficient balance before dispensing.
- **Transaction Management**
  - Records each transaction with a unique ID.
  - Maintains status: `SUCCESS`, `FAILED`, or `REFUND`.
- **Error Handling with Custom Exceptions**
  - `ProductNotFoundException`
  - `OutOfStockException`
  - `InsufficientFundsException`
- **Transaction History**
  - View all past transactions for audit and debugging.

---

## 🧑‍💻 OOP Concepts Used
- **Encapsulation** → Inventory, Payment, and Transaction classes hide internal details and expose only required methods.  
- **Abstraction** → Payment is designed as an abstract/interface-like contract with different implementations.  
- **Inheritance & Polymorphism** → `CashPayment` and `CardPayment` extend the `Payment` abstraction, enabling runtime flexibility.  
- **Exception Handling** → Used to manage invalid operations (e.g., out of stock, insufficient funds).  
- **Single Responsibility Principle (SRP)** → Each class has a clear role (Inventory handles stock, Payment handles balance, Transaction handles logs).  
- **Open/Closed Principle (OCP)** → New payment methods or transaction statuses can be added without modifying existing code.

---

## 🛠️ Tech Stack
- **Language:** Java  
- **Paradigm:** Object-Oriented Programming (OOP)  
- **Design:** Low Level Design (LLD)
