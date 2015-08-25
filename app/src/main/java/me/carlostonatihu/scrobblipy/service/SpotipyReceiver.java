package me.carlostonatihu.scrobblipy.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import me.carlostonatihu.scrobblipy.ui.MainActivity;
import me.carlostonatihu.scrobblipy.util.ScrobblipyApplication;
import me.carlostonatihu.scrobblipy.util.ScrobblipyPreferences;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 25/08/2015.
 */
public class SpotipyReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = SpotipyReceiver.class.getSimpleName();
    public static final String SPOTIFY_PACKAGE = "com.spotify.music";
    // Send data when stop or play
    public static final String PLAYBACK_STATE_CHANGED = SPOTIFY_PACKAGE + ".playbackstatechanged";
    // it send when the play queue is changed
    public static final String QUEUE_CHANGED = SPOTIFY_PACKAGE + ".queuechanged";
    // Send data when a new song starts playing
    public static final String METADATA_CHANGED = SPOTIFY_PACKAGE + ".metadatachanged";
    private ScrobblipyPreferences prefs;

    int positionInMs = 0;
    int trackLengthInSec = 0;


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(LOG_TAG, "Spotify");
        String action = intent.getAction();
        String msg = "Nothing";
        prefs = new ScrobblipyPreferences(context);

        trackLengthInSec = prefs.getTrackLengh();


        if (action.equals(METADATA_CHANGED)) {
            String artistName = intent.getStringExtra("artist");
            String albumName = intent.getStringExtra("album");
            String trackName = intent.getStringExtra("track");
            trackLengthInSec = intent.getIntExtra("length", 0);

            msg = "Song: " + trackName +" from: " + albumName + " by: " + artistName + " length " + trackLengthInSec;

            // Preferencias
            prefs.setTrackLength(trackLengthInSec);
            prefs.setTrackName(trackName);
            prefs.setTrackArtist(artistName);
            prefs.setTrackAlbum(albumName);

            startMainActivity(context);
        } else if (action.equals(PLAYBACK_STATE_CHANGED)) {
            boolean playing = intent.getBooleanExtra("playing", false);
            positionInMs = intent.getIntExtra("playbackPosition", 0);

            if (playing) {
                msg = "Playing";
                prefs.setScrobblingState(true);
            } else {
                msg = "Stop";
                prefs.setScrobblingState(false);
            }
            startMainActivity(context);

            msg += " Current position: " + positionInMs;

        }

        if((positionInMs >= (trackLengthInSec / 2)) && (trackLengthInSec > 0))
            Log.d(LOG_TAG, "Let's scrobbling");
        else
            Log.d(LOG_TAG, "Must be major or equals playing time");

        Log.i(LOG_TAG, msg);
    }
    // Se ejecuta si se cambia de cancion o se hace pausa o start para actualizar MainActivity
    public void startMainActivity(Context context){
        if(ScrobblipyApplication.getActivityVisible()){
            Intent intent2open = new Intent(context, MainActivity.class);
            intent2open.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent2open.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            context.startActivity(intent2open);
        }
    }

}
