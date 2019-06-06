package com.example.bank_app.BussinessLogic;

import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.User;

public class SendMoney
{
    public  static boolean sendMoney(Account transfer, Account receiver, int amount)
    {
        if(transfer.getBalance()>=amount)
        {
            int trBalance;
            int reBalance;
            return true;
        }
        return false;
    }
}
