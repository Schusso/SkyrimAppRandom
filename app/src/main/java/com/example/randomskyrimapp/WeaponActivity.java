package com.example.randomskyrimapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class WeaponActivity extends AppCompatActivity {


        private TextView mTextMainWeap;
        private TextView mTextSecWeap;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_weapon);

            setTitle("Weapon");

            mTextMainWeap = findViewById(R.id.m_weapon);
            mTextSecWeap = findViewById(R.id.sec_w);

            Intent intent = getIntent();
            final String name = intent.getStringExtra("name");

            TextView titleName = findViewById(R.id.label_name);
            titleName.setText(name);

            Button buttonRoll = findViewById(R.id.roll_weapon);
            buttonRoll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Möglichkeiten
                    String[] main_weapon = {"Axe", "Sword", "Mace", "Bow", "Dagger"};
                    String[] sec_weapon = {"Axe", "Sword", "Mace", "Dagger", "Shield"};
                    //Zufalls Nummer
                    Random rand = new Random();
                    int n = rand.nextInt(main_weapon.length);
                    Random rand2 = new Random();
                    int r = rand2.nextInt(sec_weapon.length);
                    //Setzten der Labels mit Korrektem Text
                    TextView labelrace = findViewById(R.id.m_weapon);
                    labelrace.setText(main_weapon[n]);
                    TextView labelgender = findViewById(R.id.sec_w);
                    labelgender.setText(sec_weapon[r]);
                }
            });

            Button buttonBack = findViewById(R.id.back_skill);
            buttonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String main_weapon = mTextMainWeap.getText().toString();
                    String sec_weapon = mTextSecWeap.getText().toString();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("main_weapon", main_weapon);
                    resultIntent.putExtra("sec_weapon", sec_weapon);

                    setResult(2, resultIntent);
                    finish();
                }
            });
    }
}
