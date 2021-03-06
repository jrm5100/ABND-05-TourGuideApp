package com.example.android.tourguideapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class WineFragment extends Fragment {

    public WineFragment(){
        // empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.wine_name_hv,
                40.7682327, -77.9714247,
                "http://thehappyvalleywinery.com/", "(814) 308-8756",
                R.drawable.wine_happy_valley));
        locations.add(new Location(R.string.wine_name_seven_mountains,
                40.7758518, -77.8629853,
                "http://www.sevenmountainswinecellars.com/", "(814) 808-6635",
                R.drawable.wine_seven_mountains));
        locations.add(new Location(R.string.wine_name_mn,
                40.7914771, -77.955252,
                "http://www.mtnittanywinery.com/", "(814) 466-6373",
                R.drawable.wine_mount_nittany));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_wine, R.drawable.wine);

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
