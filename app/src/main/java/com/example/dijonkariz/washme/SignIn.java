package com.example.dijonkariz.washme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    public EditText  email, password;
    public Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = (EditText)findViewById(R.id.userEmail);
        password = (EditText)findViewById(R.id.userPassword);
        register = (Button)findViewById(R.id.RegisterBtn);





        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
            }
        });

    }

    private void registration() {

        String Email = email.getText().toString();
        String Password = password.getText().toString();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!= null){

            String fname = bundle.getString("fname");
            String lname = bundle.getString("lname");
            String no = bundle.getString("no");
        }

        
        Toast.makeText(getApplicationContext(), "fname.lname.no.Email.Password", Toast.LENGTH_LONG).show();
    }


}
