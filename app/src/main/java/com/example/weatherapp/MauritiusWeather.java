package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MauritiusWeather extends AppCompatActivity {
    //Created By Uygar Karakus
    //Student ID: S1828602


    ListView lvMauritius;
    ListView lvDescription;
    ArrayList<String> titles;
    ArrayList<String> description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mauritius_weather);


        lvMauritius = (ListView) findViewById(R.id.lvMauritius);
        lvDescription = (ListView) findViewById(R.id.lvDescription) ;


        titles = new ArrayList<String>();
        description = new ArrayList<String>();



        new MauritiusWeather.BackgroundProccessing().execute();
    }


    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }

    }

    public class BackgroundProccessing extends AsyncTask<Integer, Void, Exception> {

        ProgressDialog progressDialog = new ProgressDialog(MauritiusWeather.this);

        Exception exception = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("loading feed");
            progressDialog.show();
        }

        @Override
        protected Exception doInBackground(Integer... integers) {
            try {
                URL url = new URL("https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2643123");

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

                factory.setNamespaceAware(false);

                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(getInputStream(url), "UTF_8");

                boolean insideItem = false;

                int eventType = xpp.getEventType();


                while(eventType != XmlPullParser.END_DOCUMENT){
                    if (eventType == XmlPullParser.START_TAG)
                    {
                        if (xpp.getName().equalsIgnoreCase("item"))
                        {
                            insideItem = true;

                        }

                        else if (xpp.getName().equalsIgnoreCase("title"))
                        {
                            if (insideItem)
                            {
                                titles.add(xpp.nextText());
                            }
                        }
                        else if (xpp.getName().equalsIgnoreCase("description"))
                        {
                            if (insideItem)
                            {
                                description.add(xpp.nextText());
                            }
                        }


                    }
                    else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item") )
                    {
                        insideItem = false;
                    }

                    eventType = xpp.next();
                }

            } catch (MalformedURLException e) {
                exception = e;
            }
            catch (XmlPullParserException e ){
                exception = e;
            }
            catch (IOException e){
                exception = e;
            }


            return exception;
        }

        @Override
        protected void onPostExecute(Exception s) {
            super.onPostExecute(s);
            String[] values = new String[]{"Day1", "Day2", "Day3"};

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MauritiusWeather.this,  android.R.layout.simple_list_item_1, titles);
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MauritiusWeather.this,  android.R.layout.simple_list_item_1, description);





            lvMauritius.setAdapter(adapter);


            lvDescription.setAdapter(adapter2);






            progressDialog.dismiss();


            //////


        }


    }

}
