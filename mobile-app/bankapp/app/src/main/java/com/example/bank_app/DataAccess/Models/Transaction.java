package com.example.bank_app.DataAccess.Models;

public class Transaction
{
    private int idTransactiom;
    private String timeOfTransaction;
    private int idTransmitter;
    private int idReceiver;
    private int ammount;

    public Transaction(int idTransactiom, String timeOfTransaction, int idTransmitter, int idReceiver, int ammount) {
        this.idTransactiom = idTransactiom;
        this.timeOfTransaction = timeOfTransaction;
        this.idTransmitter = idTransmitter;
        this.idReceiver = idReceiver;
        this.ammount = ammount;
    }

    public Transaction( String timeOfTransaction, int idTransmitter, int idReceiver, int ammount) {
        this.timeOfTransaction = timeOfTransaction;
        this.idTransmitter = idTransmitter;
        this.idReceiver = idReceiver;
        this.ammount = ammount;
    }

    public int getIdTransactiom() {
        return idTransactiom;
    }

    public void setIdTransactiom(int idTransactiom) {
        this.idTransactiom = idTransactiom;
    }

    public String getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setTimeOfTransaction(String timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }

    public int getIdTransmitter() {
        return idTransmitter;
    }

    public void setIdTransmitter(int idTransmitter) {
        this.idTransmitter = idTransmitter;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
}
