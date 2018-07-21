package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PassingObjectActivity extends AppCompatActivity {
    public static final String KEY_NAME = "Name";
    EditText etFirstName;
    EditText etLastName;
    Button buttonDisplayName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passing_object_layout);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        buttonDisplayName = findViewById(R.id.buttonDisplay);

        buttonDisplayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mFirstName = etFirstName.getText().toString();
                String mLastName = etLastName.getText().toString();

                PersonName name = new PersonName(mFirstName, mLastName);
                Intent intent = new Intent(PassingObjectActivity.this, ReceivingObjectActivity.class);
                intent.putExtra(KEY_NAME, name);
                startActivity(intent);
            }
        });

    }
}
