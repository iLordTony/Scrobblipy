package me.carlostonatihu.scrobblipy.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.carlostonatihu.scrobblipy.R;
import me.carlostonatihu.scrobblipy.ui.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Aqui van estar las recomendaciones de canciones, albums, artistas y eventos
 */
public class HomeFragment extends Fragment {


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


}
