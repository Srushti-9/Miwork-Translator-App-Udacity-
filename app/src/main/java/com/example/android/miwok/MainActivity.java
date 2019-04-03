package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView numbers=(TextView)findViewById(R.id.numbers);
        numbers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent numbersIntent = new Intent(MainActivity.this,NumbersActivity.class);
                    startActivity(numbersIntent);
            }
        });

        TextView phrases=(TextView)findViewById(R.id.phrases);
        phrases.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });

        TextView colors = (TextView)findViewById(R.id.colors);
        colors.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });

        TextView family = (TextView)findViewById(R.id.family);
        family.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(familyIntent);
            }
        });
    }

    /*public void openNumbersList(View view)
    {
        Intent number=new Intent(this,NumbersActivity.class);
        startActivity(number);
    }
    public void openPhrasesList(View v)
    {
        Intent phrase=new Intent(this,PhrasesActivity.class);
        startActivity(phrase);
    }
    public void openFamilyList(View v)
    {
        Intent family=new Intent(this,FamilyActivity.class);
        startActivity(family);
    }
    public void openColorsList(View v)
    {
        Intent color=new Intent(this,ColorsActivity.class);
        startActivity(color);
    }*/
}
