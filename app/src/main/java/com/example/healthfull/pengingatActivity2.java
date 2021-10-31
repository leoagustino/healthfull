package com.example.healthfull;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class pengingatActivity2 extends AppCompatActivity {
    TextView alarm1;
    int t1Hour, t1Minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengingat2);
        alarm1 = findViewById(R.id.alarm1);

        alarm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        pengingatActivity2.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0, 0, 0, t1Hour, t1Minute);

                                alarm1.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);

                timePickerDialog.show();
            }
        });

    }
}