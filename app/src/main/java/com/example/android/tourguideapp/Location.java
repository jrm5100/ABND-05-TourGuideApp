package com.example.android.tourguideapp;

public class Location {

    /** Location name resource ID*/
    private int mNameId = R.string.placeholder_name;

    /** Location Description resource ID*/
    private int mDescriptionId = R.string.placeholder_description;

    /** address */
    private int mAddress = R.string.placeholder_address;

    /** Photo resource ID */
    private int mPhotoId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no photo */
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a blank/default location object
     */
    public Location() {}


    /**
     * Create a new Location object (full).
     *
     * @param nameId is the string resource ID for the name of the location
     * @param descriptionId is the string resource Id for the location's description
     * @param addressId is the string resource ID for the location's address
     * @param photoId is the resource ID for the photo associated with the location
     */
    public Location(int nameId, int descriptionId, int addressId, int photoId) {
        mNameId = nameId;
        mDescriptionId = descriptionId;
        mAddress = addressId;
        mPhotoId = photoId;
    }

    /**
     * Create a new Location object (No photo).
     *
     * @param nameId is the string resource ID for the name of the location
     * @param descriptionId is the string resource Id for the location's description
     * @param addressId is the string resource ID for the location's address
     */
    public Location(int nameId, int descriptionId, int addressId) {
        mNameId = nameId;
        mDescriptionId = descriptionId;
        mAddress = addressId;
    }

    /**
     * Get the string resource ID for the name of the location
     */
    public int getNameId() {
        return mNameId;
    }

    /**
     * Get the string resource ID for the name of the location
     */
    public int getDescriptionId() {
        return mDescriptionId;
    }

    /**
     * Get the string resource ID for the name of the location
     */
    public int getAddressId() {
        return mAddress;
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


}
