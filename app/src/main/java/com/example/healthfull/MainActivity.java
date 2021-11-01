package com.example.healthfull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


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

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), signin.class));
            }
        });

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), signup.class));
            }
        });

        findViewById(R.id.btn_dashboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), dashboard.class));
            }
        });

        findViewById(R.id.btn_menumakan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), menumakan.class));
            }
        });




    }
}

//        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), signin.class));
//            }
//        });
//
//        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), signup.class));
//            }
//        });
//
//        findViewById(R.id.btn_dashboard).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), dashboard.class));
//            }
//        });
//
//        findViewById(R.id.btn_menumakan).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), menumakan.class));
//            }
//        });

   // }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.nav_menu, menu);
//        return true;
//    }





