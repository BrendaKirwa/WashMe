package com.example.dijonkariz.washme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignIn extends AppCompatActivity {

    @BindView(R.id.username)EditText username;
    @BindView(R.id.userEmail)EditText userEmail;
    @BindView(R.id.userPassword)EditText userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.RegisterBtn)
    void Register(){

    }
}
