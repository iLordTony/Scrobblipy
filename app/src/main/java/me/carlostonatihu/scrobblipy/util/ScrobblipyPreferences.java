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
    public static final String PREF_TRACK_NAME = "PREF_TRACK_NAME";
    public static final String PREF_TRACK_ARTIST = "PREF_TRACK_ARTIST";
    public static final String PREF_TRACK_ALBUM = "PREF_TRACK_ALBUM";

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

    public String getTrackName() {
        return prefs.getString(PREF_TRACK_NAME, "");
    }

    public String getTrackArtist() {
        return prefs.getString(PREF_TRACK_ARTIST, "");
    }

    public String getTrackAlbum() {
        return prefs.getString(PREF_TRACK_ALBUM, "");
    }

    public void setTrackName(String trackName) {
        editor.putString(PREF_TRACK_NAME, trackName);
        editor.apply();
    }

    public void setTrackArtist(String trackArtist) {
        editor.putString(PREF_TRACK_ARTIST, trackArtist);
        editor.apply();
    }

    public void setTrackAlbum(String trackAlbum) {
        editor.putString(PREF_TRACK_ALBUM, trackAlbum);
        editor.apply();
    }

}
