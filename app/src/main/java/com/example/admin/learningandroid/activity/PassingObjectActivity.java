package com.example.admin.learningandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.learningandroid.entity.PersonName;
import com.example.admin.learningandroid.R;

import static com.example.admin.learningandroid.Constants.KEY_NAME;

public class PassingObjectActivity extends AppCompatActivity {

    public EditText etFirstName;
    public EditText etLastName;
    public Button buttonDisplayName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passing_object_layout);
        etFirstName = findViewById(R.id.first_name);
        etLastName = findViewById(R.id.last_name);
        buttonDisplayName = findViewById(R.id.button_display);

        buttonDisplayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FirstName = etFirstName.getText().toString();
                String LastName = etLastName.getText().toString();

                PersonName name = new PersonName(FirstName, LastName);
                Intent intentPassingObject = new Intent(PassingObjectActivity.this, ReceivingObjectActivity.class);
                intentPassingObject.putExtra(KEY_NAME, name);
                startActivity(intentPassingObject);
            }
        });

    }
}
