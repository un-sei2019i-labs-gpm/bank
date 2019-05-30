package com.example.bank_app.DataAccess.Models;

public class Account
{
    private int accountNumber;
    private int idUser;
    private int balance;

    public Account(int accountNumber, int idUser, int balance) {
        this.accountNumber = accountNumber;
        this.idUser = idUser;
        this.balance = balance;
    }

    public Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


}
