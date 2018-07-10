package com.example.dijonkariz.washme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void resetActivityStart(View view) {
        Intent intent = new Intent(this, ResetPassword.class);
        startActivity(intent);
    }

    public void SignInActivityStart(View view) {
        Intent intent = new Intent(this, SignInTwo.class);
        startActivity(intent);
    }

    public void startHomeActivity(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
