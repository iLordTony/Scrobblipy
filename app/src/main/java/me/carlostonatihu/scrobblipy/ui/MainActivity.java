package me.carlostonatihu.scrobblipy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import me.carlostonatihu.scrobblipy.R;
import me.carlostonatihu.scrobblipy.ui.fragment.EventsFragment;
import me.carlostonatihu.scrobblipy.ui.fragment.HomeFragment;
import me.carlostonatihu.scrobblipy.ui.fragment.HypedArtistsFragment;
import me.carlostonatihu.scrobblipy.ui.fragment.ScrobblesFragment;
import me.carlostonatihu.scrobblipy.ui.fragment.TopAlbumsFragment;
import me.carlostonatihu.scrobblipy.ui.fragment.TopArtistsFragment;
import me.carlostonatihu.scrobblipy.ui.fragment.TopTracksFragment;
import me.carlostonatihu.scrobblipy.util.ScrobblipyApplication;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private DrawerLayout drawerLayout;
    private int mNavItemId;


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

        if (null == savedInstanceState) {
            mNavItemId = R.id.nav_home;
        }
        selectItem(mNavItemId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ScrobblipyApplication.setActivityVisible(true);
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
            // Poner ícono del drawer toggle
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
                        mNavItemId = menuItem.getItemId();
                        setTitle(title);
                        drawerLayout.closeDrawers();
                        return selectItem(mNavItemId);
                    }
                }
        );
    }

    private boolean selectItem(int menuItem) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (menuItem) {
            case R.id.nav_home:
                HomeFragment mainFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.main_container, mainFragment);
                fragmentTransaction.commit();
                return true;
            case R.id.nav_events:
                EventsFragment eventsFragmentFragment = new EventsFragment();
                fragmentTransaction.replace(R.id.main_container, eventsFragmentFragment);
                fragmentTransaction.commit();
                return true;
            case R.id.nav_music:
                HypedArtistsFragment hypedArtistsFragment = new HypedArtistsFragment();
                fragmentTransaction.replace(R.id.main_container, hypedArtistsFragment);
                fragmentTransaction.commit();
                return true;
            case R.id.nav_scrobbles:
                ScrobblesFragment scrobblesFragmentFragmentFragment = new ScrobblesFragment();
                fragmentTransaction.replace(R.id.main_container, scrobblesFragmentFragmentFragment);
                fragmentTransaction.commit();
                return true;
            case R.id.nav_top_tracks:
                TopTracksFragment hypedArtistsFragmentFragment = new TopTracksFragment();
                fragmentTransaction.replace(R.id.main_container, hypedArtistsFragmentFragment);
                fragmentTransaction.commit();
                return true;
            case R.id.nav_top_artist:
                TopArtistsFragment topArtistsFragment = new TopArtistsFragment();
                fragmentTransaction.replace(R.id.main_container, topArtistsFragment);
                fragmentTransaction.commit();
                return true;
            case R.id.nav_top_albums:
                TopAlbumsFragment topAlbumsFragment = new TopAlbumsFragment();
                fragmentTransaction.replace(R.id.main_container, topAlbumsFragment);
                fragmentTransaction.commit();
                return true;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                return true;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}