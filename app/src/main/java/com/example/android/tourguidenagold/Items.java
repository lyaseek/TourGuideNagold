package com.example.android.tourguidenagold;

public class Items {
    private String mTitle;
    private String mDescription;
    private int mImage;

    public Items(String mTitle, String mDescription, int mImage) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImage = mImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImage() {
        return mImage;
    }
}
