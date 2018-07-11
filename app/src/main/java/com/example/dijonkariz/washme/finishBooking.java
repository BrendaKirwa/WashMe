package com.example.dijonkariz.washme;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dijonkariz.washme.Model.DatePicker;
import com.example.dijonkariz.washme.Model.TimePicker;
import com.example.dijonkariz.washme.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class finishBooking extends AppCompatActivity {
 TextView Date, time;
    TextInputLayout vehicle, packages,service, customer;
    Button submit;
    private static final String URL_BOOK = "http://washmeapplication.herokuapp.com/api/book";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_booking);

        vehicle = (TextInputLayout)findViewById(R.id.vehicle);
        packages = (TextInputLayout)findViewById(R.id.packages);
        service = (TextInputLayout)findViewById(R.id.service);
        customer = (TextInputLayout)findViewById(R.id.customer);
        submit = (Button)findViewById(R.id.btnsend);

        User user = SharedPrefManager.getInstance(this).getUser();
        customer.getEditText().setText(String.valueOf(user.getId()));

        Intent intent = getIntent();
        String Vehicle_id = intent.getExtras().getString("Vehicle_id");

        vehicle.getEditText().setText(Vehicle_id);
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (month_string + "/" + day_string + "/" + year_string);

        Date = (TextView) findViewById(R.id.wdate);
        Date.setText(dateMessage);

    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);

        time = (TextView) findViewById(R.id.wtime);
        time.setText(timeMessage);

    }
    public void showdate(View view) {
        DatePicker fragment = new DatePicker();
        fragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
    }

    private void addBooking() {

        final String book_time = time.getText().toString().trim();
        final String book_date = Date.getText().toString().trim();
        final String vehicle_id = vehicle.getEditText().getText().toString().trim();
        final String package_id = packages.getEditText().getText().toString().trim();
        final String service_id = service.getEditText().getText().toString().trim();
        final String customer_id = customer.getEditText().getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_BOOK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject obj = new JSONObject(response);

                    if (!obj.getBoolean("status")) {

                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();


                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();
                    }
                    startActivity(new Intent(getApplicationContext(), Book.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("book_date", book_date);
                params.put("book_time", book_time);
                params.put("vehicle_id", vehicle_id);
                params.put("package_id", package_id);
                params.put("service_id", service_id);
                params.put("customer_id", customer_id);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void showtime(View view) {
        DialogFragment newFragment = new TimePicker();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
    }
}
