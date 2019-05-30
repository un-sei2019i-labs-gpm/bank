package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;

import com.example.bank_app.DataAccess.Database.Database;
import com.example.bank_app.DataAccess.Models.User;

import java.util.Date;

public class UserRepository
{
    public void createUser(Database helper, User user)
    {
        ContentValues valores = new ContentValues();
        valores.put("document",user.getDocument());
        valores.put("email",user.geteMail());
        valores.put("password", user.getPassword());
        valores.put("role",user.getRole());
        helper.getWritableDatabase().insert("User", null, valores);
    }
}
