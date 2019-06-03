package com.example.bank_app.DataAccess.Models;

import java.util.Date;

public class Transaction
{
    private int idTransaction;
    private Date timeOfTransaction;
    private int idTransmitter;
    private int idReceiver;
    private int ammount;

    public Transaction(int idTransactiom, Date timeOfTransaction, int idTransmitter, int idReceiver, int ammount) {
        this.idTransaction = idTransactiom;
        this.timeOfTransaction = timeOfTransaction;
        this.idTransmitter = idTransmitter;
        this.idReceiver = idReceiver;
        this.ammount = ammount;
    }

    public Transaction( Date timeOfTransaction, int idTransmitter, int idReceiver, int ammount) {
        this.timeOfTransaction = timeOfTransaction;
        this.idTransmitter = idTransmitter;
        this.idReceiver = idReceiver;
        this.ammount = ammount;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setTimeOfTransaction(Date timeOfTransaction) {
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
