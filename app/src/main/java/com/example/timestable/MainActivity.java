package com.example.timestable;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static int max = 19;
    static int startingPosition = 10;
    SeekBar eingabeWertSeekBar;

    public void generiereAusgabeWerte(int eingabeWert) {

        ListView werteListView = findViewById(R.id.ausgabeWerteLV);

        ArrayList<String> werteContent = new ArrayList<String>();

        for (int i = 1; i <= 100; i++) {
            werteContent.add(Integer.toString(i * eingabeWert));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, werteContent);

        werteListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eingabeWertSeekBar = findViewById(R.id.eingabeWertSB);

        eingabeWertSeekBar.setMax(max);
        eingabeWertSeekBar.setProgress(startingPosition);

        generiereAusgabeWerte(startingPosition);

        eingabeWertSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Log.i("Seekbarwert: ", Integer.toString(i + 1)); // +1 um 0 zu umgehen

                generiereAusgabeWerte(i + 1); // + damit kein * 0 möglich ist
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
