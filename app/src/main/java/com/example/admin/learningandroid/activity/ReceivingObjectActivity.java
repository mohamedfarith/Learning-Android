package com.example.admin.learningandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.learningandroid.entity.PersonName;
import com.example.admin.learningandroid.R;

import static com.example.admin.learningandroid.Constants.KEY_NAME;


public class ReceivingObjectActivity extends AppCompatActivity {
    public TextView txtFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiving_object_layout);
        txtFullName = findViewById(R.id.txt_full_name);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        PersonName name = (PersonName) b.getParcelable(KEY_NAME);
        txtFullName.setText(name.getFname() + " " + name.getLname());


    }
}
