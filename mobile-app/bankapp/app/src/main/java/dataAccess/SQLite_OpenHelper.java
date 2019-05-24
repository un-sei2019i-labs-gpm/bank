package dataAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SQLite_OpenHelper extends SQLiteOpenHelper{
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
        String query = "create table user(_ID integer primary key autoincrement, document text unique, name text, email text, password text);";
        db.execSQL(query);
    }

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

    public void insertReg(String name, String doc, String email, String pas){
        ContentValues valores = new ContentValues();
        valores.put("document",doc);
        valores.put("name", name);
        valores.put("email",email);
        valores.put("password", pas);
        this.getWritableDatabase().insert("user", null, valores);
    }

    //metodo para validar si el usuario existe

    public Cursor validateCredentials(String doc, String pas) throws SQLException
    {
        Cursor currentCursor = null;
        currentCursor = this.getReadableDatabase().query("user", new String[] {"_ID",
                "document","name", "email", "password"}, "document like '"+doc+"'"+
                "and password like '"+pas+"'", null, null, null, null);

        return currentCursor;

    }

}
