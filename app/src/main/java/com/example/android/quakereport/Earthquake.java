package com.example.android.quakereport;

/**
 * Created by shaefferm on 10/15/2016.
 */


public class Earthquake {
    private Double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude
     * @param location
     * @param date
     */
    public Earthquake(Double magnitude, String location, Long date) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = date;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
