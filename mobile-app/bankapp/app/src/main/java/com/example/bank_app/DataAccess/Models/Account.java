package com.example.bank_app.DataAccess.Models;

public class Account
{
    private int accountNumber;
    private String idUser;
    private int balance;

    public Account(){


    }

    public Account(int accountNumber, String idUser, int balance) {
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


}
