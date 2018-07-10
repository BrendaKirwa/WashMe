package com.example.dijonkariz.washme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dijonkariz.washme.Model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Fname = (TextView)findViewById(R.id.names);
        User user = SharedPrefManager.getInstance(this).getUser();
        String names = user.getName();
        Fname.setText(names);

        final ProgressBar pbar = (ProgressBar)findViewById(R.id.progress);

        final Intent intent = new Intent(this, Home.class);

        Thread timer = new Thread() {

            public void run () {

                try {
                    sleep(1000);
                    pbar.setProgress(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {

                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
    }


