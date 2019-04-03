package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> phrases=new ArrayList<Word>();
        phrases.add(new Word("Who are you?","Eer yer ullar?"));
        phrases.add(new Word("How are you?","Yencha ullar?"));
        phrases.add(new Word("three","muji"));
        phrases.add(new Word("four","naal"));
        phrases.add(new Word("five","aiyn"));
        phrases.add(new Word("six","aaji"));
        phrases.add(new Word("seven","yel"));
        phrases.add(new Word("eight","yedma"));


        WordAdapter adapter=new WordAdapter(this,phrases,R.color.category_phrases);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter((adapter));
    }


}
