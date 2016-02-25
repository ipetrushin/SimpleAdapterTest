package com.example.it.simpleadaptertest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    HashMap<String, String> song = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> playlist =
            new ArrayList<HashMap<String, String>>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv = (ListView) findViewById(R.id.listView);
        song.put("title", "Ave Maria");
        song.put("duration", "1:50");
        playlist.add((HashMap<String, String>) song.clone());
        song.put("title", "Rock");
        song.put("duration", "3:50");
        playlist.add((HashMap<String, String>) song.clone());
        song.put("title", "Blues");
        song.put("duration", "8:10");
        playlist.add((HashMap<String, String>) song.clone());

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            song.put("title", Integer.toHexString(r.nextInt(200000)));
            song.put("duration", r.nextInt(9) + ":" + r.nextInt(60));
            playlist.add((HashMap<String, String>) song.clone());
        }

        SimpleAdapter simpleAdapter =
                new SimpleAdapter(this, playlist, R.layout.item,
                        new String[] {"title", "duration"},
                        new int[] {R.id.title, R.id.duration});
        lv.setAdapter(simpleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
