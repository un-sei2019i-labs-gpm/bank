package com.example.bank_app.DataAccess.Repositories;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.bank_app.DataAccess.Database.Database;
import com.example.bank_app.DataAccess.Models.Account;

public class AccountRepository {

    public AccountRepository(){

    }

    private static boolean checkAccByID(Database helper, int accId){

        Cursor cursor = helper.getReadableDatabase().query("Account", new String[]
                {"_ID_account", "_ID_user","balance"}, "_ID_account like '"+accId+"'",
                null, null, null, null);
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    private static boolean checkAccByUsr(Database helper, String usrID){

        Cursor cursor = helper.getReadableDatabase().query("Account", new String[]
                {"_ID_account", "_ID_user","balance"}, "_ID_user like '"+usrID+"'",
                null, null, null, null);
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    private static Cursor queryByUsr(Database helper, String usrDoc)
    {

        Cursor currentCursor = helper.getReadableDatabase().query("Account", new String[]
                {"_ID_account", "_ID_user","balance"}, "_ID_user like '"+usrDoc+"'",
                null, null, null, null);
        return currentCursor;
    }

    private static Cursor queryByAccountId(Database helper, String accID)
    {

        Cursor currentCursor = helper.getReadableDatabase().query("Account", new String[]
                {"_ID_account", "_ID_user","balance"}, "_ID_account like '"+accID+"'",
                null, null, null, null);
        return currentCursor;
    }

    public static void createAccount(Database helper, Account account)
    {

        if(checkAccByUsr(helper, account.getIdUser())){

            ContentValues valores = new ContentValues();
            valores.put("_ID_user",account.getIdUser());
            valores.put("balance", account.getBalance());
            helper.getWritableDatabase().insert("Account", null, valores);
            helper.close();
        }
    }

    public static Account getAccountByUser(Database helper,String usrDoc)
    {

        Cursor currentCursor = queryByUsr(helper, usrDoc);
        if(currentCursor.getCount()>0)
        {
            currentCursor.moveToFirst();
            Account accFound=new Account();
            int index=currentCursor.getColumnIndex("_ID_account");
            accFound.setAccountNumber(Integer.parseInt(currentCursor.getString(index)));
            index=currentCursor.getColumnIndex("_ID_user");
            accFound.setIdUser(currentCursor.getString(index));
            index=currentCursor.getColumnIndex("balance");
            accFound.setBalance(Integer.parseInt(currentCursor.getString(index)));
            helper.close();

            return accFound;
        }
        else
            return null;
    }

    public static boolean updateAccountBalance(Database helper, Account upAccount)
    {

        Cursor currentCursor = queryByUsr(helper, upAccount.getIdUser());
        if(currentCursor.getCount()>0)
        {
            ContentValues values = new ContentValues();
            values.put("balance", upAccount.getBalance());
            String whereClause="_ID_user='"+upAccount.getIdUser()+"'";
            helper.getWritableDatabase().update("Account",values,whereClause,null);
            helper.close();
            return true;
        }
        else
            return false;
    }

    public static boolean deleteAccount(Database helper,String usrDoc)
    {

        Cursor currentCursor = queryByUsr(helper, usrDoc);
        if(currentCursor.getCount()>0)
        {
            helper.getWritableDatabase().delete("Account","_ID_user='"+usrDoc+"'",null);
            helper.close();
            return true;
        }
        else
            return false;
    }


}
