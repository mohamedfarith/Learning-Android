package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonActivity;
    Button buttonLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        buttonActivity = findViewById(R.id.activityButton);
        buttonLayout = findViewById(R.id.layoutButton);
buttonActivity.setOnClickListener(this);
buttonLayout.setOnClickListener(this);


}

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.activityButton:
                Intent intent = new Intent(MainActivity.this, LearningActivity.class);
                startActivity(intent);
                break;
            case R.id.layoutButton:
                Intent in = new Intent(MainActivity.this,LearningLayouts.class);
                startActivity(in);
                break;
    }
      /* buttonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LearningActivity.class);
                startActivity(intent);
            }
        });*/

    }
}
