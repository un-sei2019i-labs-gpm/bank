package com.example.bank_app.Presentation.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bank_app.BussinessLogic.Controllers.SendMoneyController;
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
        userAccountBalance = SendMoneyController.fetchBalance(this,currentUserId);
        final int userAccount = SendMoneyController.fetchAccNumber(this,currentUserId);
        currentBalanceTextView.setText(""+userAccountBalance);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(SendMoneyController.sendMoney
                        (getApplicationContext(), userAccount, Integer.parseInt(transferAccountEditText.getText().toString()), Integer.parseInt(transferAmountEditText.getText().toString()),userAccountBalance)){
                    Toast.makeText(getApplicationContext(), "Trans Accessed", Toast.LENGTH_LONG).show();
                    userAccountBalance = SendMoneyController.fetchBalance(getApplicationContext(),currentUserId);
                    currentBalanceTextView.setText(""+userAccountBalance);
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Information, check amount and account number", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
