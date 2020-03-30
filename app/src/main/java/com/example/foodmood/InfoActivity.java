package com.example.foodmood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // if phone layout, use bundle to send restaurant name to info fragment and begin transaction

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(InfoFragment.name, getIntent().getStringExtra(InfoFragment.name));
            InfoFragment fragment = new InfoFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.info, fragment)
                    .commit();
        }
    }
}
