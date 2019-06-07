package com.example.bank_app.Presentation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.DataAccess.Models.User;
import com.example.bank_app.DataAccess.Repositories.UserRepository;
import com.example.bank_app.Presentation.UserWelcomeActivity;

import com.example.bank_app.DataAccess.Database.Database;
import com.example.bank_app.R;

public class MainActivity extends AppCompatActivity{

    Button logInButton ;
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserRepository.createUser(this,new User("afmoyar","123456","user","1018"));
        UserRepository.createUser(this,new User("email","123456","user","1234"));
        logInButton = (Button)findViewById(R.id.logInButton);

        logInButton.setOnClickListener(new View.OnClickListener()
       {

           public void onClick (View v){
            EditText idEditText = (EditText) findViewById(R.id.idEditText);
            EditText paswordEditText = (EditText) findViewById(R.id.paswordEditText);
            Cursor cursor = Database.createHelper(getApplicationContext()).validateCredentials(idEditText.getText().toString(), paswordEditText.getText().toString());
            if (cursor.getCount() > 0) {
                Toast.makeText(getApplicationContext(), "welcome", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), UserWelcomeActivity.class);
                i.putExtra("mainToWelcomeCurrentUser",idEditText.getText().toString());
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "wrong credentials, try again", Toast.LENGTH_LONG).show();
            }
            idEditText.setText("");
            paswordEditText.setText("");
            idEditText.findFocus();
           }
       }
        );
    }
}