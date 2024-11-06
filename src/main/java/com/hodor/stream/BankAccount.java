package com.hodor.stream;

public class BankAccount {

    private String holder;
    private double balance;

    public BankAccount(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }
}
