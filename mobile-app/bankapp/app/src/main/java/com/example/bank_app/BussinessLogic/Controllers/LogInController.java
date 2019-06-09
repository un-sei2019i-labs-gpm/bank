package com.example.bank_app.BussinessLogic.Controllers;

import android.content.Context;
import android.database.Cursor;

import com.example.bank_app.DataAccess.Repositories.UserRepository;

public class LogInController {

    public static boolean logIn(Context context, String userId, String password)
    {
        Cursor cursor= UserRepository.validateCredentials(context,userId, password);
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
