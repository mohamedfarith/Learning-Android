package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecyclerViewList extends AppCompatActivity {

    TextView txtRecyclerListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_list_item_view);
        txtRecyclerListView = findViewById(R.id.txtRecyclerListView);
        Intent intent = getIntent();
            String name=  intent.getStringExtra("hello");
              txtRecyclerListView.setText(name);
        }

    }

