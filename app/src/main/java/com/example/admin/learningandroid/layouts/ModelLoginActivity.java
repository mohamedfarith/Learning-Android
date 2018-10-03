package com.example.admin.learningandroid.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.learningandroid.R;

public class ModelLoginActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText etName;
    public EditText etMarks;
    public EditText etRegistrationNumber;
    public Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_login_page);
        etName = findViewById(R.id.et_name);
        etRegistrationNumber = findViewById(R.id.et_registration);
        etMarks = findViewById(R.id.et_marks);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String mName = etName.getText().toString();
        String mMarks = etMarks.getText().toString();
        String mRegistrationNumber = etRegistrationNumber.getText().toString();
        int mCount = mName.length();
        if (mCount <= 3) {
            Toast.makeText(this, "Enter Valid Name", Toast.LENGTH_SHORT).show();
        } else {
            if (mRegistrationNumber.length() < 1) {
                Toast.makeText(this, "enter valid register number", Toast.LENGTH_SHORT).show();
            } else if (mMarks.length() < 1) {
                Toast.makeText(this, "enter valid marks", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
