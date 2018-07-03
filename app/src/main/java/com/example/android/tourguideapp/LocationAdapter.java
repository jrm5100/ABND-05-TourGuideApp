package com.example.android.tourguideapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {
    private int mColorResourceId;
    private int mDefaultPhotoId;

    /**
     * Create a new {@link LocationAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param locations is the list of {@link Location}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of locations
     * @param defaultPhotoId is the resource ID for the default "photo" for this list of locations
     *
     */
    public LocationAdapter(Context context, ArrayList<Location> locations, int colorResourceId, int defaultPhotoId) {
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
        mDefaultPhotoId = defaultPhotoId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Set the name in the name TextView in the list_item.xml layout
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentLocation.getNameId());

        // Set the description in the description TextView in the list_item.xml layout
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        descriptionTextView.setText(currentLocation.getDescriptionId());

        // Set the address in the description TextView in the list_item.xml layout
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        addressTextView.setText(currentLocation.getAddressId());

        // Get the photo in the ImageView
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.photo);
        if (currentLocation.hasPhoto()) {
            // Set the included photo
            imageView.setImageResource(currentLocation.getPhotoId());
        } else {
            // Set the default photo
            imageView.setImageResource(mDefaultPhotoId);
            int padding_in_px = getContext().getResources().getDimensionPixelSize(R.dimen.default_photo_padding);
            imageView.setPadding(padding_in_px, padding_in_px, padding_in_px, padding_in_px);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}