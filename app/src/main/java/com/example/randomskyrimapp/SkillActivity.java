package com.example.randomskyrimapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SkillActivity extends AppCompatActivity {

    private EditText mEditTextName;
    private TextView mTextRace;
    private TextView mTextGender;
    private TextView mTextMainSkill;
    private TextView mTextSecSkill;
    private TextView mTextMainWeap;
    private TextView mTextSecWeap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        setTitle("Skill");

        mTextMainSkill = findViewById(R.id.main_skill);
        mTextSecSkill = findViewById(R.id.sec_skill);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");

        TextView titleName = findViewById(R.id.label_name);
        titleName.setText(name);

        Button buttonRoll = findViewById(R.id.roll_skill);
        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Möglichkeiten
                String[] skills = {"Illusion", "Conjuration", "Destruction", "Restoration", "Alteration"};
                //Zufalls Nummer
                Random rand = new Random();
                int n = rand.nextInt(skills.length);
                Random rand2 = new Random();
                int r = rand2.nextInt(skills.length);
                //Setzten der Labels mit Korrektem Text
                TextView labelrace = findViewById(R.id.main_skill);
                labelrace.setText(skills[n]);
                TextView labelgender = findViewById(R.id.sec_skill);
                labelgender.setText(skills[r]);
            }
        });

        Button buttonBack = findViewById(R.id.back_skill);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String main_skill = mTextMainSkill.getText().toString();
                String sec_skill = mTextSecSkill.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("main_skill", main_skill);
                resultIntent.putExtra("sec_skill", sec_skill);

                setResult(RESULT_FIRST_USER, resultIntent);
                finish();
            }
        });
    }
}
