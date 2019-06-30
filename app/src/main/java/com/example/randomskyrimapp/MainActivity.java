package com.example.randomskyrimapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_main);

        mEditTextName = findViewById(R.id.edit_text_name);
        mTextRace = findViewById(R.id.rasse);
        mTextGender = findViewById(R.id.geschlecht);
        mTextMainSkill = findViewById(R.id.main_skill);
        mTextSecSkill = findViewById(R.id.sec_skill);
        mTextMainWeap = findViewById(R.id.main_weapon);
        mTextSecWeap = findViewById(R.id.sec_w);


        Button buttonRace = findViewById(R.id.button_race);
        buttonRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please insert a Name", Toast.LENGTH_SHORT).show();
                } else {

                    String name = mEditTextName.getText().toString();

                    Intent intent = new Intent(MainActivity.this, RasseActivity.class);
                    intent.putExtra("name", name);
                    startActivityForResult(intent, 1);
                }
            }
        });


        Button buttonSkill = findViewById(R.id.button_skill);
        buttonSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please insert a Name", Toast.LENGTH_SHORT).show();
                } else {

                    String name = mEditTextName.getText().toString();

                    Intent intent = new Intent(MainActivity.this, SkillActivity.class);
                    intent.putExtra("name", name);
                    startActivityForResult(intent, 1);
                }
            }
        });


        Button buttonWeapon = findViewById(R.id.button_weapon);
        buttonWeapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please insert a Name", Toast.LENGTH_SHORT).show();
                } else {

                    String name = mEditTextName.getText().toString();

                    Intent intent = new Intent(MainActivity.this, WeaponActivity.class);
                    intent.putExtra("name", name);
                    startActivityForResult(intent, 1);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String race = data.getStringExtra("race");
                mTextRace.setText("" + race);
                String gender = data.getStringExtra("gender");
                mTextGender.setText("" + gender);

            }
            if (resultCode == RESULT_FIRST_USER) {
                String main_skill = data.getStringExtra("main_skill");
                mTextMainSkill.setText("" + main_skill);
                String sec_skill = data.getStringExtra("sec_skill");
                mTextSecSkill.setText("" + sec_skill);
            }
            if (resultCode == 2){
                String main_weapon = data.getStringExtra("main_weapon");
                mTextMainWeap.setText("" + main_weapon);
                String sec_weapon = data.getStringExtra("sec_weapon");
                mTextSecWeap.setText("" + sec_weapon);
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Roll Again", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
