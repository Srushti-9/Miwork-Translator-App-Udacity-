package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {


    //Resource ID for the background color for this list of words
    private int mcolorResourceId;

    public WordAdapter(@NonNull Activity context, ArrayList<Word> words,int colorResourceId) {
        super(context,0,words);
        mcolorResourceId=colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.app_text_view);

        // Get the app_text_view from the current Word object and
        // set this text on the name TextView

        nameTextView.setText(currentWord.getmMiworkTranslation());


        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default_text_view from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getMdefaultTranslation());


        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Word object and
        // set the image to iconView
        if(currentWord.hasImage()) {
            iconView.setImageResource( currentWord.getMimageResourceId() );
            iconView.setVisibility(View.VISIBLE );
        }
        else {
            iconView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer=listItemView.findViewById(R.id.miwork_text_view);
        int color = ContextCompat.getColor( getContext(),mcolorResourceId);
        textContainer.setBackgroundColor( color);
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
