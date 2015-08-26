package me.carlostonatihu.scrobblipy.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.carlostonatihu.scrobblipy.R;
import me.carlostonatihu.scrobblipy.ui.MainActivity;
import me.carlostonatihu.scrobblipy.util.ScrobblipyApplication;
import me.carlostonatihu.scrobblipy.util.ScrobblipyPreferences;

/**
 * A simple {@link Fragment} subclass.
 * Aqui van estar las recomendaciones de canciones, albums, artistas y eventos
 */
public class HomeFragment extends Fragment {
    private ScrobblipyPreferences prefs;
    private TextView mTextSong;

    private static final String LOG_TAG = HomeFragment.class.getSimpleName();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        
        if(context instanceof MainActivity)
            Log.i(LOG_TAG, "It's attached?, yes");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new ScrobblipyPreferences(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();

        if(prefs.getScrobblingState())
            mTextSong.setText("Scrobbling " + prefs.getTrackName());
        else
            mTextSong.setText("Nada90");

        Log.d(LOG_TAG, "Valor " + ScrobblipyApplication.getActivityVisible());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mTextSong = (TextView) view.findViewById(R.id.text_song);
        return view;
    }


}
