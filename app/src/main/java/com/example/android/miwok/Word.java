package com.example.android.miwok;

public class Word {

    private String mdefaultTranslation;
    private String mMiworkTranslation;
    private int mimageResourceId=no_image_provided;//initializde with no image is there
    private int mAudioResourceId;

    //a variable for checking image or not
    private static final int no_image_provided=-1;

    public Word(String defaultTranslation,String miworkTranslation)
    {
        mdefaultTranslation =defaultTranslation;
        mMiworkTranslation =miworkTranslation;
    }

    public Word(String defaultTranslation,String miworkTranslation,int imageResourceId,int AudioResourceId)
    {
        mdefaultTranslation =defaultTranslation;
        mMiworkTranslation =miworkTranslation;
        mimageResourceId =imageResourceId;
        mAudioResourceId = AudioResourceId;
    }

    public Word(String defaultTranslation, String miworkTranslation, int AudioResourceId)
    {
        mdefaultTranslation =defaultTranslation;
        mMiworkTranslation =miworkTranslation;
        mAudioResourceId = AudioResourceId;
    }

    public String getMdefaultTranslation() {
        return mdefaultTranslation;
    }

    public String getmMiworkTranslation() {
        return mMiworkTranslation;
    }

    public int getMimageResourceId() {
        //this.mimageResourceId = imageResourceId;
        return mimageResourceId;
    }

    public boolean hasImage()
    {
        return mimageResourceId !=no_image_provided;
    }

    public int getAudioResourceId()
    {
        return mAudioResourceId;
    }
}
