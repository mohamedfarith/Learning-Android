package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class Activity_of_Passing_Object extends AppCompatActivity {
    EditText first_name, last_name;
    Button display_name;
    String f_name, l_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_of_activity_passing_object);
        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        display_name = (Button) findViewById(R.id.display_name);

        display_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f_name = first_name.getText().toString();
                l_name = last_name.getText().toString();
                Name_of_Person name = new Name_of_Person(f_name, l_name);
                Intent intent = new Intent(Activity_of_Passing_Object.this, Activity_of_Receiving_Object.class);
                intent.putExtra("Name", name);
                startActivity(intent);
            }
        });

    }
}
