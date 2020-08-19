package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MauritiusWeatherMenu extends AppCompatActivity {
    //Created By Uygar Karakus
    //Student ID: S1828602


    private Button mauritiusbutton;
    private Button latestobseration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mauritius_weather_menu);

        mauritiusbutton = (Button) findViewById(R.id.ThreeDayWeather);
        mauritiusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMauritiusWeatherFeed();
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

    public void openMauritiusWeatherFeed() {
        Intent intent = new Intent(this, MauritiusWeather.class);
        startActivity(intent);
    }

    public void openLatestObservation() {
        Intent intent = new Intent(this, LatestObservationMauritius.class);
        startActivity(intent);
    }
}
