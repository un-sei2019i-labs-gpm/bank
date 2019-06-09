package com.example.bank_app.BussinessLogic.Controllers;

import android.content.Context;
import android.database.Cursor;

import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.User;
import com.example.bank_app.DataAccess.Repositories.AccountRepository;
import com.example.bank_app.DataAccess.Repositories.UserRepository;

public class SendMoneyController
{
    public static int fetchBalance(Context context, String idUser)
    {
        Account account=AccountRepository.getAccountByUser(context,idUser);
        return account.getBalance();

    }
    public static int fetchAccNumber(Context context, String idUser)
    {
        Account account=AccountRepository.getAccountByUser(context,idUser);
        return account.getAccountNumber();

    }

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
    public  static boolean sendMoney(Context context, int accTransmitter, int accReceiver, int amount, int balance)
    {

        if(AccountRepository.checkAccByID(context, accReceiver)){
            if(balance>=amount)
            {
                Account accRec = AccountRepository.getAccountByAcc(context, accReceiver);
                Account accTrans = AccountRepository.getAccountByAcc(context, accTransmitter);
                accRec.setBalance(accRec.getBalance() + amount);
                accTrans.setBalance(accTrans.getBalance() - amount);
                AccountRepository.updateAccountBalance(context, accRec);
                AccountRepository.updateAccountBalance(context, accTrans);
                return true;
            }
        }

        return false;
    }
}
