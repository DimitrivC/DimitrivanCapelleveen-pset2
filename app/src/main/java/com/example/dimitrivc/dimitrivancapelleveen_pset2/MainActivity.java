package com.example.dimitrivc.dimitrivancapelleveen_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    for the start page, with the image and the start button, to go to
    main2activity.
    */

    public void goToSelect(View view) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        //finish();

        // nog toevoegen, maar doe dat pas als alles verder werkt:
        // textview met info over waar de app voor is.
    }
}
