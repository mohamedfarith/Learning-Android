package com.example.admin.learningandroid.layouts;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.learningandroid.R;

import static com.example.admin.learningandroid.Constants.NAME;
import static com.example.admin.learningandroid.Constants.REGISTRATION_NUMBER;
import static com.example.admin.learningandroid.Constants.SAVE_DATA;

public class ModelLoginActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText etName;
    public EditText etRegistrationNumber;
    public Button btnSignUp;
    public Button btnLogin;
    String mName;
    String mRegistrationNumber;
    SharedPreferences userPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_login_page);
        etName = findViewById(R.id.et_name);
        etRegistrationNumber = findViewById(R.id.et_registration);

        btnSignUp = findViewById(R.id.btn_sign_up);
        btnLogin = findViewById(R.id.btn_login);
        btnSignUp.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //variables that is used to store the userPreference data
        String userName;
        String userRegistrationNumber;
        switch (view.getId()) {
            case R.id.btn_sign_up:

                userPreference = getSharedPreferences(SAVE_DATA, MODE_PRIVATE);
                userName = userPreference.getString(NAME, "");
                userRegistrationNumber = userPreference.getString(REGISTRATION_NUMBER, "");
                mName = etName.getText().toString().trim();
                mRegistrationNumber = etRegistrationNumber.getText().toString();
                String message = "";
                if (mName.length() <= 3) {
                    message = "Enter Valid name";
                } else if (TextUtils.isEmpty(mRegistrationNumber)) {
                    message = "enter valid register number";
                } else if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(userRegistrationNumber)) {
                    userPreference = getSharedPreferences(SAVE_DATA, MODE_PRIVATE);
                    SharedPreferences.Editor addData = userPreference.edit();
                    addData.putString(NAME, mName);
                    addData.putString(REGISTRATION_NUMBER, mRegistrationNumber);
                    addData.apply();
                    message = "Successfully saved";
                } else {
                    message = "Already signed up it seems";
                }
                Toast.makeText(ModelLoginActivity.this, message, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_login:
                userPreference = getSharedPreferences(SAVE_DATA, MODE_PRIVATE);
                userName = userPreference.getString(NAME, "");
                userRegistrationNumber = userPreference.getString(REGISTRATION_NUMBER, "");
                //making sure that the user do not logs in with empty data

                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userRegistrationNumber)) {
                    if (userName.equals(etName.getText().toString().trim()) && (userRegistrationNumber.equals(etRegistrationNumber.getText().toString()))) {
                        message = "Successfully logged in";
                    } else {
                        message = "invalid login";
                    }
                } else {
                    message = "not signed in before please sign in";
                }
                Toast.makeText(ModelLoginActivity.this, message, Toast.LENGTH_SHORT).show();
        }


    }
}


