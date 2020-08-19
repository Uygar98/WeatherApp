package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LondonWeatherMenu extends AppCompatActivity {
    //Created By Uygar Karakus
    //Student ID: S1828602


    private Button londonbutton;
    private Button latestobseration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_london_weather_menu);

        londonbutton = (Button) findViewById(R.id.ThreeDayWeather);
        londonbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLondonWeatherFeed();
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

    public void openLondonWeatherFeed() {
        Intent intent = new Intent(this, LondonWeather.class);
        startActivity(intent);
    }

    public void openLatestObservation() {
        Intent intent = new Intent(this, LatestObservationLondon.class);
        startActivity(intent);
    }

}
