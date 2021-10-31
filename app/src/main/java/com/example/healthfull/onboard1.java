package com.example.healthfull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class onboard1 extends AppCompatActivity {

    Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard1);


        btn1 = (Button) findViewById(R.id.skip);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(onboard1.this, onboard2.class);
                startActivity(a);
            }
        });



    }
}