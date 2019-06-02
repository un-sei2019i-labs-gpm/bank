package com.example.bank_app.DataAccess.Repositories;
import android.content.ContentValues;
import android.database.Cursor;
import com.example.bank_app.DataAccess.Database.Database;
import com.example.bank_app.DataAccess.Models.User;

public class UserRepository
{
    private static boolean checkUserByDoc(Database helper,String doc)
    {
        Cursor currentCursor = null;
        currentCursor = helper.getReadableDatabase().query("User",
                new String[] {"_ID_user","email", "password","role"}, "_ID_user like '"+doc+"'", null, null, null, null);
        if(currentCursor.getCount()>0)
            return false;
        else
            return true;
    }
    private static Cursor queryByDoc(Database helper,String doc)
    {
        Cursor currentCursor = null;
        currentCursor = helper.getReadableDatabase().query("User",
                new String[] {"_ID_user","email", "password","role"}, "_ID_user like '"+doc+"'", null, null, null, null);
        return currentCursor;
    }
    public static void createUser(Database helper, User user)
    {
        if(checkUserByDoc(helper,user.getDocument()))
        {
            ContentValues valores = new ContentValues();
            valores.put("_ID_user",user.getDocument());
            valores.put("email",user.geteMail());
            valores.put("password", user.getPassword());
            valores.put("role",user.getRole());
            helper.getWritableDatabase().insert("User", null, valores);
            helper.close();
        }
    }
    public static User getUserByDoc(Database helper,String doc)
    {
        //returns a user object with the info of the query, if there is not such user, returns null

        Cursor currentCursor = queryByDoc(helper, doc);
        if(currentCursor.getCount()>0)
        {
            currentCursor.moveToFirst();
            User userFound=new User();
            int index=currentCursor.getColumnIndex("_ID_user");
            userFound.setDocument(currentCursor.getString(index));
            index=currentCursor.getColumnIndex("email");
            userFound.setEmail(currentCursor.getString(index));
            index=currentCursor.getColumnIndex("password");
            userFound.setPassword(currentCursor.getString(index));
            index=currentCursor.getColumnIndex("role");
            userFound.setRole(currentCursor.getString(index));
            helper.close();

            return userFound;
        }
        else
            return null;
    }

    public static boolean updateUser(Database helper,String doc, User upUser)//searches user by doc and then replaces it with upUser
    {
        //returns true if the user by doc exists and the update valid, and false if there is no such user

        Cursor currentCursor = queryByDoc(helper, doc);
        if(currentCursor.getCount()>0)
        {
            ContentValues values = new ContentValues();
            values.put("_ID_user",upUser.getDocument());
            values.put("email",upUser.geteMail());
            values.put("password", upUser.getPassword());
            values.put("role",upUser.getRole());
            String whereClause="_ID_user='"+doc+"'";
            helper.getWritableDatabase().update("User",values,whereClause,null);
            helper.close();
            return true;
        }
        else
            return false;
    }

    public static boolean deleteUser(Database helper,String doc)
    {
        //returns true if the user by doc exists and the update valid, and false if there is no such user

        Cursor currentCursor = queryByDoc(helper, doc);
        if(currentCursor.getCount()>0)
        {
            helper.getWritableDatabase().delete("User","_ID_user='"+doc+"'",null);
            helper.close();
            return true;
        }
        else
            return false;
    }

}
