package com.example.dijonkariz.washme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dijonkariz.washme.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignInTwo extends AppCompatActivity {

    public EditText firstname, lastname, phonenumber, email, password;
    public Button continueBtn;

    private static final String URL_REGISTER = "https://washmeapplication.herokuapp.com/api/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_two);

        firstname = (EditText)findViewById(R.id.firstName);
        lastname = (EditText)findViewById(R.id.lastName);
        phonenumber = (EditText)findViewById(R.id.phoneNumber);
        email = (EditText)findViewById(R.id.userEmail);
        password = (EditText)findViewById(R.id.userPassword);
        continueBtn = (Button) findViewById(R.id.continuebtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContinueSignIn();
            }
        });

    }


    public void ContinueSignIn() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("registering user");
        progressDialog.show();

      final String fname =  firstname.getText().toString().trim();
      final String lname =  lastname.getText().toString().trim();
      final String no =  phonenumber.getText().toString().trim();
      final String Email = email.getText().toString().trim();
      final String Password = password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL_REGISTER,
                new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject obj = new JSONObject(response);


                            if (obj.getBoolean("status")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();

                                JSONObject users = obj.getJSONObject("user");
//                                for (int i = 0; i < array.length(); i++) {
//
//                                    JSONObject users = array.getJSONObject(i);


                                User user = new User(
                                        users.getInt("id"),
                                        users.getString("name"),
                                        users.getString("user_type")
                                );
                                SharedPrefManager.getInstance(getApplicationContext()).Login(user);
//                                }
                                progressDialog.dismiss();
                                finish();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("first_name", fname);
                params.put("last_name", lname);
                params.put("email", Email);
                params.put("phone_number", no);
                params.put("password", Password);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);




    }

    public void LoginActivityStart(View view) {
        Intent intent2 = new Intent(this, LogIn.class);
        startActivity(intent2);
    }
}
