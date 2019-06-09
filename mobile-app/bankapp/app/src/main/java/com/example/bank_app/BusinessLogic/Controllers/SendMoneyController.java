package com.example.bank_app.BusinessLogic.Controllers;

import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.User;

public class SendMoneyController
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
