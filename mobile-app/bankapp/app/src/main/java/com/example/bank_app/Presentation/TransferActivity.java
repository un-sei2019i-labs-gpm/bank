package com.example.bank_app.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bank_app.R;

public class TransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tansfer);

        EditText transferAccountEditText=(EditText) findViewById(R.id.transferAccountEditText);
        EditText transferAmountEditText=(EditText) findViewById(R.id.transferAmountEditText);
        Button sendButton=(Button) findViewById(R.id.sendButton);


    }
}
