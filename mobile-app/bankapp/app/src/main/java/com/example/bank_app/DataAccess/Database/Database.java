package com.example.bank_app.DataAccess.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bank_app.DataAccess.Models.User;
import com.example.bank_app.DataAccess.Repositories.UserRepository;

public class Database extends SQLiteOpenHelper{

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    public void onCreate(SQLiteDatabase db){
        String createUserTable = "create table User(_ID_user text primary key, " +
                "email text not null, password text not null,role text not null);";
        db.execSQL(createUserTable);
        String createAccountTable = "create table Account" +
                "(_ID_account integer primary key autoincrement,_ID_user text not null, " +
                "balance integer not null ,foreign key (_ID_user) references User(_ID_user));";
        db.execSQL(createAccountTable);
        String  createTransaction ="create table Transac" +
                "(_ID_transaction integer primary key autoincrement," +
                " time_of_transaction date not null, id_transmiter text not null, " +
                "id_receiver text not null, amount integer not null, foreign key (id_receiver) " +
                "references User(_ID_user), foreign key (id_transmiter) references User(_ID_user));";
        db.execSQL(createTransaction);
    }
    public static Database createHelper(Context context)
    {
        Database helper = new Database(context, "BD1", null, 1);
        return helper;
    }
    /*
    public void insertReg(String name, String doc, String email, String pas,String role){
        ContentValues valores = new ContentValues();
        valores.put("document",doc);
        valores.put("email",email);
        valores.put("password", pas);
        valores.put("role", role);
        this.getWritableDatabase().insert("User", null, valores);
    }

    public void populateDatabase()
    {
        this.open();
        this.insertReg("Andres Moya","1018","afmoyar","123456","USER");
        this.insertReg("Sergio Pineda","1234","saepinedave","123456","USER");
        this.close();
    }
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){
    }

    //open la bd
    public void open(){
        this.getWritableDatabase();
    }
    //cerrar la bd
    public void closeDataBase(){
        this.close();
    }



    //metodo para validar si el usuario existe

    /**/


}
