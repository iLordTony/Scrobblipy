package me.carlostonatihu.scrobblipy.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import me.carlostonatihu.scrobblipy.R;
import me.carlostonatihu.scrobblipy.util.ScrobblipyApplication;
import me.carlostonatihu.scrobblipy.util.ScrobblipyPreferences;

public class MainActivity extends AppCompatActivity {

    private TextView mTextSong;
    private ScrobblipyPreferences prefs;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextSong = (TextView) findViewById(R.id.text_song);
        prefs = new ScrobblipyPreferences(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ScrobblipyApplication.setActivityVisible(true);
        if(prefs.getScrobblingState())
            mTextSong.setText("Scrobbling " + prefs.getTrackData());
        else
            mTextSong.setText("Nada90");

        Log.d(LOG_TAG, "Valor " + ScrobblipyApplication.getActivityVisible());

    }


    @Override
    protected void onPause() {
        super.onPause();
        ScrobblipyApplication.setActivityVisible(false);
        Log.d(LOG_TAG, "Valor" + ScrobblipyApplication.getActivityVisible());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d(LOG_TAG, "onNewIntent is called!");
        super.onNewIntent(intent);
    }
}