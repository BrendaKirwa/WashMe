package com.example.dijonkariz.washme;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInTwo extends AppCompatActivity {

    public EditText firstname, lastname, phonenumber;
    public Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_two);

        firstname = (EditText)findViewById(R.id.firstName);
        lastname = (EditText)findViewById(R.id.lastName);
        phonenumber = (EditText)findViewById(R.id.phoneNumber);
        continueBtn = (Button) findViewById(R.id.continuebtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContinueSignIn();
            }
        });

    }


    public void ContinueSignIn() {

      String fname =  firstname.getText().toString();
      String lname =  lastname.getText().toString();
       String no =  phonenumber.getText().toString();

        Intent intentBundle = new Intent(this, SignIn.class);
        Bundle bundle = new Bundle();
        bundle.putString("fname", fname);
        bundle.putString("lname", lname);
        bundle.putString("no", no);
        intentBundle.putExtras(bundle);
        startActivity(intentBundle);
    }

    public void LoginActivityStart(View view) {
        Intent intent2 = new Intent(this, LogIn.class);
        startActivity(intent2);
    }
}
