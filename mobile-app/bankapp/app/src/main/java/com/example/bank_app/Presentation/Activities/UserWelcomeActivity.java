package com.example.bank_app.Presentation.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.bank_app.R;


public class UserWelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_welcome);

        final String currentUserId=getIntent().getExtras().getString("mainToWelcomeCurrentUser");
        TextView currentBalanceTextView=(TextView) findViewById(R.id.currentBalanceTextView);
        Button transferButton=(Button) findViewById(R.id.transferButton);
        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), TransferActivity.class);
                i.putExtra("WelcomeToTransferCurrentUser",currentUserId);
                startActivity(i);
            }
        });
    }
}
