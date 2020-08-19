package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class LatestObservationNewYork extends AppCompatActivity {
    //Created By Uygar Karakus
    //Student ID: S1828602

    ListView lvTitle;
    ListView lvDescription;
    ListView lvPubDate;
    ArrayList<String> titles;
    ArrayList<String> description;
    ArrayList<String> pubdate;
    ArrayList<String> links;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_observation_new_york);

        lvTitle = (ListView) findViewById(R.id.lvTitle);
        lvDescription = (ListView) findViewById(R.id.lvDescription);
        lvPubDate = (ListView)  findViewById(R.id.lvPubDate);

        titles = new ArrayList<String>();
        description = new ArrayList<String>();
        pubdate = new ArrayList<String>();
        links = new ArrayList<String>();

        lvTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri bbclink = Uri.parse(links.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, bbclink);
                startActivity(intent);

            }
        });

        new LatestObservationNewYork.BackgroundProccessing().execute();

    }

    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }

    }

    public class BackgroundProccessing extends AsyncTask<Integer, Void, Exception> {

        ProgressDialog progressDialog = new ProgressDialog(LatestObservationNewYork.this);

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
                //neywork latest observation url
                URL url = new URL("https://weather-broker-cdn.api.bbci.co.uk/en/observation/rss/5128581");

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

                factory.setNamespaceAware(false);

                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(getInputStream(url), "UTF_8");

                //sets inside item to false
                boolean insideItem = false;

                int eventType = xpp.getEventType();


                while(eventType != XmlPullParser.END_DOCUMENT){
                    if (eventType == XmlPullParser.START_TAG)
                    {
                        //checks if the item its an item tag
                        if (xpp.getName().equalsIgnoreCase("item"))
                        {
                            //if it is an item tag it will set inside item to true
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

                        else if (xpp.getName().equalsIgnoreCase("pubDate"))
                        {
                            if (insideItem)
                            {
                                pubdate.add(xpp.nextText());
                            }
                        }
                        else if (xpp.getName().equalsIgnoreCase("link"))
                        {
                            if (insideItem)
                            {
                                links.add(xpp.nextText());
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

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(LatestObservationNewYork.this,  android.R.layout.simple_list_item_1, titles);
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(LatestObservationNewYork.this,  android.R.layout.simple_list_item_1, description);
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(LatestObservationNewYork.this,  android.R.layout.simple_list_item_1, pubdate);







            lvTitle.setAdapter(adapter);


            lvDescription.setAdapter(adapter2);

            lvPubDate.setAdapter(adapter3);






            progressDialog.dismiss();


            //////


        }


    }
}
