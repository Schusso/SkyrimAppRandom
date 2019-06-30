package com.example.randomskyrimapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RasseActivity extends AppCompatActivity {

    private TextView mTextRace;
    private TextView mTextGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasse);

        setTitle("Race");

        mTextRace = findViewById(R.id.rasse);
        mTextGender = findViewById(R.id.geschlecht);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");

        TextView titleName = findViewById(R.id.label_name);
        titleName.setText(name);

        Button buttonRoll = findViewById(R.id.roll);
        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Möglichkeiten
                String[] race = {"Orc", "Dunkelelf", "Hochelf", "Waldelf", "Bretone"};
                String[] gender = {"Frau", "Mann"};
                //Zufalls Nummer
                Random rand = new Random();
                int n = rand.nextInt(race.length);
                Random rand2 = new Random();
                int r = rand2.nextInt(gender.length);
                //Setzten der Labels mit Korrektem Text
                TextView labelrace = findViewById(R.id.rasse);
                labelrace.setText(race[n]);
                TextView labelgender = findViewById(R.id.geschlecht);
                labelgender.setText(gender[r]);
            }
        });

        Button buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String race = mTextRace.getText().toString();
                String gender = mTextGender.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("race", race);
                resultIntent.putExtra("gender", gender);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}