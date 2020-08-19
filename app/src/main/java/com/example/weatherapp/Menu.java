package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    //Created By Uygar Karakus
    //Student ID: S1828602

    private Button glasgowbutton;
    private Button londonbutton;
    private Button newyorkbutton;
    private Button omanbutton;
    private Button bangbutton;
    private Button mauritiusbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        londonbutton = (Button) findViewById(R.id.londonbutton);
        londonbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLondonWeatherFeed();
            }


        });


        //this is for glasgow
        glasgowbutton = (Button) findViewById(R.id.button);
        glasgowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGlasgowWeatherFeed();
            }


        });



        ///////////////////////


        newyorkbutton = (Button) findViewById(R.id.NewYorkbutton);
        newyorkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNeyworkWeatherFeed();
            }


        });

        omanbutton = (Button) findViewById(R.id.OmanButton);
        omanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOmanWeatherFeed();
            }


        });

        bangbutton = (Button) findViewById(R.id.BangladeshButton);
        bangbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBangladeshWeatherFeed();
            }


        });

        mauritiusbutton = (Button) findViewById(R.id.MauritusButton);
        mauritiusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMauritiusWeatherFeed();
            }


        });




    }

    ///this part of the code opens the page that this clicked on
    public void openGlasgowWeatherFeed() {
        Intent intent = new Intent(this, GlasgowWeatherMenu.class);
        startActivity(intent);
    }

    public void openLondonWeatherFeed() {
        Intent intent = new Intent(this, LondonWeatherMenu.class);
        startActivity(intent);
    }

    public void openNeyworkWeatherFeed() {
        Intent intent = new Intent(this, NewyorkWeatherMenu.class);
        startActivity(intent);
    }

    public void openOmanWeatherFeed() {
        Intent intent = new Intent(this, OmanWeatherMenu.class);
        startActivity(intent);
    }

    public void openBangladeshWeatherFeed() {
        Intent intent = new Intent(this, BangladeshWeatherMenu.class);
        startActivity(intent);
    }

    public void openMauritiusWeatherFeed() {
        Intent intent = new Intent(this, MauritiusWeatherMenu.class);
        startActivity(intent);
    }
}
