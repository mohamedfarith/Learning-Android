package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_of_Receiving_Object extends AppCompatActivity {
    TextView full_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_of_receiving_object);
        full_name = (TextView) findViewById(R.id.full_name);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Name_of_Person p = b.getParcelable("Name");
        full_name.setText(p.getF_name() + " " + p.getL_name());

    }
}
