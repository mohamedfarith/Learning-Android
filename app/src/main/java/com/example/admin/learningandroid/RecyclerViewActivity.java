package com.example.admin.learningandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

public class RecyclerViewActivity extends AppCompatActivity {
    String[] mStr = {"Monday", "Tuesday", "Wednesday", "Thursday","Friday" ,"Saturday", "Sunday", "January", "February", "March", "April", "May", "June", "July", "August","September","October","November","December"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //Setting Layout as linear Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(mStr, this));
        //Divider Line
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}

