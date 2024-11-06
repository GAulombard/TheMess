package com.hodor.stream;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankAccount> bankAccounts = List.of(
                new BankAccount("A", 50),
                new BankAccount("B", 80),
                new BankAccount("C", -80)
        );

        // recupérer le nombre de compte avec un sold negatif
        // approche IMPERATIVE : how
        var count1 = 0;
        for (var bankAcount : bankAccounts) {
            if (bankAcount.getBalance() < 0)
                count1++;
        }

        //approche DECLARATIVE : what
        var count2 = bankAccounts.stream()
                .filter(ba -> ba.getBalance() < 0)
                .count();

        //example de mapping
        bankAccounts.stream()
                .filter(account -> account.getBalance() < 0)
                .map(BankAccount::getHolder)
                .forEach(System.out::println);

    }
}
