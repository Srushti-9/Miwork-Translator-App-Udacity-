package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


        ArrayList<Word> colors=new ArrayList<Word>();
        colors.add(new Word("Black","Kapp",R.drawable.color_black,R.raw.s));
        colors.add(new Word("Brown","Kandu",R.drawable.color_brown,R.raw.s));
        colors.add(new Word("Dusty Yellow","Manjol",R.drawable.color_dusty_yellow,R.raw.s));
        colors.add(new Word("Grey","Budu",R.drawable.color_gray,R.raw.s1));
        colors.add(new Word("Green","Pachhe/Hasiru",R.drawable.color_green,R.raw.s1));
        colors.add(new Word("Mustard Yellow","Haladi",R.drawable.color_mustard_yellow,R.raw.s1));
        colors.add(new Word("Red","Kempu",R.drawable.color_red,R.raw.s1));
        colors.add(new Word("White","Bili",R.drawable.color_white,R.raw.s1));


        WordAdapter adapter=new WordAdapter(this,colors,R.color.category_colors);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter((adapter));
    }
}
