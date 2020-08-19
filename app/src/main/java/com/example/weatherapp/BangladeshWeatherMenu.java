package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BangladeshWeatherMenu extends AppCompatActivity {

    //Created By Uygar Karakus
    //Student ID: S1828602

    private Button bangladeshbuttonn;
    private Button latestobseration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangladesh_weather_menu);

        bangladeshbuttonn = (Button) findViewById(R.id.ThreeDayWeather);
        bangladeshbuttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBangladeshWeatherFeed();
            }


        });


        latestobseration = (Button) findViewById(R.id.CurrentWeather);
        latestobseration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLatestObservation();
            }


        });




    }

    public void openBangladeshWeatherFeed() {
        Intent intent = new Intent(this, BangladeshWeather.class);
        startActivity(intent);
    }

    public void openLatestObservation() {
        Intent intent = new Intent(this, LatestObservationBangladesh.class);
        startActivity(intent);
    }
}
