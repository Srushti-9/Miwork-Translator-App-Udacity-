package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                //Pause playback
                mMediaPlayer.pause();
                mMediaPlayer.seekTo( 0 );//resuming from start of sound
            }
            else if(focusChange ==AudioManager.AUDIOFOCUS_GAIN)
            {
                //Resume playback
                mMediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS)
            {
                //Stop and this is bcuz AudioFocus_loss case means audio focus is lost.
                //So stop and release the resources
                releaseMediaPlayer();
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_numbers );

        //An array list of numbers
        // ArrayList<String> words=new ArrayList<String>();
        /*words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");
        words.add("eleven");
        words.add("twelve");
        words.add("thirteen");*/


        //Initializing audio manager to request audio focus
        mAudioManager = (AudioManager) getSystemService( Context.AUDIO_SERVICE );

        //Using a custom Array Adapter-replace String datatype to word
        final ArrayList<Word> words = new ArrayList<Word>();
       /* Word w=new Word("one","vanji");
        words.add(w);*/
        words.add( new Word( "one", "vanji", R.drawable.number_one, R.raw.s ) );
        words.add( new Word( "two", "rudd", R.drawable.number_two, R.raw.s1 ) );
        words.add( new Word( "three", "muji", R.drawable.number_three, R.raw.s ) );
        words.add( new Word( "four", "naal", R.drawable.number_four, R.raw.s ) );
        words.add( new Word( "five", "aiyn", R.drawable.number_five, R.raw.s1 ) );
        words.add( new Word( "six", "aaji", R.drawable.number_six, R.raw.s1 ) );
        words.add( new Word( "seven", "yel", R.drawable.number_seven, R.raw.s1 ) );
        words.add( new Word( "eight", "yedma", R.drawable.number_eight, R.raw.s ) );
        words.add( new Word( "nine", "varma", R.drawable.number_nine, R.raw.s ) );
        words.add( new Word( "ten", "patt", R.drawable.number_ten, R.raw.s1 ) );
        words.add( new Word( "eleven", "pattonji", R.drawable.number_ten, R.raw.s1 ) );
        words.add( new Word( "twelve", "padraad", R.drawable.number_ten, R.raw.s1 ) );
        words.add( new Word( "thirteen", "patmuji", R.drawable.number_ten, R.raw.s1 ) );
        words.add( new Word( "fourteen", "patnaal", R.drawable.number_ten, R.raw.s ) );
        words.add( new Word( "fifteen", "padhnain", R.drawable.number_ten, R.raw.s1 ) );


        //Loop creating a TextView and adding it to the layout for each word in the list.
         /* LinearLayout rootView= (LinearLayout)findViewById(R.id.rootView);

        int index=0;
        while(index<words.size())
        {
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
            index++;
        }*/

        //Using Array Adapter
        // (Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android frmAudioManagerework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.)
        //ArrayAdapter<String> itemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);

        //Using the xml file  of our own
        //ArrayAdapter<String> itemsAdapter=new ArrayAdapter<String>(this,R.layout.list_item,words);

        //Updating tha generic datatype of array adapter
        //ArrayAdapter<Word> itemsAdapter=new ArrayAdapter<Word>(this,R.layout.list_item,words);

        //Using the custom WordAdapter
        //WordAdapter adapter=new WordAdapter(this,words);

        //modifying the word adapter arguments
        WordAdapter adapter = new WordAdapter( this, words, R.color.category_numbers );

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById( R.id.list );

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable nmAudioManagere itemsAdapter.
        listView.setAdapter( (adapter) );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(NumbersActivity.this,"List Item clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get( i );//gettting the position of the word which is clicked
                // mMediaPlayer = MediaPlayer.create( this,R.raw.s );

                //Release the media player if it currently exists because now want to play a different
                //sound file
                releaseMediaPlayer();

                //Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //mAudioManager.registerMediaButtonEventReceiver( Intent.Action_Media_Button);


                    mMediaPlayer = MediaPlayer.create( NumbersActivity.this, word.getAudioResourceId() );
                    mMediaPlayer.start();

                    //Setup a listener on the media player so that we can stop and release the media palyer
                    //pnce the sounds has finished playing
                    mMediaPlayer.setOnCompletionListener( mCompletionListener );
                }
            }
        } );

    }
        @Override
        protected void onStop() {
            super.onStop();
            releaseMediaPlayer();
        }

        /**
         * To clean up the media player by releasing its resources.
         */
        private void releaseMediaPlayer()
        {
            // If the media player is not null, then it may be currently playing a sound.
            if (mMediaPlayer != null)
            {
                // Regardless of the current state of the media player, release its resources because we no longer need it.
                mMediaPlayer.release();

                // Set the media player back to null. For our code, we've decided that
                // setting the media player to null is an easy way to tell that the media player
                // is not configured to play an audio file at the moment.
                mMediaPlayer = null;

                //Abandon Audio focus when playback is complete
                mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
            }
        }
    }



