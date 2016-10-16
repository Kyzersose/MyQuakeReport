package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shaefferm on 10/15/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the earthquake obj for the current position
        Earthquake currentQuake = getItem(position);

        //check if the view's being reused
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Find the views for the list item
        TextView magnitudeTextView = (TextView) convertView.findViewById(R.id.magnitude_view);
        TextView locationTextView = (TextView) convertView.findViewById(R.id.location_view);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.date_view);

        //Input the list data into the views
        magnitudeTextView.setText(currentQuake.getmMagnitude());
        locationTextView.setText(currentQuake.getmLocation());
        dateTextView.setText(currentQuake.getmDate());

        return convertView;
    }
}
