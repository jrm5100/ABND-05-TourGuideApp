package com.example.android.tourguideapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class SightsFragment extends Fragment {

    public SightsFragment(){
        // empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.sights_name_lionshrine, 40.796712, -77.8711102, R.drawable.sights_lion_shrine));
        locations.add(new Location(R.string.sights_name_beaverstadium, 40.8121958, -77.858291, R.drawable.beaver_stadium));
        locations.add(new Location(R.string.sights_name_oldmain, 40.7964727, -77.865005, R.drawable.old_main));
        locations.add(new Location(R.string.sights_name_creamery, 40.8037251, -77.8645545,
                "http://www.creamery.psu.edu", "(814) 865-7535", R.drawable.creamery));
        locations.add(new Location(R.string.sights_name_obelisk, 40.7955591, -77.8654855, R.drawable.obelisk));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_sights, R.drawable.binoculars);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}
