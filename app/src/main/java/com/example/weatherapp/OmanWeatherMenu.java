package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OmanWeatherMenu extends AppCompatActivity {
    //Created By Uygar Karakus
    //Student ID: S1828602

    private Button omanbutton;
    private Button latestobseration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oman_weather_menu);

        omanbutton = (Button) findViewById(R.id.ThreeDayWeather);
        omanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOmanWeatherFeed();
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

    public void openOmanWeatherFeed() {
        Intent intent = new Intent(this, OmanWeather.class);
        startActivity(intent);
    }

    public void openLatestObservation() {
        Intent intent = new Intent(this, LatestObservationOman.class);
        startActivity(intent);
    }


}
