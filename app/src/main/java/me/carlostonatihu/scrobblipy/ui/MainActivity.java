package me.carlostonatihu.scrobblipy.ui;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
    private DrawerLayout drawerLayout;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        mTextSong = (TextView) findViewById(R.id.text_song);
        prefs = new ScrobblipyPreferences(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ScrobblipyApplication.setActivityVisible(true);
        if(prefs.getScrobblingState())
            mTextSong.setText("Scrobbling " + prefs.getTrackName());
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
    protected void onNewIntent(Intent intent) {
        Log.d(LOG_TAG, "onNewIntent is called!");
        super.onNewIntent(intent);
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        String title = menuItem.getTitle().toString();
                        drawerLayout.closeDrawers();
                        setTitle(title);

                        return true;
                    }
                }
        );
    }
}