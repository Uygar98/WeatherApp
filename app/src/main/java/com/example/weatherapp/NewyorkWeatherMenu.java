package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewyorkWeatherMenu extends AppCompatActivity {
    //Created By Uygar Karakus
    //Student ID: S1828602


    private Button newyorkweather;
    private Button latestobseration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newyork_weather_menu);

        newyorkweather = (Button) findViewById(R.id.ThreeDayWeather);
        newyorkweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNeyworkWeatherFeed();
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

    public void openNeyworkWeatherFeed() {
        Intent intent = new Intent(this, NewyorkWeather.class);
        startActivity(intent);
    }

    public void openLatestObservation() {
        Intent intent = new Intent(this, LatestObservationNewYork.class);
        startActivity(intent);
    }
}
