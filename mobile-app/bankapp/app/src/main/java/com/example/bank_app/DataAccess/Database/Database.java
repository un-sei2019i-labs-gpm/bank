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

        String createUserTable = "create table User(document text primary key, email text not null, password text not null,role text not null);";
        db.execSQL(createUserTable);
        String createAccountTable = "create table Account(_ID_account integer primary key autoincrement,_ID_user text not null, balance integer not null ,foreign key (_ID_user) references User(document));";
        db.execSQL(createAccountTable);
        String  createTransaction ="create table Transac(_ID_transaction integer primary key autoincrement, time_of_transaction date not null, id_transmiter integer not null, id_receiver integer not null, amount integer not null, foreign key (id_receiver) references User(_ID_user), foreign key (id_transmiter) references User(_ID_user));";
        db.execSQL(createTransaction);
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
    public Cursor validateCredentials(String doc, String pas) throws SQLException
    {
        Cursor currentCursor = null;
        currentCursor = this.getReadableDatabase().query("User", new String[] {"document",
                "email", "password","role"}, "document like '"+doc+"'"+"and password like '"+pas+"'",
                null, null, null, null);

        return currentCursor;

    }

}
