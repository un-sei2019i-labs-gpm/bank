package com.example.bank_app.DataAccess.Models;

public class Transaction
{
    private int idTransaction;
    private String timeOfTransaction;
    private String idTransmitter;
    private String idReceiver;
    private int amount;

    public Transaction(int idTransaction, String timeOfTransaction, String idTransmitter, String idReceiver, int amount) {
        this.idTransaction = idTransaction;
        this.timeOfTransaction = timeOfTransaction;
        this.idTransmitter = idTransmitter;
        this.idReceiver = idReceiver;
        this.amount = amount;
    }

    public Transaction( String timeOfTransaction, String idTransmitter, String idReceiver, int amount) {
        this.timeOfTransaction = timeOfTransaction;
        this.idTransmitter = idTransmitter;
        this.idReceiver = idReceiver;
        this.amount = amount;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setTimeOfTransaction(String timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }

    public String getIdTransmitter() {
        return idTransmitter;
    }

    public void setIdTransmitter(String idTransmitter) {
        this.idTransmitter = idTransmitter;
    }

    public String getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(String idReceiver) {
        this.idReceiver = idReceiver;
    }

    public int getAmmount() {
        return amount;
    }

    public void setAmmount(int amount) {
        this.amount = amount;
    }
}
