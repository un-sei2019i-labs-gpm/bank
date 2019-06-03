package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.bank_app.DataAccess.Database.Database;
import com.example.bank_app.DataAccess.Models.Transaction;

import java.text.SimpleDateFormat;

public class TransactionRepository {

    private final String format = "yyyy-MM-dd HH:mm:ss";

    public  TransactionRepository(){

    }

    public static Cursor queryAccID(Database helper, int accID){

        Cursor currentCursor = helper.getReadableDatabase().query("Transac", new String[]
                        {"_ID_transaction", "time_of_transaction","id_transmiter", "id_receiver", "amount"},
                "id_transmiter like '"+accID+"'",
                null, null, null, null);
        return currentCursor;
    }

    public void createTransaction(Database helper, Transaction transaction){

        ContentValues valores = new ContentValues();
        SimpleDateFormat formater = new SimpleDateFormat(this.format);
        valores.put("time_of_transaction", formater.format(transaction.getTimeOfTransaction()));
        valores.put("id_transmiter", transaction.getIdTransmitter());
        valores.put("id_receiver", transaction.getIdReceiver());
        valores.put("amount", transaction.getAmmount());
        helper.getWritableDatabase().insert("Transac", null, valores);
        helper.close();
    }

    public static boolean deleteTransaction(Database helper, Transaction transaction){

        Cursor currentCursor = queryAccID(helper, transaction.getIdTransmitter());
        if(currentCursor.getCount()>0)
        {
            helper.getWritableDatabase().delete("Transac",
                    "_ID_transaction='"+transaction.getIdTransaction()+"'",
                    null);
            helper.close();
            return true;
        }
        else
            return false;
    }
}
