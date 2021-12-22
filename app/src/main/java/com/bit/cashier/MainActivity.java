package com.bit.cashier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button plus, minus;
    TextView counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        counter = findViewById(R.id.counter);
        recyclerView = findViewById(R.id.recycle_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);


        ArrayList<Unit> units = new ArrayList<>();
        units.add(new Unit("05 DA", 2));
        units.add(new Unit("10 DA", 8));
        units.add(new Unit("20 DA", 6));
        units.add(new Unit("50 DA", 25));
        units.add(new Unit("100 DA", 10));
        units.add(new Unit("200 DA", 16));
        units.add(new Unit("1000 DA", 14));
        units.add(new Unit("2000 DA", 18));
        units.add(new Unit("10000 DA", 5));

        UnitAdapter adapter = new UnitAdapter(units);
        recyclerView.setAdapter(adapter);
    }
}