package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.admin.learningandroid.PassingObjectActivity.KEY_NAME;


public class ReceivingObjectActivity extends AppCompatActivity {
    TextView txtFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiving_object_layout);
        txtFullName = (TextView) findViewById(R.id.txtFullName);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        PersonName name = (PersonName) b.getParcelable(KEY_NAME);
        txtFullName.setText(name.getFname() + " " + name.getLname());


    }
}
