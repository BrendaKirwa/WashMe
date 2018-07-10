package com.example.dijonkariz.washme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dijonkariz.washme.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {

    public EditText email, password;
    public Button login;
    private static final String URL_LOGIN = "https://washmeapplication.herokuapp.com/api/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        if (SharedPrefManager.getInstance(this).areLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        email = (EditText) findViewById(R.id.loginemail);
        password = (EditText) findViewById(R.id.loginpassword);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHomeActivity();
            }
        });
    }

    public void resetActivityStart(View view) {
        Intent intent = new Intent(this, ResetPassword.class);
        startActivity(intent);
    }

    public void SignInActivityStart(View view) {
        Intent intent = new Intent(this, SignInTwo.class);
        startActivity(intent);
    }

    public void startHomeActivity() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loggining");
        progressDialog.show();

        final String FirstName = email.getText().toString();
        final String FirstPassword = password.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);

                    if (obj.getBoolean("status")) {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        JSONObject users = obj.getJSONObject("user");

                        User user = new User(
                                users.getInt("id"),
                                users.getString("name"),
                                users.getString("user_type")
                        );


                        SharedPrefManager.getInstance(getApplicationContext()).Login(user);

                        progressDialog.dismiss();
                        finish();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", FirstName);
                params.put("password", FirstPassword);
                return params;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
