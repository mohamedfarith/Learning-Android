package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class ReceivingObjectActivity extends AppCompatActivity {
   TextView txtFirstNameReceived,txtLastNameReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiving_object_layout);
        txtFirstNameReceived = (TextView) findViewById(R.id.txtFirstNameReceived);
        txtLastNameReceived=(TextView) findViewById(R.id.txtLastNameReceived);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        PersonName n = (PersonName) b.getParcelable("Name");
        txtFirstNameReceived.setText("harish kumar");
        txtLastNameReceived.setText(n.getLname());

      //  String s = p.getF_name();
       //String s1 = p.getL_name();
     //  mFullName.setText( s1);
        //mFullName.setText(p.getF_name() + " " + p.getL_name());

    }
}
