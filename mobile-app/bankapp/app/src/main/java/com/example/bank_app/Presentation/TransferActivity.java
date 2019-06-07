package com.example.bank_app.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bank_app.BussinessLogic.Controllers.SendMoney;
import com.example.bank_app.DataAccess.Repositories.AccountRepository;
import com.example.bank_app.R;

public class TransferActivity extends AppCompatActivity {
    int userAccountBalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tansfer);

        final TextView currentBalanceTextView=(TextView) findViewById(R.id.currentBalanceTextView);
        final EditText transferAccountEditText=(EditText) findViewById(R.id.transferAccountEditText);
        final EditText transferAmountEditText=(EditText) findViewById(R.id.transferAmountEditText);
        Button sendButton=(Button) findViewById(R.id.sendButton);
        final String currentUserId=getIntent().getExtras().getString("mainToTransfer");
        userAccountBalance =SendMoney.fetchBalance(this,currentUserId);
        final int userAccount =SendMoney.fetchAccNumber(this,currentUserId);
        currentBalanceTextView.setText(""+userAccountBalance);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(SendMoney.sendMoney
                        (getApplicationContext(), userAccount, Integer.parseInt(transferAccountEditText.getText().toString()), Integer.parseInt(transferAmountEditText.getText().toString()),userAccountBalance)){
                    Toast.makeText(getApplicationContext(), "Trans Accessed", Toast.LENGTH_LONG).show();
                    userAccountBalance =SendMoney.fetchBalance(getApplicationContext(),currentUserId);
                    currentBalanceTextView.setText(""+userAccountBalance);
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Information, check amount and account number", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
