package com.example.healthfull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.navigation.NavigationView;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;

public class menumakan extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private PieChart pieChart;
    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menumakan);
        pieChart = findViewById(R.id.activiy_main_piechart);
        loadPieChartData();
        setupPieChart();

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

        findViewById(R.id.lonceng1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), pengingatActivity2.class));
            }
        });
        findViewById(R.id.lonceng2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), pengingatActivity.class));
            }
        });
        findViewById(R.id.report).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), laporan.class));
            }
        });
        findViewById(R.id.tambahmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), inputMenu.class));
            }
        });



    }

        private void setupPieChart() {
            pieChart.setDrawHoleEnabled(true);
            pieChart.setUsePercentValues(true);
            pieChart.setEntryLabelTextSize(12);
            pieChart.setEntryLabelColor(Color.BLACK);
            pieChart.setCenterText("60%");
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
            entries.add(new PieEntry(0.10f, ""));

            ArrayList<Integer> colors = new ArrayList<>();
            for (int color : ColorTemplate.MATERIAL_COLORS) {
                colors.add(color);
            }

            for (int color : ColorTemplate.VORDIPLOM_COLORS) {
                colors.add(color);
            }

            PieDataSet dataSet = new PieDataSet(entries, "");
            dataSet.setColors(colors);

            PieData data = new PieData(dataSet);


            pieChart.setData(data);
            pieChart.invalidate();

            pieChart.animateY(1400, Easing.EaseInOutQuad);
        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
