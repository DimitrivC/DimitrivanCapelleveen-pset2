package com.example.dimitrivc.dimitrivancapelleveen_pset2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // intent wordt opgehaald om Story eruit te halen
        Intent intent = getIntent();
        // Story wordt eruit gehaald om de 1e placeholder voor de edittext te krijgen
        Story story = (Story) intent.getSerializableExtra("key_story");
        // de edittext wordt opgehaald zodat de volgende palceholder erin gezet kan worden
        EditText eText = findViewById(R.id.PlaceholderText);
        // en er dan in wordt gezet.
        eText.setText(story.getNextPlaceholder());
    }

    public void FillPlaceHolder(View view) {

        // intent opgehaald voor Story
        Intent intent = getIntent();
        // Story opgehaald om placeholder in te plaatsen
        Story story = (Story) intent.getSerializableExtra("key_story");
        // edittext via id opgehaald om placeholder van user uit te halen
        EditText eText = findViewById(R.id.PlaceholderText);
        // placeholder van user ophalen
        String placeholder = eText.getText().toString();
        // placeholder user in text plaatsen.
        story.fillInPlaceholder(placeholder);

        if (story.isFilledIn()) {
            // dan is het true, en dan zijn ze dus niet meer nodig,
            // kan naar de pagina met de complete story (waar ook een back moet zijn).
            Intent intent2 = new Intent(this, Main4Activity.class);
            String finished_story = (String) story.toString();
            intent2.putExtra("key_finished_story", finished_story);
            startActivity(intent2);

        } else {
            // er moet voor gezorgd worden dat de placeholder echt in de story komt, ook voor
            // nextplaceholder. Heel misschien gebeurd dit al,
            // -via toString?
            // -via Global variable?
            // -via nog een intent?

            NextPlaceholder();
        }
    }

        public void NextPlaceholder() {

            // intent wordt opgehaald voor Story
            Intent intent = getIntent();
            // Story wordt uit de intent gehaald: maar, deze heeft nog niet de placeholder in zich!!
            Story story = (Story) intent.getSerializableExtra("key_story");
            // de edittext wordt opgehaald
            EditText eText = findViewById(R.id.PlaceholderText);
            // de eerste nog bestaande placeholder van Story wordt in de edittext gezet
            // maar, dit is dus nog de foute.
            eText.setText(story.getNextPlaceholder());
        }

}
