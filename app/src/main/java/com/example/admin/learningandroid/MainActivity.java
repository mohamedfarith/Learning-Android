package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.activity.LearningActivity;
import com.example.admin.learningandroid.fragments.FragmentActivity;
import com.example.admin.learningandroid.layouts.LearningLayouts;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button buttonActivity;
    public Button buttonLayout;
    public Button buttonFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        buttonActivity = findViewById(R.id.activity_button);
        buttonLayout = findViewById(R.id.layout_button);
        buttonFragments = findViewById(R.id.fragment_button);
        buttonFragments.setOnClickListener(this);
        buttonActivity.setOnClickListener(this);
        buttonLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_button:
                Intent intentActivity = new Intent(MainActivity.this, LearningActivity.class);
                startActivity(intentActivity);
                break;
            case R.id.layout_button:
                Intent intentLayouts = new Intent(MainActivity.this, LearningLayouts.class);
                startActivity(intentLayouts);
                break;
            case R.id.fragment_button:
                Intent intentFragments = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intentFragments);
        }


    }
}
