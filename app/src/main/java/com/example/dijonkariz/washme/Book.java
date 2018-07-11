package com.example.dijonkariz.washme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dijonkariz.washme.Model.Package;
import com.example.dijonkariz.washme.Model.Service;
import com.example.dijonkariz.washme.Model.Vehicle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book extends AppCompatActivity {

    private RecyclerView vehicle_recyclerview, package_recyclerview, service_recyclerview;
    private PackageViewAdapter adapter;
    private VehicleViewAdapter vadapter;
    private ServiceViewAdapter sadapter;

    private List<Vehicle> vehicleList;
    private List<Package> packageList;
    private List<Service> serviceList;
    private static final String URL_VEHICLE = "http://washmeapplication.herokuapp.com/api/vehicle";
    private static final String URL_PACKAGE = "http://washmeapplication.herokuapp.com/api/package";
    private static final String URL_SERVICE = "http://washmeapplication.herokuapp.com/api/service";
    private static final String URL_BOOK = "http://washmeapplication.herokuapp.com/api/book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        vehicle_recyclerview = (RecyclerView) findViewById(R.id.vehicle_recyclerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        vehicle_recyclerview.setLayoutManager(mLayoutManager);
        vehicle_recyclerview.setItemAnimator(new DefaultItemAnimator());
        vehicle_recyclerview.setAdapter(vadapter);
        vehicleList = new ArrayList<>();
        showvehicles();

        package_recyclerview = (RecyclerView) findViewById(R.id.package_recyclerview);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        package_recyclerview.setLayoutManager(LayoutManager);
        package_recyclerview.setItemAnimator(new DefaultItemAnimator());
        package_recyclerview.setAdapter(adapter);
        packageList = new ArrayList<>();
        showPackages();

        service_recyclerview = (RecyclerView) findViewById(R.id.service_recyclerview);
        RecyclerView.LayoutManager lLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        service_recyclerview.setLayoutManager(lLayoutManager);
        service_recyclerview.setItemAnimator(new DefaultItemAnimator());
        service_recyclerview.setAdapter(sadapter);
        serviceList = new ArrayList<>();
        showServices();
    }

    private void showServices() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , URL_SERVICE
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject services = array.getJSONObject(i);


                        String name = services.getString("service_name");
                        String price = services.getString("price");
                        String timeP = services.getString("duration");
                        String details = services.getString("details");
                        int id = services.getInt("id");


                        Service service = new Service(id, name, timeP, price, details);
                        serviceList.add(service);

                    }

                    //creating adapter object and setting it to recyclerview
                    sadapter = new ServiceViewAdapter(Book.this, serviceList);
                    service_recyclerview.setAdapter(sadapter);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Book.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void showPackages() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , URL_PACKAGE
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject packages = array.getJSONObject(i);


                        String name = packages.getString("package_name");
                        String price = packages.getString("price");
                        String timeP = packages.getString("time_period");
                        String details = packages.getString("details");
                        int id = packages.getInt("id");


                        Package aPackage = new Package(id, name, price, timeP, details);
                        packageList.add(aPackage);

                    }

                    //creating adapter object and setting it to recyclerview
                    adapter = new PackageViewAdapter(Book.this, packageList);
                    package_recyclerview.setAdapter(adapter);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Book.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);

    }

    private void showvehicles() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , URL_VEHICLE
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject instructor = array.getJSONObject(i);


                        String name = instructor.getString("vehicle_name");
                        String image = instructor.getString("image");
                        int id = instructor.getInt("id");


                        Vehicle vehicle = new Vehicle(name, id, image);
                        vehicleList.add(vehicle);

                    }

                    //creating adapter object and setting it to recyclerview
                    vadapter = new VehicleViewAdapter(Book.this, vehicleList);
                    vehicle_recyclerview.setAdapter(vadapter);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Book.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void sddBooking() {

        String date = workout.getString("book_date");
        String time = workout.getString("book_time");
        String vehicle = workout.getString("vehicle_id");
        String packages = workout.getString("package_id");
        String services = workout.getString("service_id");
        String customer = workout.getString("customer_id");
        String washer = workout.getString("washer_id");
        String status = workout.getString("status");
        String amount = workout.getString("amount");


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
}
