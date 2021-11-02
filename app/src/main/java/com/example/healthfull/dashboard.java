package com.example.healthfull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private PieChart pieChart;
    private PieChart pieChart2;
    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    TextView name, email, id;
    ImageView profil;
    Button signOut;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        findViewById(R.id.btn_menumakan1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), menumakan.class));
            }
        });



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        profil = findViewById(R.id.userprofil);
        name = findViewById(R.id.username);
        email = findViewById(R.id.textemail);
        id = findViewById(R.id.textid);
        signOut = findViewById(R.id.btn_logout);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_logout:
                        signOut();
                        break;
                }

            }
        });


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
//            String personGivenName = acct.getGivenName();
//            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
            name.setText(personName);
            email.setText(personEmail);
            id.setText(personId);
            Glide.with(this).load(String.valueOf(personPhoto)).into(profil);
            //Glide.with(this).load(String.valueOf(personPhoto)).into(profil);
        }



        pieChart = findViewById(R.id.activiy_main_piechart);
        loadPieChartData();
        setupPieChart();

        pieChart2 = findViewById(R.id.activiy_main_piechart2);
        loadPieChartData2();
        setupPieChart2();

        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                mToolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(dashboard.this, "SignedOut Successfully", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }
        private void setupPieChart() {
            pieChart.setDrawHoleEnabled(true);
            pieChart.setUsePercentValues(true);
            pieChart.setEntryLabelTextSize(12);
            pieChart.setEntryLabelColor(Color.BLACK);
            pieChart.setCenterText("Waktu Tidur");
            pieChart.setCenterTextSize(12);
            pieChart.getDescription().setEnabled(false);

            Legend l = pieChart.getLegend();
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
            l.setOrientation(Legend.LegendOrientation.VERTICAL);
            l.setDrawInside(false);
            l.setEnabled(true);
        }
        private void loadPieChartData() {
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(0.2f, ""));
            entries.add(new PieEntry(0.5f, ""));

            ArrayList<Integer> colors = new ArrayList<>();
            for (int color: ColorTemplate.MATERIAL_COLORS) {
                colors.add(color);
            }

            for (int color: ColorTemplate.VORDIPLOM_COLORS) {
                colors.add(color);
            }

            PieDataSet dataSet = new PieDataSet(entries, "");
            dataSet.setColors(colors);

            PieData data = new PieData(dataSet);


            pieChart.setData(data);
            pieChart.invalidate();

            pieChart.animateY(1400, Easing.EaseInOutQuad);

    }

    private void setupPieChart2() {
        pieChart2.setDrawHoleEnabled(true);
        pieChart2.setUsePercentValues(true);
        pieChart2.setEntryLabelTextSize(12);
        pieChart2.setEntryLabelColor(Color.BLACK);
        pieChart2.setCenterText("Tingkat Kalori");
        pieChart2.setCenterTextSize(12);
        pieChart2.getDescription().setEnabled(false);

        Legend l = pieChart2.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }
    private void loadPieChartData2() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.2f, ""));
        entries.add(new PieEntry(0.15f, ""));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet2 = new PieDataSet(entries, "");
        dataSet2.setColors(colors);

        PieData data2 = new PieData(dataSet2);


        pieChart2.setData(data2);
        pieChart2.invalidate();

        pieChart2.animateY(1400, Easing.EaseInOutQuad);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void pindahOlahraga(View view) {
        Intent intent = new Intent(dashboard.this, olahraga.class);
        startActivity(intent);
    }
}

