package com.example.healthfull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;


public class laporan extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button datePickerbtn;
    TextView selected_date;
    private PieChart pieChart;

    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private LineChart mlineChart;
    private static final String TAG = "laporan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

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

//-----------------------------------------------------------------------------------
        pieChart = findViewById(R.id.activiy_main_piechart);
        loadPieChartData();
        setupPieChart();
//----------------------------------------------------------------------------------
        mlineChart = (LineChart) findViewById(R.id.line_chart);

        mlineChart.setDragEnabled(true);
        mlineChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(1, 100f));
        yValues.add(new Entry(2, 250f));
        yValues.add(new Entry(3, 1000f));
        yValues.add(new Entry(4, 600f));
        yValues.add(new Entry(5, 300f));
        yValues.add(new Entry(6, 500f));
        yValues.add(new Entry(7, 2000f));

        LineDataSet set1 = new LineDataSet(yValues, "mililiter");

        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        LineData data = new LineData(dataSets);

        mlineChart.setData(data);

        datePickerbtn = findViewById(R.id.date_picker_btn);
        selected_date = findViewById(R.id.selected_date);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();

        final long today = MaterialDatePicker.todayInUtcMilliseconds();
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setSelection(today);
        final MaterialDatePicker materialDatePicker = builder.build();

        datePickerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                selected_date.setText("Date : " + materialDatePicker.getHeaderText());
            }
        });

        mlineChart = (LineChart) findViewById(R.id.line_chart2);

        mlineChart.setDragEnabled(true);
        mlineChart.setScaleEnabled(false);

        ArrayList<Entry> y2Values = new ArrayList<>();

        y2Values.add(new Entry(1, 100f));
        y2Values.add(new Entry(2, 250f));
        y2Values.add(new Entry(3, 1000f));
        y2Values.add(new Entry(4, 600f));
        y2Values.add(new Entry(5, 300f));
        y2Values.add(new Entry(6, 500f));
        y2Values.add(new Entry(7, 2000f));

        LineDataSet set2 = new LineDataSet(y2Values, "KALORI");

        set2.setFillAlpha(110);
        set2.setColors(Color.RED);
        set2.setLineWidth(3f);
        set2.setValueTextSize(10f);

        ArrayList<ILineDataSet> dataSets2 = new ArrayList<>();
        dataSets2.add(set2);
        LineData data2 = new LineData(dataSets2);

        mlineChart.setData(data2);

    }
    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(16);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("");
        pieChart.setCenterTextSize(12);
        pieChart.getDescription().setEnabled(false);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }
    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.2f, "Protein"));
        entries.add(new PieEntry(0.5f, "Carbohidrat"));
        entries.add(new PieEntry(0.8f, "Fats"));

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}