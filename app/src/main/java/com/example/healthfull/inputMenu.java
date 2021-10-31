package com.example.healthfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

public class inputMenu extends AppCompatActivity {
    private TextInputLayout textInputLayout;

    private AutoCompleteTextView dropDownText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_menu);

        textInputLayout = findViewById(R.id.text_input_layout);
        dropDownText = findViewById(R.id.dropdown_text);

        String[] items = new String[] {
                "Pagi",
                "Siang",
                "Sore"

        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inputMenu.this,
                R.layout.dropdownjadwal,
                items
        );

        dropDownText.setAdapter(adapter);

    }
}