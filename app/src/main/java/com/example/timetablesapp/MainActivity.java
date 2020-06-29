package com.example.timetablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {

    ListView timeTablesListView;
    public void generateTimesTables(int timeTablesNumber)
    {
        ArrayList<String> a = new ArrayList<String>();
        for(int j=1;j<=21;j++)
        {
            a.add(timeTablesNumber+" * "+j +" = " + Integer.toString(timeTablesNumber*j));

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,a);
        timeTablesListView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timeTablesSeekBar = (SeekBar)findViewById(R.id.timeTableSeekBar);
        timeTablesListView = (ListView)findViewById(R.id.timeTablesListView);
        int startingPoint=1;
        timeTablesSeekBar.setMax(25);
        timeTablesSeekBar.setProgress(startingPoint);
        generateTimesTables(startingPoint);
        timeTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timeTablesNumber;
                if(progress<1)
                {
                    timeTablesNumber=min;
                    timeTablesSeekBar.setProgress(min);
                }
                else{
                    timeTablesNumber=progress;
                }
                Log.i("Seekbar value:",Integer.toString(timeTablesNumber));
                generateTimesTables(timeTablesNumber);

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
