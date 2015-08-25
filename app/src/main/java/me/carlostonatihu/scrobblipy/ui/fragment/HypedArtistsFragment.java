package me.carlostonatihu.scrobblipy.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.carlostonatihu.scrobblipy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HypedArtistsFragment extends Fragment {


    public HypedArtistsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hyped_artists, container, false);
        return view;
    }


}
