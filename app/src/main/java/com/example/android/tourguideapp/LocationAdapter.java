package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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
        final Location currentLocation = getItem(position);

        // Set the name in the name TextView in the list_item.xml layout
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentLocation.getNameId());

        // Set web button
        ImageButton webButton = (ImageButton) listItemView.findViewById(R.id.web_button);
        if (currentLocation.hasWebsite()) {
            webButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getContext().startActivity(currentLocation.getWebIntent());
                }
            });
        } else {
            webButton.setClickable(false);
            webButton.setEnabled(false);
            webButton.setVisibility(View.INVISIBLE);
        }

        // Set phone button
        ImageButton phoneButton = (ImageButton) listItemView.findViewById(R.id.phone_button);
        if (currentLocation.hasPhoneNum()) {
            phoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getContext().startActivity(currentLocation.getPhoneIntent());
                }
            });
        } else {
            phoneButton.setClickable(false);
            phoneButton.setEnabled(false);
            phoneButton.setVisibility(View.INVISIBLE);
        }

        // Set map button
        ImageButton mapButton = (ImageButton) listItemView.findViewById(R.id.map_button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(currentLocation.getMapIntent());
                }
            });

        // Get the photo in the ImageView
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.photo);
        if (currentLocation.hasPhoto()) {
            // Set the included photo
            imageView.setImageResource(currentLocation.getPhotoId());
        } else {
            // Set the default photo
            imageView.setImageResource(mDefaultPhotoId);
        }

        // Set the theme color
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        View textContainer = listItemView.findViewById(R.id.parent_layout);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}