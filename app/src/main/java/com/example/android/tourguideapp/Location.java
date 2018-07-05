package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;

import java.util.Locale;

public class Location {

    /** Location name resource ID*/
    private int mNameId;

    /** latitude */
    private double mLatitude = 0;

    /** longitude */
    private double mLongitude = 0;

    /** website */
    private String mWebsite = "";

    /** phone number (with country and area code)*/
    private String mPhoneNum = "";

    /** Photo resource ID */
    private int mPhotoId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no provided value */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Location object (Name and Location).
     *
     * @param nameId is the string resource ID for the name of the location
     * @param latitude is the latitude of the location
     * @param longitude is the longitude of the location

     */
    public Location(int nameId, double latitude, double longitude) {
        mNameId = nameId;
        mLatitude = latitude;
        mLongitude = longitude;
    }

    /**
     * Create a new Location object (Name, Location, Photo).
     *
     * @param nameId is the string resource ID for the name of the location
     * @param latitude is the latitude of the location
     * @param longitude is the longitude of the location
     * @param photoId is the resource ID for the photo associated with the location
     */
    public Location(int nameId, double latitude, double longitude, int photoId) {
        mNameId = nameId;
        mLatitude = latitude;
        mLongitude = longitude;
        mPhotoId = photoId;
    }

    /**
     * Create a new Location object (No photo).
     *
     * @param nameId is the string resource ID for the name of the location
     * @param latitude is the latitude of the location
     * @param longitude is the longitude of the location
     * @param website is the website of the location
     * @param phoneNum is the phone number of the location
     */
    public Location(int nameId, double latitude, double longitude,
                    String website, String phoneNum) {
        mNameId = nameId;
        mLatitude = latitude;
        mLongitude = longitude;
        mWebsite = website;
        mPhoneNum = phoneNum;
    }

    /**
     * Create a new Location object (full).
     *
     * @param nameId is the string resource ID for the name of the location
     * @param latitude is the latitude of the location
     * @param longitude is the longitude of the location
     * @param website is the website of the location
     * @param phoneNum is the phone number of the location
     * @param photoId is the resource ID for the photo associated with the location
     */
    public Location(int nameId, double latitude, double longitude,
                    String website, String phoneNum, int photoId) {
        mNameId = nameId;
        mLatitude = latitude;
        mLongitude = longitude;
        mWebsite = website;
        mPhoneNum = phoneNum;
        mPhotoId = photoId;
    }

    /**
     * Get the string resource ID for the name of the location
     */
    public int getNameId() {
        return mNameId;
    }

    /**
     * Get the intent uri for the location
     */
    public Intent getMapIntent() {
        String mapUri = String.format(Locale.ENGLISH, "google.navigation:q=%f,%f", mLatitude, mLongitude);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse(mapUri));
        return mapIntent;
    }

    /**
     * Get the intent uri for the location
     */
    public Intent getWebIntent() {
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse(mWebsite));
        return webIntent;
    }

    /**
     * Get the intent uri for the phone number
     */
    public Intent getPhoneIntent() {
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:" + mPhoneNum));
        return phoneIntent;
    }

    /**
     * Get the string resource ID for the name of the location
     */
    public int getPhotoId() {
        return mPhotoId;
    }

    /**
     * Returns whether or not there is a photo
     */
    public boolean hasPhoto() {
        return mPhotoId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns whether or not there is a website
     */
    public boolean hasWebsite() {
        return !mWebsite.equals("");
    }

    /**
     * Returns whether or not there is a phone number
     */
    public boolean hasPhoneNum() {
        return !mPhoneNum.equals("");
    }


}
