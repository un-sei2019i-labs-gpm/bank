package com.example.bank_app.BussinessLogic;

import android.content.Context;

import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.User;
import com.example.bank_app.DataAccess.Repositories.UserRepository;

public class SendMoney
{
    public static void populateDataBase(Context context)
    {
        UserRepository.createUser(context,new User("afmoyar","123456","user","1018"));
        UserRepository.createUser(context,new User("email","123456","user","1234"));
    }
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
