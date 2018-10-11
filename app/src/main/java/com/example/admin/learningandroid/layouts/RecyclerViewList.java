package com.example.admin.learningandroid.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.learningandroid.R;

import static com.example.admin.learningandroid.Constants.LIST;

public class RecyclerViewList extends AppCompatActivity {


    public TextView txtRecyclerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_list_item_view);
        txtRecyclerListView = findViewById(R.id.txt_recycler_list_item_view);
        Intent intentRecycler = getIntent();
        String name = intentRecycler.getStringExtra(LIST);
        txtRecyclerListView.setText(name);
    }

}

