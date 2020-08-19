package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GlasgowWeatherMenu extends AppCompatActivity {

    //Created By Uygar Karakus
    //Student ID: S1828602

    private Button glasgowbutton;
    private Button latestobseration;
    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glasgow_weather_menu);

        glasgowbutton = (Button) findViewById(R.id.ThreeDayWeather);
        glasgowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGlasgowWeatherFeed();
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

    public void openGlasgowWeatherFeed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openLatestObservation() {
        Intent intent = new Intent(this, LatestObservationGlasgow.class);
        startActivity(intent);
    }
}
