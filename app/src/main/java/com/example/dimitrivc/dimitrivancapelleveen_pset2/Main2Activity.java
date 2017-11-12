package com.example.dimitrivc.dimitrivancapelleveen_pset2;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    // methods for if specific story is selected
    // - make instance of Story class with specific text (so that methods within can be used)
        // public Story(InputStream stream) { read(stream);}
    // - check how many place holders are needed.
        // public int getPlaceholderCount() { return placeholders.size();}
    // - go via intent to placeholder page, new activity

    // één method, kan je dan de id krijgen of zo, en
    // zo bepalen wat de story is?


    public void selectSimple() {

        // V1:
        //InputStream story = new ByteArrayInputStream(madlib1_tarzan.txt.getBytes(StandardCharsets.UTF_8.name()));

        // V2:
        // het selecteerde verhaal wordt opgehaald  als InputStream
        //InputStream story = this.getResources().getAssets().open("madlib0_simple.txt");

        // moet ik wel getresocu doen, want assets staat daar niet binnen.
        // en waarom context en niet R?
        // deze error checken via uitvoeren!

        // V3:
        Context context = this;
        AssetManager am = context.getAssets();
        InputStream story;
        try {
            story = am.open("madlib0_simple");

            // er wordt via de input stream een instantie van de Story gemaakt
            Story Simple = new Story(story);
            // er wordt gechecked hoeveel placeholders de story precies heeft.
            Integer PlaceHolderCount = Simple.getPlaceholderCount();

            // om naar de volgende activity te gaan, Main3Activity, om de placeholders in te vullen
            // nadat hier een story gekozen is
            Intent intent = new Intent(this, Main3Activity.class);

            // er wordt onthouden welk story gekozen is
            intent.putExtra("key_story", Simple);
            // en hoeveel placeholders deze heeft.
            intent.putExtra("key_placeholdercount", PlaceHolderCount);

            // naar volgende activity.
            startActivity(intent);
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectTarzan() {
        //InputStream story = new ByteArrayInputStream(madlib1_tarzan.txt.getBytes(StandardCharsets.UTF_8.name()));

        // moet ik wel getresocu doen, want assets staat daar niet binnen.
        //InputStream story = Context.getResources().getAssets().open("madlib1_tarzan.txt");

        Context context = this;
        AssetManager am = context.getAssets();
        InputStream story;
        try {
            story = am.open("madlib1_tarzan");

            Story Tarzan = new Story(story);
            Integer PlaceHolderCount = Tarzan.getPlaceholderCount();

            Intent intent = new Intent(this, Main3Activity.class);

            intent.putExtra("key_story", Tarzan);
            intent.putExtra("key_placeholdercount", PlaceHolderCount);

            startActivity(intent);
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectUniversity() {
        //InputStream story = Context.getResources().getAssets().open("madlib1_tarzan.txt");
        Context context = this;
        AssetManager am = context.getAssets();
        InputStream story;
        try {
            story = am.open("madlib2_university");
            Story Tarzan = new Story(story);
            Integer PlaceHolderCount = Tarzan.getPlaceholderCount();

            Intent intent = new Intent(this, Main3Activity.class);

            intent.putExtra("key_story", Tarzan);
            intent.putExtra("key_placeholdercount", PlaceHolderCount);

            startActivity(intent);
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectClothes() {
        //InputStream story = Context.getResources().getAssets().open("madlib1_tarzan.txt");
        Context context = this;
        AssetManager am = context.getAssets();
        InputStream story;
        try {
            story = am.open("madlib3_clothes");
            Story Tarzan = new Story(story);
            Integer PlaceHolderCount = Tarzan.getPlaceholderCount();

            Intent intent = new Intent(this, Main3Activity.class);

            intent.putExtra("key_story", Tarzan);
            intent.putExtra("key_placeholdercount", PlaceHolderCount);

            startActivity(intent);
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectDance() {
        //InputStream story = Context.getResources().getAssets().open("madlib1_tarzan.txt");
        Context context = this;
        AssetManager am = context.getAssets();
        InputStream story;
        try {
            story = am.open("madlib4_dance");
            Story Dance = new Story(story);
            Integer PlaceHolderCount = Dance.getPlaceholderCount();

            Intent intent = new Intent(this, Main3Activity.class);

            intent.putExtra("key_story", Dance);
            intent.putExtra("key_placeholdercount", PlaceHolderCount);

            startActivity(intent);
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectRandomStory() {
        // select random story from storys
        // error: bij de (), maar checke na uitvoeren.

        Random rand = new Random();
        int n = rand.nextInt(5);

        if (n == 0) {
            selectSimple();
        }
        else if (n == 1) {
            selectTarzan();
        }
        else if (n == 2) {
            selectUniversity();
        }
        else if (n == 3) {
            selectClothes();
        }
        else if (n == 4) {
            selectDance();
        }
    }
}
