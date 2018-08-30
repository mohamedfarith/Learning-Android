package com.example.admin.learningandroid.layouts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.learningandroid.MainActivity;
import com.example.admin.learningandroid.R;

public class ModelLoginPage extends AppCompatActivity {
    public EditText etName;
    public EditText etRegistrationNumber;
    public Button btnSignUp;
    public Button btnLogin;
    String mName;
    String mRegistrationNumber;
    public String name;
    public static final double LENGTH_S = 0.2;


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
                SharedPreferences firstRetrieve = getSharedPreferences("SAVE_DATA", MODE_PRIVATE);
                String savedName = firstRetrieve.getString("NAME", "");
                String savedRegNumber = firstRetrieve.getString("REGISTRATION_NUMBER", "");

                mName = etName.getText().toString().trim();
                mRegistrationNumber = etRegistrationNumber.getText().toString().trim();

                int mCount = mName.length();
                //condition for various credential check
                if (mCount <= 3) {
                    //Toast.makeText(ModelLoginPage.this, "Enter Valid Name",Toast.LENGTH_SHORT).show();
                    Context context = getApplicationContext();
                    CharSequence text = "Enter Valid Name";
                    int duration = 1000;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if (mRegistrationNumber.length() < 1) {
                        Toast.makeText(ModelLoginPage.this, "enter valid register number", Toast.LENGTH_SHORT).show();
                    } else {

                        if (savedName.equals("") && savedRegNumber.equals("")) {

                            //Loading data in shared preference
                            SharedPreferences saveData = getSharedPreferences("SAVE_DATA", MODE_PRIVATE);
                            SharedPreferences.Editor addData = saveData.edit();
                            addData.putString("NAME", mName);
                            addData.putString("REGISTRATION_NUMBER", mRegistrationNumber);
                            addData.apply();
                            Toast.makeText(ModelLoginPage.this, "Successfully saved", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ModelLoginPage.this, "Already signed up it seems", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                Toast.makeText(ModelLoginPage.this, "hai", Toast.LENGTH_SHORT).show();
            }


        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ModelLoginPage.this, "hai hello", Toast.LENGTH_SHORT).show();

                //Retrieving shared preference data
                SharedPreferences preference = getSharedPreferences("SAVE_DATA", MODE_PRIVATE);
                String name = preference.getString("NAME", "");
                String registrationNumber = preference.getString("REGISTRATION_NUMBER", "");

                //making sure that the user do not logs in with empty data
                if (name != "" && registrationNumber != "") {
                    if (name.equals(etName.getText().toString())) {
                        if (registrationNumber.equals(etRegistrationNumber.getText().toString())) {
                            Toast.makeText(ModelLoginPage.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(ModelLoginPage.this, "not LOGGED IN before,please LOGIN", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ModelLoginPage.this, "not SIGNED IN before,please SIGN UP", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}





