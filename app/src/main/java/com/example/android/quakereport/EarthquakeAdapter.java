package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by shaefferm on 10/15/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        //Get the earthquake obj for the current position
        Earthquake currentQuake = getItem(position);

        //check if the view's being reused
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Find the views for the list item
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        //Create a new Date object from the time in milliseconds
        Date dateObject = new Date(currentQuake.getTimeInMilliseconds());
        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);

        //Create the locationOffset string by splitting the location string.
        String rawLocation = currentQuake.getmLocation();
        String locationOffset;
        String primaryLocation;
        if (rawLocation.contains("of")){
            String[] parts = rawLocation.split("of");
            locationOffset = parts[0] + "of";
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = rawLocation;
        }

        //Input the list data into the views
        magnitudeTextView.setText(currentQuake.getmMagnitude());
        locationTextView.setText(primaryLocation);
        locationOffsetTextView.setText(locationOffset);
        dateTextView.setText(formattedDate);
        timeView.setText(formattedTime);
        

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
