package com.estsoft.datepickerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String timeText = "";
                boolean is24HourView = timePicker.is24HourView();

                if(is24HourView == false) {
                    if (hourOfDay > 12) {
                        hourOfDay -= 12;
                        timeText += "PM ";
                    } else {
                        timeText += "AM ";
                    }
                }
                timeText += hourOfDay + " : " + minute;

                ((TextView)findViewById(R.id.timeText)).setText(timeText);
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();
                Toast.makeText(MainActivity.this, hour + " : " + minute, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean is24HourView = timePicker.is24HourView();
                timePicker.setIs24HourView(!is24HourView);
            }
        });
    }
}
