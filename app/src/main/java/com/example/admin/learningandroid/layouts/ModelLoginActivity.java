package com.example.admin.learningandroid.layouts;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.learningandroid.R;

import static com.example.admin.learningandroid.Constants.NAME;
import static com.example.admin.learningandroid.Constants.REGISTRATION_NUMBER;
import static com.example.admin.learningandroid.Constants.SAVE_DATA;

public class ModelLoginActivity extends AppCompatActivity {
    public EditText etName;
    public EditText etRegistrationNumber;
    public Button btnSignUp;
    public Button btnLogin;
    String mName;
    String mRegistrationNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_login_page);
        etName = findViewById(R.id.et_name);
        etRegistrationNumber = findViewById(R.id.et_registration);
        btnSignUp = findViewById(R.id.btn_sign_up);
        btnLogin = findViewById(R.id.btn_login);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To make only one time sign up
                SharedPreferences userPreference = getSharedPreferences(SAVE_DATA, MODE_PRIVATE);
                String savedName = userPreference.getString(NAME, "");
                String savedRegNumber = userPreference.getString(REGISTRATION_NUMBER, "");
                mName = etName.getText().toString().trim();
                mRegistrationNumber = etRegistrationNumber.getText().toString().trim();

                //Valid Credential Check
                int s = checkForCredentials(mName, mRegistrationNumber);
                String mMessage = null;
                switch (s) {
                    case 1:
                        mMessage = "Enter Valid name";
                        break;
                    case 2:
                        mMessage = "Enter Valid Register Number";
                        break;
                    case 3:
                        // mMessage = "You have entered Valid Credentials";
                        if (savedName.isEmpty() && savedRegNumber.isEmpty()) {

                            //Loading data in shared preference
                            SharedPreferences saveData = getSharedPreferences(SAVE_DATA, MODE_PRIVATE);
                            SharedPreferences.Editor addData = saveData.edit();
                            addData.putString(NAME, mName);
                            addData.putString(REGISTRATION_NUMBER, mRegistrationNumber);
                            addData.apply();
                            mMessage = "successfully saved";
                        } else {
                            mMessage = "Already signed up it seems";
                        }

                }
                Toast.makeText(ModelLoginActivity.this, mMessage, Toast.LENGTH_SHORT).show();

            }


        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Retrieving shared preference data
                SharedPreferences preference = getSharedPreferences(SAVE_DATA, MODE_PRIVATE);
                String name = preference.getString(NAME, "");
                String registrationNumber = preference.getString(REGISTRATION_NUMBER, "");


                //making sure that the user do not logs in with empty data
                if (name.isEmpty() && registrationNumber.isEmpty()) {
                    Toast.makeText(ModelLoginActivity.this, "not SIGNED IN before,please SIGN UP", Toast.LENGTH_SHORT).show();
                } else if (name.equals(etName.getText().toString().trim()) && registrationNumber.equals(etRegistrationNumber.getText().toString().trim())) {
                    Toast.makeText(ModelLoginActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ModelLoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public int checkForCredentials(String mName, String mRegistrationNumber) {
        if (mName.length() <= 3) {
            return 1;
        } else if (mRegistrationNumber.length() < 1) {
            return 2;
        } else {
            return 3;
        }
    }


}





