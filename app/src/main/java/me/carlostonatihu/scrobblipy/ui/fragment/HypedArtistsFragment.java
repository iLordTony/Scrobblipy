package me.carlostonatihu.scrobblipy.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.carlostonatihu.scrobblipy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HypedArtistsFragment extends Fragment {
    private RecyclerView mRecyclerHypedArtists;
    private static final int NUM_COLLUMS = 2;

    public HypedArtistsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hyped_artists, container, false);
        mRecyclerHypedArtists = (RecyclerView) view.findViewById(R.id.recycler_hyped_artists);
        setupRecyclerArtists();
        return view;
    }

    private void setupRecyclerArtists () {
        mRecyclerHypedArtists.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLLUMS));
    }

}
