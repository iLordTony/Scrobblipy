package me.carlostonatihu.scrobblipy.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.carlostonatihu.scrobblipy.R;
import me.carlostonatihu.scrobblipy.domain.Artist;
import me.carlostonatihu.scrobblipy.io.LastFmApiAdapter;
import me.carlostonatihu.scrobblipy.io.model.HypedArtistsResponse;
import me.carlostonatihu.scrobblipy.ui.ItemOffsetDecoration;
import me.carlostonatihu.scrobblipy.ui.adapter.HypedArtistsAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HypedArtistsFragment extends Fragment implements Callback<HypedArtistsResponse> {

    private RecyclerView mRecyclerHypedArtists;
    private static final int NUM_COLLUMS = 2;
    private HypedArtistsAdapter adapter;

    public HypedArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HypedArtistsAdapter(getActivity());
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
        mRecyclerHypedArtists.setAdapter(adapter);
        //mRecyclerHypedArtists.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
    }

    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getApiService().getHypedArtists(this);
    }

    @Override
    public void success(HypedArtistsResponse hypedArtistsResponse, Response response) {
        adapter.addAll(hypedArtistsResponse.getArtists());
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}
