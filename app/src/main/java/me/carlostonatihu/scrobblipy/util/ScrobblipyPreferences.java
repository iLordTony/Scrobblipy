package me.carlostonatihu.scrobblipy.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 25/08/2015.
 */
public class ScrobblipyPreferences {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    public static final String PREF_KEY = "PREF_KEY";
    public static final String PREF_TRACK_LENGTH = "PREF_TRACK_LENGTH";
    public static final String PREF_TRACK_DATA = "PREF_TRACK_DATA";
    public static final String PREF_SCROBBLING_STATE = "PREF_SCROBBLING_STATE";

    public ScrobblipyPreferences(Context context) {
        prefs = context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setTrackLength(int trackLengthInSec) {
        editor.putInt(PREF_TRACK_LENGTH, trackLengthInSec);
        editor.apply();
    }

    public int getTrackLengh() {
        return prefs.getInt(PREF_TRACK_LENGTH, 0);
    }

    public void setScrobblingState(boolean scrobblingState) {
        editor.putBoolean(PREF_SCROBBLING_STATE, scrobblingState);
        editor.apply();
    }

    public boolean getScrobblingState() {
        return prefs.getBoolean(PREF_SCROBBLING_STATE, false);
    }

    public void setTrackData(String trackData) {
        editor.putString(PREF_TRACK_DATA, trackData);
        editor.apply();
    }

    public String getTrackData() {
        return prefs.getString(PREF_TRACK_DATA, "");
    }
}
