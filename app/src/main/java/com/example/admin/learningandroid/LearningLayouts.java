package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LearningLayouts extends AppCompatActivity implements View.OnClickListener {

    Button btnLinear;
    Button btnRelative;
    Button btnConstraint;
    Button btnFrame;
    Button btnRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_layouts);
        btnLinear = findViewById(R.id.btnLinear);
        btnRelative = findViewById(R.id.btnRelative);
        btnConstraint = findViewById(R.id.btnConstraint);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);

        btnLinear.setOnClickListener(this);
        btnRelative.setOnClickListener(this);
        btnConstraint.setOnClickListener(this);
        btnRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRecyclerView:
                Intent intent = new Intent(LearningLayouts.this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLinear:
                Intent in = new Intent(LearningLayouts.this, LinearLayoutActivty.class);
                startActivity(in);
                break;
            case R.id.btnRelative:
                Intent i = new Intent(LearningLayouts.this, RelativeLayoutActivity.class);
                startActivity(i);
                break;
            case R.id.btnConstraint:
                Intent t= new Intent(LearningLayouts.this,ConstriantLayoutActivity.class);
                startActivity(t);


        }
    }
}
