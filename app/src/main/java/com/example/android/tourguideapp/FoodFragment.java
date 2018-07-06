package com.example.android.tourguideapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {

    public FoodFragment(){
        // empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.food_name_aah,
                40.8310544, -77.8885427,
                "http://www.americanalehouse.net/", "(814) 237-9701",
                R.drawable.food_waffle_shop));
        locations.add(new Location(R.string.food_name_champs,
                40.8078421, -77.8965042,
                "http://www.champssportsgrill.net/", "(814) 234-7700",
                R.drawable.food_champs));
        locations.add(new Location(R.string.food_name_hiway,
                40.8078231, -77.8982898,
                "http://www.dantesinc.com/", "(814) 237-0375"));
        locations.add(new Location(R.string.food_name_waffleshop,
                40.8033282, -77.8836266,
                "http://www.originalwaffleshop.net/", "(814) 238-7460",
                R.drawable.food_waffle_shop));
        locations.add(new Location(R.string.food_name_arena,
                40.8053461, -77.893799,
                "http://www.thearenabarandgrill.com/", "(814) 237-8833"));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Locations}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_food, R.drawable.food);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}
