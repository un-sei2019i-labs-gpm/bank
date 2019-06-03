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

        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        EditText transferAmountEditText=(EditText) findViewById(R.id.transferAmountEditText);
        Button dd=(Button) findViewById(R.id.sendButton);

        String[] llenarSpinnerPrueba=new String[]{"user"};
        ArrayAdapter adap=new ArrayAdapter(this,android.R.layout.simple_spinner_item,llenarSpinnerPrueba);
        spinner.setAdapter(adap);
    }
}
