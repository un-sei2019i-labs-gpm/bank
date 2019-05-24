package com.example.bank_app;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dataAccess.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity{

    Button logInButton ;
    SQLite_OpenHelper helper = new  SQLite_OpenHelper(this, "BD1", null, 1);


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper.open();
        helper.insertReg("Andres Moya","1018","afmoyar","123456");
        helper.insertReg("Sergio Pineda","1234","saepinedave","123456");
        helper.insertReg("Cristian Garcia","4321","cgarcia","123456");

        logInButton = (Button)findViewById(R.id.logInButton);
        logInButton.setOnClickListener(new View.OnClickListener()
       {
           public void onClick(View v){
               EditText idEditText =(EditText) findViewById(R.id.idEditText);
               EditText paswordEditText =(EditText) findViewById(R.id.paswordEditText);

               try{

                   Cursor cursor = helper.validateCredentials(idEditText.getText().toString(), paswordEditText.getText().toString());
                   if(cursor.getCount()>0){
                       Toast.makeText(getApplicationContext(), "welcome", Toast.LENGTH_LONG).show();
                       //Intent i = new Intent(getApplicationContext(), Principal.class);
                       //startActivity(i);
                   }else{
                       Toast.makeText(getApplicationContext(), "wrong credentials, try again", Toast.LENGTH_LONG).show();
                   }
                   idEditText.setText("");
                   paswordEditText.setText("");
                   idEditText.findFocus();
               }catch(SQLException e){
                   Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                   e.printStackTrace();
               }
               helper.closeDataBase();
           }
       }
        );

    }
}