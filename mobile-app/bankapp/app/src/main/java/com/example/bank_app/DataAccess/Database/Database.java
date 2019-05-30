package com.example.bank_app.DataAccess.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bank_app.DataAccess.Models.User;

public class Database extends SQLiteOpenHelper{
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    public void onCreate(SQLiteDatabase db){
        String createUserTable = "create table User(_ID_user integer primary key autoincrement, document text unique, email text, password text,role text);";
        db.execSQL(createUserTable);
        String createAccountTable = "create table Account(_ID_account integer primary key autoincrement,ID_user text, balance integer ,foreign key ("+ID_user+") references "
        User+"("+document+") );";
        db.execSQL(createAccountTable);

    }
    /*public void insertReg(String name, String doc, String email, String pas,int balance){
        ContentValues valores = new ContentValues();
        valores.put("document",doc);
        valores.put("name", name);
        valores.put("email",email);
        valores.put("password", pas);
        valores.put("balance", balance);
        this.getWritableDatabase().insert("user", null, valores);
    }
    public void populateDatabase()
    {
        this.open();
        this.insertReg("Andres Moya","1018","afmoyar","123456",1000000);
        this.insertReg("Sergio Pineda","1234","saepinedave","123456",1000000);
        this.close();
    }*/
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

    /*public Cursor validateCredentials(String doc, String pas) throws SQLException
    {
        Cursor currentCursor = null;
        currentCursor = this.getReadableDatabase().query("User", new String[] {"_ID",
                "document","name", "email", "password","balance"}, "document like '"+doc+"'"+
                "and password like '"+pas+"'", null, null, null, null);

        return currentCursor;

    }*/

}
