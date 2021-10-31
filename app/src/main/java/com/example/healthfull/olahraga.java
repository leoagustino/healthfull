package com.example.healthfull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class olahraga extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olahraga);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.menu_bawah);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.activity:
                        Toast.makeText(olahraga.this, "Activity clicked", Toast.LENGTH_SHORT).show();
                    case R.id.eat:
                        Toast.makeText(olahraga.this, "Eat clicked", Toast.LENGTH_SHORT).show();
                    case R.id.home:
                        Toast.makeText(olahraga.this, "Home clicked", Toast.LENGTH_SHORT).show();
                    case R.id.weight:
                        Toast.makeText(olahraga.this, "Weight clicked", Toast.LENGTH_SHORT).show();
                    case R.id.evaluasi:
                        Toast.makeText(olahraga.this, "Evaluation clicked", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        eText=(EditText) findViewById(R.id.editTextDate);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(olahraga.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

    }
}