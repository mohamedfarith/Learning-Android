package com.example.admin.learningandroid.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.R;

public class LearningLayouts extends AppCompatActivity implements View.OnClickListener {

    public Button btnLinear;
    public Button btnRelative;
    public Button btnConstraint;
    public Button btnModelLoginPage;
    public Button btnRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_layouts);
        btnLinear = findViewById(R.id.btn_linear);
        btnRelative = findViewById(R.id.btn_relative);
        btnConstraint = findViewById(R.id.btn_constraint);
        btnRecyclerView = findViewById(R.id.btn_recycler_view);
        btnModelLoginPage = findViewById(R.id.btn_model_login_page);

        btnLinear.setOnClickListener(this);
        btnRelative.setOnClickListener(this);
        btnConstraint.setOnClickListener(this);
        btnRecyclerView.setOnClickListener(this);
        btnModelLoginPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recycler_view:
                Intent intentRecycler = new Intent(LearningLayouts.this, RecyclerViewActivity.class);
                startActivity(intentRecycler);
                break;
            case R.id.btn_linear:
                Intent intentLinear = new Intent(LearningLayouts.this, LinearLayoutActivity.class);
                startActivity(intentLinear);
                break;
            case R.id.btn_relative:
                Intent intentRelative = new Intent(LearningLayouts.this, RelativeLayoutActivity.class);
                startActivity(intentRelative);
                break;
            case R.id.btn_constraint:
                Intent intentConstraint = new Intent(LearningLayouts.this, ConstraintLayoutActivity.class);
                startActivity(intentConstraint);
                break;
            case R.id.btn_model_login_page:
                Intent intentModelLogin= new Intent(LearningLayouts.this,ModelLoginActivity.class);
                startActivity(intentModelLogin);
                break;


        }
    }
}


