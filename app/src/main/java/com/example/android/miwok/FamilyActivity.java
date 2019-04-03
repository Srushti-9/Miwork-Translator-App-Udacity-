package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> family=new ArrayList<Word>();
        family.add(new Word("Daughter","Magalu",R.drawable.family_daughter,R.raw.s));
        family.add(new Word("Father","Tande",R.drawable.family_father,R.raw.s1));
        family.add(new Word("Mother","Tayi",R.drawable.family_mother,R.raw.s1));
        family.add(new Word("Younger Sister","Tangi",R.drawable.family_younger_sister,R.raw.s1));
        family.add(new Word("Older Brother","Anna",R.drawable.family_older_brother,R.raw.s1));
        family.add(new Word("Younger Brother","Tamma",R.drawable.family_younger_brother,R.raw.s1));
        family.add(new Word("Grandmother","Ajji",R.drawable.family_grandmother,R.raw.s1));
        family.add(new Word("GrandFather","Ajja",R.drawable.family_grandfather,R.raw.s1));


        WordAdapter adapter=new WordAdapter(this,family,R.color.category_family);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter((adapter));
    }
}
