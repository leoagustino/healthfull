package com.example.healthfull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btn1 = (Button) findViewById(R.id.btnMove);
       btn2 = (Button) findViewById(R.id.btnShare);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity.this, onboard1.class);
                startActivity(b);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intent = new Intent(Intent.ACTION_SEND);
             intent.putExtra(intent.EXTRA_TEXT,"Hallo saya share ke sosial media");
                intent.setType("text/plain");

          startActivity(Intent.createChooser(intent,"Share to :"));
            }
        });

    }
}