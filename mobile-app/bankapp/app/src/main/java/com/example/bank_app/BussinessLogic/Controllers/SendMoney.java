package com.example.bank_app.BussinessLogic.Controllers;

import android.content.Context;
import android.database.Cursor;

import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.User;
import com.example.bank_app.DataAccess.Repositories.AccountRepository;
import com.example.bank_app.DataAccess.Repositories.UserRepository;

public class SendMoney
{
    public static void populateDataBase(Context context)
    {
        UserRepository.createUser(context,new User("afmoyar","123456","user","1018"));
        UserRepository.createUser(context,new User("email","123456","user","1234"));
        AccountRepository.createAccount(context, new Account("1018", 1000));
        AccountRepository.createAccount(context, new Account("1234", 2000));

    }
    public static boolean logIn(Context context, String userId, String password)
    {
        Cursor cursor=UserRepository.validateCredentials(context,userId, password);
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
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
