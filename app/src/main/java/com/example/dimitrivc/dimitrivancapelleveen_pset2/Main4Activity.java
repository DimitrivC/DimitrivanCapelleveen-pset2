package com.example.dimitrivc.dimitrivancapelleveen_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // get intent for Story
        Intent intent = getIntent();
        // get Story from intent
        String story = intent.getStringExtra("key_finished_story");

        // get TextView
        TextView eText = findViewById(R.id.textView3);
        // set Story in TextView
        eText.setText(story);

        // dit pas doen als ik het al een keer aangesloten heb gekregen en de rest werkt:
        // en een knop om terug te gaan.
        // standard back button
        // https://stackoverflow.com/questions/27129353/android-back-navigation
    }
}
