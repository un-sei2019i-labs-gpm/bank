package com.example.bank_app.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.BussinessLogic.Controllers.SendMoney;

import com.example.bank_app.R;

public class MainActivity extends AppCompatActivity{

    Button logInButton ;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SendMoney.populateDataBase(this);
        logInButton = (Button)findViewById(R.id.logInButton);
        logInButton.setOnClickListener(new View.OnClickListener()
       {

           public void onClick (View v){
            EditText idEditText = (EditText) findViewById(R.id.idEditText);
            EditText paswordEditText = (EditText) findViewById(R.id.paswordEditText);
            boolean logIn=SendMoney.logIn(getApplicationContext(),idEditText.getText().toString(), paswordEditText.getText().toString());
            if (logIn) {
                Toast.makeText(getApplicationContext(), "welcome", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), TransferActivity.class);
                i.putExtra("mainToTransfer",idEditText.getText().toString());
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